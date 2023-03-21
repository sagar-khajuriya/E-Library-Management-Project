package in.company.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.company.dto.Librarian;
import in.company.service.ILibrarianService;
import in.company.servicefactory.ServiceFactory;

@WebServlet("/controller/*")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ILibrarianService librarianService = null;
	private RequestDispatcher requestDispatcher = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);

	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getRequestURI().endsWith("register")) {
			librarianService = ServiceFactory.getLibrarianService();

			Librarian librarian = new Librarian();
			librarian.setLname(request.getParameter("lname"));
			librarian.setLmailid(request.getParameter("lmailid"));
			librarian.setLcontactno(request.getParameter("lcontactno"));
			librarian.setLpassword(request.getParameter("lpassword"));
			librarian.setLgender(request.getParameter("lgender"));

			String addLibrarian = librarianService.addLibrarian(librarian);

			request.setAttribute("addLibrarian", addLibrarian);
			requestDispatcher = request.getRequestDispatcher("/librarianInsertResponse.jsp");
			requestDispatcher.forward(request, response);

		}

		if (request.getRequestURI().endsWith("searchform")) {
			String lid = request.getParameter("lid");

			librarianService = ServiceFactory.getLibrarianService();
			Librarian searchLibrarian = librarianService.searchLibrarian(Integer.parseInt(lid));

			request.setAttribute("searchLibrarian", searchLibrarian);
			requestDispatcher = request.getRequestDispatcher("/librarianSearchResult.jsp");
			requestDispatcher.forward(request, response);

		}

		if (request.getRequestURI().endsWith("edit")) {

			librarianService = ServiceFactory.getLibrarianService();
			String lid = request.getParameter("lid");

			Librarian searchLibrarian = librarianService.searchLibrarian(Integer.parseInt(lid));

			request.setAttribute("searchLibrarian", searchLibrarian);
			requestDispatcher = request.getRequestDispatcher("../librarianEdit.jsp");
			requestDispatcher.forward(request, response);

		}

		if (request.getRequestURI().endsWith("update")) {

			librarianService = ServiceFactory.getLibrarianService();
			Librarian librarian = new Librarian();
			librarian.setLid(Integer.parseInt(request.getParameter("lid")));
			librarian.setLname(request.getParameter("lname"));
			librarian.setLmailid(request.getParameter("lmailid"));
			librarian.setLcontactno(request.getParameter("lcontactno"));
			librarian.setLpassword(request.getParameter("lpassword"));
			librarian.setLgender(request.getParameter("lgender"));

			String updateLibrarian = librarianService.updateLibrarian(librarian);

			request.setAttribute("updateLibrarian", updateLibrarian);
			requestDispatcher = request.getRequestDispatcher("../../librarianUpdateResponse.jsp");
			requestDispatcher.forward(request, response);

		}

		if (request.getRequestURI().endsWith("delete")) {
			String lid = request.getParameter("lid");

			librarianService = ServiceFactory.getLibrarianService();
			String deleteLibrarian = librarianService.deleteLibrarian(Integer.parseInt(lid));

			request.setAttribute("deleteLibrarian", deleteLibrarian);
			requestDispatcher = request.getRequestDispatcher("/librarianDeleteResult.jsp");
			requestDispatcher.forward(request, response);

		}

		if (request.getRequestURI().endsWith("showalllibrarian")) {

			librarianService = ServiceFactory.getLibrarianService();
			List<Librarian> showAllLibrarian = librarianService.showAllLibrarian();
			
			System.out.println(showAllLibrarian);

				request.setAttribute("showAllLibrarian", showAllLibrarian);
				requestDispatcher = request.getRequestDispatcher("../showalllibrarian.jsp");
				requestDispatcher.forward(request, response);
			
		}

	}

}
