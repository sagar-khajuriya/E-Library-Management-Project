package in.company.daofactory;

import in.company.dao.IStudentDao;
import in.company.dao.StudentDaoImpl;

public class StudentDaoFactory {

	private static IStudentDao studDao;
	
	public static IStudentDao getStudentDao() {
		if(studDao==null) {
			studDao=new StudentDaoImpl();
		}
		return studDao;
	}
	
}
