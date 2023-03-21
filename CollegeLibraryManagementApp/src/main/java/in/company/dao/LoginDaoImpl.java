package in.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.company.util.DBUtil;

public class LoginDaoImpl implements ILoginDao {

	private Connection connection=null;
	private PreparedStatement prepareStatement;
	private ResultSet resultSet;
	@Override
	public String adminLogin(int id, String password) {
		String status="fail";
		try {
			connection=DBUtil.getDataBaseConnectivity();
		
		if(connection!=null) {
			String sqlQuery="select id,password from admin where id=? and password=?";
			prepareStatement = connection.prepareStatement(sqlQuery);
		}
		if(prepareStatement!=null) {
			prepareStatement.setInt(1, id);
			prepareStatement.setString(2, password);
			
			resultSet = prepareStatement.executeQuery();
		}
		if(resultSet!=null) {
			if(resultSet.next()) {
				status="success";
			}
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status ;
	}

	@Override
	public String librarianLogin(int id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
