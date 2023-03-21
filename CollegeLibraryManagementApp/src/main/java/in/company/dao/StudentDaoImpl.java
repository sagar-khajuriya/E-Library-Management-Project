package in.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.company.dto.Student;
import in.company.util.DBUtil;

public class StudentDaoImpl implements IStudentDao {

	private Connection connection = null;
	private PreparedStatement prepareStatement;
	private ResultSet resultSet;

	@Override
	public String addStudent(Student student) {
		String status = "fail";

		try {
			connection = DBUtil.getDataBaseConnectivity();

			if (connection != null) {
				String sqlInsertQuery = "insert into student (sname,mailid,contactno,password,gender,department,course,admissionyear,dob) values(?,?,?,?,?,?,?,?,?)";
				prepareStatement = connection.prepareStatement(sqlInsertQuery);
			}
			if (prepareStatement != null) {
				prepareStatement.setString(1, student.getSname());
				prepareStatement.setString(2, student.getMailid());
				prepareStatement.setString(3, student.getContactno());
				prepareStatement.setString(4, student.getPassword());
				prepareStatement.setString(5, student.getGender());
				prepareStatement.setString(6, student.getDepartment());
				prepareStatement.setString(7, student.getCourse());
				prepareStatement.setString(8, student.getAdmissionyear());
				prepareStatement.setString(9, student.getDob());

				int rowAffercted = prepareStatement.executeUpdate();

				if (rowAffercted == 1) {
					status = "success";
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBUtil.closeConnection(connection);
		}
		return status;
	}

	@Override
	public List<Student> showAllStudents() {
		List<Student> list = null;
		Student student = null;
		try {
			connection = DBUtil.getDataBaseConnectivity();

			if (connection != null) {
				String sqlSelectQuery = "select * from student";
				prepareStatement = connection.prepareStatement(sqlSelectQuery);
			}
			if (prepareStatement != null) {
				resultSet = prepareStatement.executeQuery();
			}
			if (resultSet != null) {
				list = new ArrayList<>();
				while (resultSet.next()) {
					student = new Student();
					student.setSid(resultSet.getInt(1));
					student.setSname(resultSet.getString(2));
					student.setMailid(resultSet.getString(3));
					student.setContactno(resultSet.getString(4));
					student.setPassword(resultSet.getString(5));
					student.setGender(resultSet.getString(6));
					student.setDepartment(resultSet.getString(7));
					student.setCourse(resultSet.getString(8));
					student.setAdmissionyear(resultSet.getString(9));
					student.setDob(resultSet.getString(2));
					list.add(student);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return list;
	}

	@Override
	public Student searchStudent(Integer sId) {
		Student student=null;
		try {
			connection = DBUtil.getDataBaseConnectivity();

			if (connection != null) {
				String sqlSelectQuery = "Select * from student where sid=?";
				prepareStatement = connection.prepareStatement(sqlSelectQuery);
			}
			if(prepareStatement!=null) {
				prepareStatement.setInt(1, sId);
				
				resultSet=prepareStatement.executeQuery();
			}
			if(resultSet!=null) {
				if(resultSet.next()) {
					student=new Student();
					student.setSid(resultSet.getInt(1));
					student.setSname(resultSet.getString(2));
					student.setMailid(resultSet.getString(3));
					student.setContactno(resultSet.getString(4));
					student.setPassword(resultSet.getString(5));
					student.setGender(resultSet.getString(6));
					student.setDepartment(resultSet.getString(7));
					student.setCourse(resultSet.getString(8));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return student;
	}

}
