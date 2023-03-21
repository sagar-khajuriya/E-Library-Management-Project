package in.company.servicefactory;

import in.company.service.ILoginService;
import in.company.service.LoginServiceImpl;

public class LoginServiceFactory {

	private static ILoginService loginService=null;
	
	private LoginServiceFactory() {
	}

	public static ILoginService getLoginService() {
		if(loginService==null) {
			loginService=new LoginServiceImpl();
		}
		return loginService;
	}
	
}
