package in.company.daofactory;

import in.company.dao.ILibraryTransaction;
import in.company.dao.LibraryTransactionImpl;

public class LibraryTransactionDaoFactory {

	private static ILibraryTransaction libraryTransactiondao=null;
	
	private LibraryTransactionDaoFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static ILibraryTransaction getLibraryTransactionDaoService() {
		if(libraryTransactiondao==null) {
			libraryTransactiondao=new LibraryTransactionImpl();
		}
		return libraryTransactiondao;
	}
	
}
