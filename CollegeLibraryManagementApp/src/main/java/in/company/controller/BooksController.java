package in.company.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.company.dto.Books;
import in.company.service.IBooksService;
import in.company.servicefactory.BooksServiceFactory;

@WebServlet(urlPatterns = "/bookscontroller/*")
public class BooksController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IBooksService booksService = null;
	RequestDispatcher requestDispatcher = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getRequestURI().endsWith("addbook")) {
			booksService = BooksServiceFactory.getBooksService();
			Books book = new Books();
			book.setBookId(Integer.parseInt(request.getParameter("bid")));
			book.setBookName(request.getParameter("bname"));
			book.setSubject(request.getParameter("subject"));
			book.setAuthor(request.getParameter("author"));
			book.setTitle(request.getParameter("title"));
			book.setCategory(request.getParameter("category"));
			book.setQty(Integer.parseInt(request.getParameter("quantity")));

			String addBook = booksService.addBook(book);
			System.out.println(addBook);
			request.setAttribute("addBook", addBook);
			requestDispatcher = request.getRequestDispatcher("../booksinsertresponse.jsp");
			requestDispatcher.forward(request, response);

		}

		if (request.getRequestURI().endsWith("searchbook")) {
			booksService = BooksServiceFactory.getBooksService();
			Integer ibid=0;
			String bid = request.getParameter("bid");
			try {
			ibid=Integer.parseInt(bid);
			}catch(Exception e) {
				ibid=0;
			}
			List<Books> searchBook = booksService.searchBook(ibid,bid);

			request.setAttribute("searchBook", searchBook);
			requestDispatcher=request.getRequestDispatcher("../bookssearchresponse.jsp");
			requestDispatcher.forward(request, response);
		}
		
		
		if (request.getRequestURI().endsWith("deletebook")) {
			booksService = BooksServiceFactory.getBooksService();
			Integer bid = Integer.parseInt(request.getParameter("bid"));

			String deleteBook = booksService.deleteBook(bid);

			request.setAttribute("deleteBook", deleteBook);
			requestDispatcher=request.getRequestDispatcher("../booksdeleteresponse.jsp");
			requestDispatcher.forward(request, response);
		}
		
		if (request.getRequestURI().endsWith("showbooks.jsp")) {
			booksService = BooksServiceFactory.getBooksService();

			List<Books> allBooks = booksService.getAllBooks();
			request.setAttribute("allBooks", allBooks);
			requestDispatcher=request.getRequestDispatcher("../showallbooks.jsp");
			requestDispatcher.forward(request, response);
		}
	
		if (request.getRequestURI().endsWith("searchbookforupdate")) {
			booksService = BooksServiceFactory.getBooksService();
			Integer bid =Integer.parseInt(request.getParameter("bid"));

			List<Books> searchBook = booksService.searchBook(bid,"");

			request.setAttribute("searchBook", searchBook);
			requestDispatcher=request.getRequestDispatcher("../editbook.jsp");
			requestDispatcher.forward(request, response);
		}

		if (request.getRequestURI().endsWith("updatebook")) {
			booksService = BooksServiceFactory.getBooksService();
				
			Books book = new Books();
			book.setBookId(Integer.parseInt(request.getParameter("bid")));
			book.setBookName(request.getParameter("bname"));
			book.setSubject(request.getParameter("subject"));
			book.setAuthor(request.getParameter("author"));
			book.setTitle(request.getParameter("title"));
			book.setCategory(request.getParameter("category"));
			book.setQty(Integer.parseInt(request.getParameter("quantity")));

			String updateBook = booksService.updateBook(book);
			request.setAttribute("updateBook", updateBook);
			requestDispatcher = request.getRequestDispatcher("../../booksupdateresponse.jsp");
			requestDispatcher.forward(request, response);

		
		}
		
	}

}
