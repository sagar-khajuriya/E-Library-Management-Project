package in.company.service;

import java.util.List;

import in.company.dto.LibraryTransaction;

public interface ILibraryTransactionService {

	public String issueBook(LibraryTransaction libTranc);
	
	public String submitBook(Integer sId,Integer bId,String submitDate);
	
	public List<LibraryTransaction> showAllLibraryTransaction();
	
}
