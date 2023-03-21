package in.company.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.company.dto.LibraryTransaction;
import in.company.service.ILibraryTransactionService;
import in.company.servicefactory.LibraryTransactionServiceFactory;

@WebServlet("/showlibrarytransaction")
public class LibraryTransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		ILibraryTransactionService libraryTraansactionService = LibraryTransactionServiceFactory.getLibraryTraansactionService();
		List<LibraryTransaction> showAllLibraryTransaction = libraryTraansactionService.showAllLibraryTransaction();
		
		request.setAttribute("showAllLibraryTransaction", showAllLibraryTransaction);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("/showalllibrarytransaction.jsp");
		requestDispatcher.forward(request, response);
	
	}
	
}
