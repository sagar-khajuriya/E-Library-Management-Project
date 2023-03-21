package in.company.daofactory;

import in.company.dao.ILibrarianDao;
import in.company.dao.LibrarianDaoImpl;

public class DaoFactory {

	private static ILibrarianDao libDao=null;
	
	private DaoFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static ILibrarianDao getLibrarianDao() {
		if(libDao==null) {
			libDao=new LibrarianDaoImpl();
		}
		return libDao;
	}
	
}
