package in.company.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.company.service.ILoginService;
import in.company.servicefactory.LoginServiceFactory;

@WebServlet("/adminlogincontroller")
public class AdminLoginController extends HttpServlet {
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

		String aid = request.getParameter("aid");
		String apassword = request.getParameter("apassword");

		HttpSession session = request.getSession();
		
		ILoginService loginService = LoginServiceFactory.getLoginService();
		String adminLogin = loginService.adminLogin(Integer.parseInt(aid), apassword);
		System.out.println(adminLogin);
		if (adminLogin.equals("success")) {
			session.setAttribute("aid", aid);
			session.setAttribute("adminLogin", adminLogin);
			requestDispatcher = request.getRequestDispatcher("adminwindow.jsp");
			requestDispatcher.forward(request, response);
		} else {
			session.setAttribute("adminLogin", adminLogin);
			requestDispatcher = request.getRequestDispatcher("adminlogin.jsp");
			requestDispatcher.forward(request, response);

		}

	}

}
