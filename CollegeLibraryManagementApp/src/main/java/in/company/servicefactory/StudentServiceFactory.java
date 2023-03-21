package in.company.servicefactory;

import in.company.service.IStudentService;
import in.company.service.StudentServiceImpl;

public class StudentServiceFactory {

	private static IStudentService studService;
	
	public static IStudentService getStudentService() {
		if(studService==null) {
			studService=new StudentServiceImpl();
		}
		return studService;
	}
	
}
