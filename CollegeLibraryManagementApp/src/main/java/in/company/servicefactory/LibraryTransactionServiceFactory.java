package in.company.servicefactory;

import in.company.service.ILibraryTransactionService;
import in.company.service.LibraryTransactionServiceImpl;

public class LibraryTransactionServiceFactory {

	private static ILibraryTransactionService libTransactionService=null;
	
	private LibraryTransactionServiceFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static ILibraryTransactionService getLibraryTraansactionService() {
		if(libTransactionService==null) {
			libTransactionService=new LibraryTransactionServiceImpl();
		}
		return libTransactionService;
	}
	
	
}
