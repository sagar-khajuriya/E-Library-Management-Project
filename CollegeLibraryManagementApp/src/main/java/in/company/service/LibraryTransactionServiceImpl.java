package in.company.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import in.company.dao.ILibraryTransaction;
import in.company.daofactory.LibraryTransactionDaoFactory;
import in.company.dto.LibraryTransaction;

public class LibraryTransactionServiceImpl implements ILibraryTransactionService {

	@Override
	public String issueBook(LibraryTransaction libTranc) {
		ILibraryTransaction daoService = LibraryTransactionDaoFactory.getLibraryTransactionDaoService();
		System.out.println("Before "+libTranc);

		String issueDate = libTranc.getIssueDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();

		try {
			Date parse = sdf.parse(issueDate);
			calendar.setTime(parse);
		} catch (Exception e) {
			e.printStackTrace();
		}

		calendar.add(Calendar.DAY_OF_MONTH, 14);
		Date time = calendar.getTime();
		String dueDate = sdf.format(time);

		libTranc.setDueDate(dueDate);
		System.out.println("after "+libTranc);
		return daoService.issueBook(libTranc);
	}

	@Override
	public String submitBook(Integer sId, Integer bId, String submitDate) {
		ILibraryTransaction daoService = LibraryTransactionDaoFactory.getLibraryTransactionDaoService();
		
		return daoService.submitBook(sId, bId, submitDate);
	}

	@Override
	public List<LibraryTransaction> showAllLibraryTransaction() {
		ILibraryTransaction daoService = LibraryTransactionDaoFactory.getLibraryTransactionDaoService();
		return daoService.showAllLibraryTransaction();
	}

}
