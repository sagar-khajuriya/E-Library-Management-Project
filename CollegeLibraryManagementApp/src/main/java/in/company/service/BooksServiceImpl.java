package in.company.service;

import java.util.List;

import in.company.dao.IBooksDao;
import in.company.daofactory.BooksDaoFactory;
import in.company.dto.Books;

public class BooksServiceImpl implements IBooksService {

	IBooksDao booksDao = BooksDaoFactory.getBooksDao();
	@Override
	public String addBook(Books book) {
		return booksDao.addBook(book);
	}

	@Override
	public String deleteBook(Integer bookId) {
		// TODO Auto-generated method stub
		return booksDao.deleteBook(bookId);
	}

	@Override
	public String updateBook(Books book) {
		// TODO Auto-generated method stub
		return booksDao.updateBook(book);
	}

	@Override
	public List<Books> searchBook(Integer bookId,String author) {
		// TODO Auto-generated method stub
		return booksDao.searchBook(bookId,author);
	}

	@Override
	public List<Books> getAllBooks() {
		// TODO Auto-generated method stub
		return booksDao.getAllBooks();
	}

}
