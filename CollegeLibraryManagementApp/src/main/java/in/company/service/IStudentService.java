package in.company.service;

import java.util.List;

import in.company.dto.Student;

public interface IStudentService {

	public String addStudent(Student student);
	
	public List<Student> showAllStudents();
	
	public Student searchStudent(Integer sId);
}
