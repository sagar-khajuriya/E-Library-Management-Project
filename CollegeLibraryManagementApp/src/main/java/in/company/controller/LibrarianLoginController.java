package in.company.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.company.service.ILibrarianService;
import in.company.service.ILoginService;
import in.company.servicefactory.LoginServiceFactory;
import in.company.servicefactory.ServiceFactory;

@WebServlet("/librarianlogincontroller")
public class LibrarianLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher requestDispatcher = null;

		Integer lid =Integer.parseInt(request.getParameter("lid"));
		String lpassword = request.getParameter("lpassword");

		HttpSession session = request.getSession();
		
		ILibrarianService librarianService = ServiceFactory.getLibrarianService();
		String loginLibrarian = librarianService.loginLibrarian(lid, lpassword);
		System.out.println(loginLibrarian);
		if (loginLibrarian.equals("success")) {
			request.setAttribute("lid", lid);
			session.setAttribute("loginLibrarian", loginLibrarian);
			requestDispatcher = request.getRequestDispatcher("librarianwindow.jsp");
			requestDispatcher.forward(request, response);
		} else {
			session.setAttribute("loginLibrarian", loginLibrarian);
			requestDispatcher = request.getRequestDispatcher("librarianlogin.jsp");
			requestDispatcher.forward(request, response);

		}

	}

}
