package in.company.dao;

import java.util.List;

import in.company.dto.LibraryTransaction;

public interface ILibraryTransaction {

	public String issueBook(LibraryTransaction libTranc);
	
	public String submitBook(Integer sId,Integer bId,String submitDate);
	
	public List<LibraryTransaction> showAllLibraryTransaction();
}
