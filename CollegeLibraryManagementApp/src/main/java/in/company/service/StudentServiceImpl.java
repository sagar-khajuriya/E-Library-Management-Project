package in.company.service;

import java.util.List;

import in.company.dao.IStudentDao;
import in.company.daofactory.StudentDaoFactory;
import in.company.dto.Student;

public class StudentServiceImpl implements IStudentService {

	@Override
	public String addStudent(Student student) {
		IStudentDao studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.addStudent(student);
	}

	@Override
	public List<Student> showAllStudents() {
		IStudentDao studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.showAllStudents();
	}

	@Override
	public Student searchStudent(Integer sId) {
		IStudentDao studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.searchStudent(sId);
	}

}
