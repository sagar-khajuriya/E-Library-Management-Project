package in.company.dao;

import java.util.List;

import in.company.dto.Books;

public interface IBooksDao {

	public String addBook(Books book);

	public String deleteBook(Integer bookId);

	public String updateBook(Books book);

	public List<Books> searchBook(Integer bookId, String author);

	public List<Books> getAllBooks();

}
