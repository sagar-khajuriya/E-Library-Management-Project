package in.company.daofactory;

import in.company.dao.ILoginDao;
import in.company.dao.LoginDaoImpl;

public class LoginDaoFactory {

	private static ILoginDao loginDao=null;
	
	private LoginDaoFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static ILoginDao getLoginDao() {
		if(loginDao==null) {
			loginDao=new LoginDaoImpl();
		}
		return loginDao;
	}
}
