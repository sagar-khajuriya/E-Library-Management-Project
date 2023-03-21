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

@WebServlet("/booksubmitcontroller")
public class BookSubmitController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ILibraryTransactionService service = LibraryTransactionServiceFactory.getLibraryTraansactionService();
		LibraryTransaction libTran = new LibraryTransaction();
		int sid = Integer.parseInt(request.getParameter("sid"));
		int bid = Integer.parseInt(request.getParameter("bid"));
		String submitdate = request.getParameter("submitdate");
		libTran.setsId(sid);
		libTran.setbId(bid);
		libTran.setIssueDate(submitdate);

		String submitBook = service.submitBook(sid, bid, submitdate);
		System.out.println("status " + submitBook);

		request.setAttribute("submitBook", submitBook);
		request.setAttribute("sid", sid);
		request.setAttribute("bid", bid);
		request.setAttribute("submitdate", submitdate);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("submitbook.jsp");
		requestDispatcher.forward(request, response);

	}

}
