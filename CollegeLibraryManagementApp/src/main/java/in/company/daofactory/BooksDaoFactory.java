package in.company.daofactory;

import in.company.dao.BooksDaoImpl;
import in.company.dao.IBooksDao;

public class BooksDaoFactory {

	private static IBooksDao booksDao=null;
	
	private BooksDaoFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static IBooksDao getBooksDao() {
		if(booksDao==null) {
			booksDao=new BooksDaoImpl();
		}
		return booksDao;
	}

}
