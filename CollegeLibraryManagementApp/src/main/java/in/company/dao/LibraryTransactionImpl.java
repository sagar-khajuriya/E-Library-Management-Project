package in.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import in.company.dto.LibraryTransaction;
import in.company.util.DBUtil;

public class LibraryTransactionImpl implements ILibraryTransaction {

	private Connection connection = null;
	private PreparedStatement prepareStatement1 = null;
	private PreparedStatement prepareStatement2 = null;
	private PreparedStatement prepareStatement3 = null;
	private PreparedStatement prepareStatement4 = null;
	private ResultSet resultSet1 = null;
	private ResultSet resultSet2 = null;
	private ResultSet resultSet4 = null;

	@Override
	public String issueBook(LibraryTransaction libTranc) {

		try {
			connection = DBUtil.getDataBaseConnectivity();

			if (connection != null) {
				String sqlStudentSelectQuery = "select sid from student where sid=?";
				prepareStatement1 = connection.prepareStatement(sqlStudentSelectQuery);
				String sqlBookSelectQuery = "select bookid from books where bookid=?";
				prepareStatement2 = connection.prepareStatement(sqlBookSelectQuery);
				String sqlInsertQery = "insert into library_transaction (sid,bid,issuedate,duedate) values (?,?,?,?)";
				prepareStatement3 = connection.prepareStatement(sqlInsertQery);
				String sqlSelectBookQuery = "select * from booklimit where sid=?";
				prepareStatement4 = connection.prepareStatement(sqlSelectBookQuery);
			}

			if (prepareStatement1 != null) {
				prepareStatement1.setInt(1, libTranc.getsId());
				resultSet1 = prepareStatement1.executeQuery();

				boolean next = resultSet1.next();
				if (!next) {
					return "sidNotFound";
				}
			}

			if (prepareStatement2 != null) {
				prepareStatement2.setInt(1, libTranc.getbId());
				resultSet2 = prepareStatement2.executeQuery();

				boolean next = resultSet2.next();
				if (!next) {
					return "bidNotFound";
				}
			}

			if (prepareStatement4 != null) {
				prepareStatement4.setInt(1, libTranc.getsId());
				resultSet4 = prepareStatement4.executeQuery();
				if (resultSet4.next()) {
					int limit = resultSet4.getInt("limit");
					System.out.println("limit1 " + limit);
					if (limit < 3) {
						// update
						limit = limit + 1;
						String sqlUpdateQuery = "UPDATE `booklimit` SET `limit` = ? WHERE (`sid` = ?)";
						PreparedStatement pstmt1 = connection.prepareStatement(sqlUpdateQuery);
						pstmt1.setInt(1, limit);
						pstmt1.setInt(2, libTranc.getsId());

						pstmt1.executeUpdate();

					} else {
						return "limit exceed";
					}
				} else {
					// insert

					String sqlInsertQuery = "insert into booklimit (`sid`,`limit`) values (?,?)";
					int limit = 1;
					PreparedStatement pstmt2 = connection.prepareStatement(sqlInsertQuery);
					pstmt2.setInt(1, libTranc.getsId());
					pstmt2.setInt(2, limit);
					pstmt2.executeUpdate();

				}
			}

			if (prepareStatement3 != null) {
				prepareStatement3.setInt(1, libTranc.getsId());
				prepareStatement3.setInt(2, libTranc.getbId());
				prepareStatement3.setString(3, libTranc.getIssueDate());
				prepareStatement3.setString(4, libTranc.getDueDate());

				int rowAffected = prepareStatement3.executeUpdate();

				if (rowAffected == 1) {
					return "success";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (resultSet1 != null && resultSet2 != null && resultSet4 != null) {
					resultSet1.close();
					resultSet2.close();
					resultSet4.close();
				}
				if (prepareStatement1 != null && prepareStatement2 != null && prepareStatement3 != null
						&& prepareStatement4 != null) {
					prepareStatement1.close();
					prepareStatement2.close();
					prepareStatement3.close();
					prepareStatement4.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return null;
	}

	@Override
	public String submitBook(Integer sId, Integer bId, String submitDate) {
		PreparedStatement prepareStatement11 = null;
		PreparedStatement prepareStatement22 = null;
		PreparedStatement prepareStatement33 = null;
		ResultSet resultSet11 = null;
		try {
			connection = DBUtil.getDataBaseConnectivity();

			if (connection != null) {
				String sqlSelectQuery = "select `sid`,`bid`,`issuedate`,`duedate`,`submitdate` from library_transaction where `sid`=? and `bid`=?;";
				prepareStatement11 = connection.prepareStatement(sqlSelectQuery);
			}
			if (prepareStatement11 != null) {
				prepareStatement11.setInt(1, sId);
				prepareStatement11.setInt(2, bId);

				resultSet11 = prepareStatement11.executeQuery();
			}
			if (resultSet11 != null) {
				if (resultSet11.next()) {

					String subDate = resultSet11.getString("submitdate");
					if (subDate == null) {

						prepareStatement33 = connection
								.prepareStatement("update `booklimit` set `limit`=`limit`-1 where `sid`=?");
						if (prepareStatement33 != null) {
							prepareStatement33.setInt(1, sId);

							prepareStatement33.executeUpdate();
						}

						String dueDate = resultSet11.getString(4);
						long dayDifference = DayDifference(submitDate, dueDate);
						int fine =0;
						
						if(dayDifference>=0) {
						fine= (int) (dayDifference) * 10;
						}
						
						String sqlInsertQuery = "UPDATE library_transaction SET `submitdate` = ?, `fine` = ? WHERE `sid`=? and `bid`=?";
						prepareStatement22 = connection.prepareStatement(sqlInsertQuery);

						if (prepareStatement22 != null) {
							prepareStatement22.setString(1, submitDate);
							prepareStatement22.setInt(2, fine);
							prepareStatement22.setInt(3, sId);
							prepareStatement22.setInt(4, bId);

							int rowAffected = prepareStatement22.executeUpdate();
							if (rowAffected == 1) {
								return "success";
							}
						}

					} else {
						return "book already submitted";
					}
				} else {
					return "fail";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private long DayDifference(String submitDate, String dueDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dDate = sdf.parse(dueDate);
		Date sDate = sdf.parse(submitDate);

		long timeDifference = sDate.getTime() - dDate.getTime();
		long dayDifference = (timeDifference / (1000 * 60 * 60 * 24)) % 365;
		return dayDifference;
	}

	@Override
	public List<LibraryTransaction> showAllLibraryTransaction() {
		List<LibraryTransaction> list=null;
		LibraryTransaction libraryTransaction=null;
		try {
			
			connection=DBUtil.getDataBaseConnectivity();
			
			if(connection!=null) {
				prepareStatement1=connection.prepareStatement("select sid,bid,issuedate,duedate,submitdate,fine from library_Transaction");
			}
			if(prepareStatement1!=null) {
				resultSet1= prepareStatement1.executeQuery();
			}
			if(resultSet1!=null) {
				list=new ArrayList<>();
				while(resultSet1.next()) {
					libraryTransaction=new LibraryTransaction();
					libraryTransaction.setsId(resultSet1.getInt("sid"));
					libraryTransaction.setbId(resultSet1.getInt("bid"));
					libraryTransaction.setIssueDate(resultSet1.getString("issuedate"));
					libraryTransaction.setDueDate(resultSet1.getString("duedate"));
					libraryTransaction.setSubmitDate(resultSet1.getString("submitdate"));
					libraryTransaction.setFine(resultSet1.getInt("fine"));
					
					list.add(libraryTransaction);
					
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
