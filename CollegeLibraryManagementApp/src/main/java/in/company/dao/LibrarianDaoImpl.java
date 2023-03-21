package in.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.company.dto.Librarian;
import in.company.util.DBUtil;

public class LibrarianDaoImpl implements ILibrarianDao {

	private Connection connection = null;
	private PreparedStatement prepareStatement = null;
	private ResultSet resultSet = null;

	@Override
	public String addLibrarian(Librarian lib) {
		System.out.println(lib);
		String status = "fail";
		String sqlInsertQuery = "insert into librarian (name,email,contact,password,gender) values (?,?,?,?,?)";

		try {
			connection = DBUtil.getDataBaseConnectivity();

			if (connection != null) {
				prepareStatement = connection.prepareStatement(sqlInsertQuery);
			}
			if (prepareStatement != null) {
				prepareStatement.setString(1, lib.getLname());
				prepareStatement.setString(2, lib.getLmailid());
				prepareStatement.setString(3, lib.getLcontactno());
				prepareStatement.setString(4, lib.getLpassword());
				prepareStatement.setString(5, lib.getLgender());

				int rowAffected = prepareStatement.executeUpdate();

				if (rowAffected == 1) {
					status = "success";
					System.out.println("flow in success if");
				} else {
					status = "fail";
					System.out.println("flow in fail else");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public String updateLibrarian(Librarian lib) {

		try {
			connection = DBUtil.getDataBaseConnectivity();

			if (connection != null) {
				String sqlUpdateQuery = "update librarian set name=?, email=?, contact=?,password=?,gender=? where id=?";
				prepareStatement = connection.prepareStatement(sqlUpdateQuery);
			}
			if (prepareStatement != null) {
				prepareStatement.setString(1, lib.getLname());
				prepareStatement.setString(2, lib.getLmailid());
				prepareStatement.setString(3, lib.getLcontactno());
				prepareStatement.setString(4, lib.getLpassword());
				prepareStatement.setString(5, lib.getLgender());
				prepareStatement.setInt(6, lib.getLid());

				int rowAffected = prepareStatement.executeUpdate();

				if (rowAffected == 1) {
					return "success";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public String deleteLibrarian(Integer lid) {
		String status = "fail";
		String sqlDeleteQuery = "delete from librarian where id=?";

		try {
			connection = DBUtil.getDataBaseConnectivity();

			if (connection != null) {
				prepareStatement = connection.prepareStatement(sqlDeleteQuery);
			}
			if (prepareStatement != null) {
				prepareStatement.setInt(1, lid);

				int rowAffected = prepareStatement.executeUpdate();

				if (rowAffected == 1) {
					status = "success";
				} else {
					status = "fail";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Librarian searchLibrarian(Integer lid) {
		Librarian librarian = null;
		String sqlSelectQuery = "select id,name,email,contact,password,gender from librarian where id=?";

		try {
			connection = DBUtil.getDataBaseConnectivity();

			if (connection != null) {
				prepareStatement = connection.prepareStatement(sqlSelectQuery);
			}
			if (prepareStatement != null) {
				prepareStatement.setInt(1, lid);

				resultSet = prepareStatement.executeQuery();
			}
			if (resultSet != null) {
				if (resultSet.next()) {
					librarian = new Librarian();
					librarian.setLid(resultSet.getInt(1));
					librarian.setLname(resultSet.getString(2));
					librarian.setLmailid(resultSet.getString(3));
					librarian.setLcontactno(resultSet.getString(4));
					librarian.setLpassword(resultSet.getString(5));
					librarian.setLgender(resultSet.getString(6));

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return librarian;
	}

	@Override
	public String loginLibrarian(Integer id, String password) {
		String status = "fail";
		try {
			connection = DBUtil.getDataBaseConnectivity();

			if (connection != null) {
				String sqlSelectQuery = "select id,password from librarian where id=? and password=?";
				prepareStatement = connection.prepareStatement(sqlSelectQuery);
			}
			if (prepareStatement != null) {
				prepareStatement.setInt(1, id);
				prepareStatement.setString(2, password);

				resultSet = prepareStatement.executeQuery();
			}
			if (resultSet != null) {
				if (resultSet.next()) {
					status = "success";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public List<Librarian> showAllLibrarian() {
		List<Librarian> list = null;
		Librarian librarian = null;

		try {
			connection = DBUtil.getDataBaseConnectivity();

			if (connection != null) {
				String sqlSelectQuery = "select id,name,email,contact,password,gender from librarian";
				prepareStatement = connection.prepareStatement(sqlSelectQuery);
			}
			if (prepareStatement != null) {
				resultSet = prepareStatement.executeQuery();
			}
			if (resultSet != null) {
				list = new ArrayList<>();
				while (resultSet.next()) {
					librarian = new Librarian();
					librarian.setLid(resultSet.getInt(1));
					librarian.setLname(resultSet.getString(2));
					librarian.setLmailid(resultSet.getString(3));
					librarian.setLcontactno(resultSet.getString(4));
					librarian.setLpassword(resultSet.getString(5));
					librarian.setLgender(resultSet.getString(6));

					list.add(librarian);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
