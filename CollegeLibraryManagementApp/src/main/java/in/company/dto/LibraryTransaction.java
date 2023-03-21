package in.company.dto;

import java.io.Serializable;

public class LibraryTransaction implements Serializable {

	private static final long serialVersionUID = 1L;
	
	Integer sId;
	Integer bId;
	String issueDate;
	String dueDate;
	String submitDate;
	Integer fine;
	
	public LibraryTransaction() {
		// TODO Auto-generated constructor stub
	}

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public Integer getbId() {
		return bId;
	}

	public void setbId(Integer bId) {
		this.bId = bId;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}

	public Integer getFine() {
		return fine;
	}

	public void setFine(Integer fine) {
		this.fine = fine;
	}

	@Override
	public String toString() {
		return "LibraryTransaction [sId=" + sId + ", bId=" + bId + ", issueDate=" + issueDate + ", dueDate=" + dueDate
				+ ", submitDate=" + submitDate + ", fine=" + fine + "]";
	}
	
	
}
