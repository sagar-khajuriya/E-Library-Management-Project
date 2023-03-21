package in.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.company.dto.Books;
import in.company.util.DBUtil;

public class BooksDaoImpl implements IBooksDao {

	private Connection connection = null;
	private PreparedStatement prepareStatement = null;
	private ResultSet resultSet = null;

	@Override
	public String addBook(Books book) {
		String status = "fail";
		String insertBookQuery = "insert into books (bookid,bookname,subject,author,title,category,qty)values(?,?,?,?,?,?,?)";
		try {
			connection = DBUtil.getDataBaseConnectivity();

			if (connection != null) {
				prepareStatement = connection.prepareStatement(insertBookQuery);
			}
			if (prepareStatement != null) {
				prepareStatement.setInt(1, book.getBookId());
				prepareStatement.setString(2, book.getBookName());
				prepareStatement.setString(3, book.getSubject());
				prepareStatement.setString(4, book.getAuthor());
				prepareStatement.setString(5, book.getTitle());
				prepareStatement.setString(6, book.getCategory());
				prepareStatement.setInt(7, book.getQty());

				int rowAffected = prepareStatement.executeUpdate();

				if (rowAffected == 1) {
					return "success";
				} else {
					return "fail";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(connection);
		}

		return status;
	}

	@Override
	public String deleteBook(Integer bookId) {
		String status = "fail";
		String deleteBookQuery = "delete from books where bookid=?";
		try {
			connection = DBUtil.getDataBaseConnectivity();

			if (connection != null) {
				prepareStatement = connection.prepareStatement(deleteBookQuery);
			}
			if (prepareStatement != null) {
				prepareStatement.setInt(1, bookId);
				int rowAffected = prepareStatement.executeUpdate();

				if (rowAffected == 1) {
					return "success";
				} else {
					return "fail";
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(connection);
		}


		return status;
	}

	@Override
	public String updateBook(Books book) {
		String status="fail";
		connection = DBUtil.getDataBaseConnectivity();
		try {

			if (connection != null) {
				String sqlUpdateQuery = "update books set bookname=?,subject=?,author=?,title=?,category=?,qty=? where bookid=?";
				prepareStatement=connection.prepareStatement(sqlUpdateQuery);
			}
			if(prepareStatement!=null) {
				prepareStatement.setString(1, book.getBookName());
				prepareStatement.setString(2, book.getSubject());
				prepareStatement.setString(3, book.getAuthor());
				prepareStatement.setString(4, book.getTitle());
				prepareStatement.setString(5, book.getCategory());
				prepareStatement.setInt(6, book.getQty());
				prepareStatement.setInt(7, book.getBookId());
				
				int rowAffected = prepareStatement.executeUpdate();
				
				if(rowAffected==1) {
					status="success";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(connection);
		}

		return status;
	}

	@Override
	public List<Books> searchBook(Integer bookId,String author) {
		List<Books> list = null;
		String selectBookSearchQuery = "select bookid,bookname,subject,author,title,category,qty from books where bookid=? or author=?";
		try {
			connection = DBUtil.getDataBaseConnectivity();

			if (connection != null) {
				prepareStatement = connection.prepareStatement(selectBookSearchQuery);
			}
			if (prepareStatement != null) {
				prepareStatement.setInt(1, bookId);
				prepareStatement.setString(2, author);
				
				resultSet = prepareStatement.executeQuery();
			}
			if (resultSet != null) {
				Books books = null;
				list=new ArrayList<>();
				while (resultSet.next()) {
					books = new Books();
					books.setBookId(resultSet.getInt(1));
					books.setBookName(resultSet.getString(2));
					books.setSubject(resultSet.getString(3));
					books.setAuthor(resultSet.getString(4));
					books.setTitle(resultSet.getString(5));
					books.setCategory(resultSet.getString(6));
					books.setQty(resultSet.getInt(7));
					list.add(books);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(connection);
		}


		return list;
	}

	@Override
	public List<Books> getAllBooks() {

		List<Books> list = new ArrayList<>();
		String selectBookSearchQuery = "select bookid,bookname,subject,author,title,category,qty from books";
		try {
			connection = DBUtil.getDataBaseConnectivity();

			if (connection != null) {
				prepareStatement = connection.prepareStatement(selectBookSearchQuery);
			}
			if (prepareStatement != null) {

				resultSet = prepareStatement.executeQuery();
			}
			if (resultSet != null) {
				Books books = null;
				while (resultSet.next()) {
					books = new Books();
					books.setBookId(resultSet.getInt(1));
					books.setBookName(resultSet.getString(2));
					books.setSubject(resultSet.getString(3));
					books.setAuthor(resultSet.getString(4));
					books.setTitle(resultSet.getString(5));
					books.setCategory(resultSet.getString(6));
					books.setQty(resultSet.getInt(7));
					list.add(books);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(connection);
		}

		return list;
	}
	
		
}
