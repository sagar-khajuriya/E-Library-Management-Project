package in.company.dao;

import java.util.List;

import in.company.dto.Student;

public interface IStudentDao {

	public String addStudent(Student student);
	
	public List<Student> showAllStudents();
	
	public Student searchStudent(Integer sId);
}
