package in.company.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.company.dto.LibraryTransaction;
import in.company.service.ILibraryTransactionService;
import in.company.servicefactory.LibraryTransactionServiceFactory;

@WebServlet("/libtransactioncontroller")
public class BookIssueController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		if(request.getRequestURI().endsWith("issuebook")) {
			
			ILibraryTransactionService service = LibraryTransactionServiceFactory.getLibraryTraansactionService();
			LibraryTransaction libTran=new LibraryTransaction();
			int sid = Integer.parseInt(request.getParameter("sid"));
			int bid = Integer.parseInt(request.getParameter("bid"));
			String issuedate = request.getParameter("issuedate");
			libTran.setsId(sid);
			libTran.setbId(bid);
			libTran.setIssueDate(issuedate);
			
			String issueBook = service.issueBook(libTran);
			System.out.println("status "+issueBook);

			request.setAttribute("issueBook", issueBook);
			request.setAttribute("sid", sid);
			request.setAttribute("bid", bid);
			request.setAttribute("issuedate", issuedate);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("issuebook.jsp");
			requestDispatcher.forward(request, response);
			
		
//		}
		
	}

	
}
