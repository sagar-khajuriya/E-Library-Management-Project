package in.company.servicefactory;

import in.company.service.BooksServiceImpl;
import in.company.service.IBooksService;

public class BooksServiceFactory {

	private static IBooksService booksService=null;
	
	private BooksServiceFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static IBooksService getBooksService() {
		if(booksService==null) {
			booksService=new BooksServiceImpl();
		}
		return booksService;
	}
	
}
