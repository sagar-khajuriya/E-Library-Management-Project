package in.company.service;

import in.company.dao.ILoginDao;
import in.company.daofactory.LoginDaoFactory;

public class LoginServiceImpl implements ILoginService {

	@Override
	public String librarianLogin(int id, String password) {
		return null;
	}

	@Override
	public String adminLogin(int id, String password) {
		ILoginDao loginDao = LoginDaoFactory.getLoginDao();
		return loginDao.adminLogin(id, password);
	}

}
