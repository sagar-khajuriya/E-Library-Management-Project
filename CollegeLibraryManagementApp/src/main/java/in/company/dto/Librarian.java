package in.company.dto;

import java.io.Serializable;

public class Librarian implements Serializable {

	private static final long serialVersionUID = 1L;

	int lid;
	String lname;
	String lmailid;
	String lcontactno;
	String lpassword;
	String lgender;

	public Librarian() {
		// TODO Auto-generated constructor stub
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getLmailid() {
		return lmailid;
	}

	public void setLmailid(String lmailid) {
		this.lmailid = lmailid;
	}

	public String getLcontactno() {
		return lcontactno;
	}

	public void setLcontactno(String lcontactno) {
		this.lcontactno = lcontactno;
	}

	public String getLpassword() {
		return lpassword;
	}

	public void setLpassword(String lpassword) {
		this.lpassword = lpassword;
	}

	public String getLgender() {
		return lgender;
	}

	public void setLgender(String lgender) {
		this.lgender = lgender;
	}

	@Override
	public String toString() {
		return "Librarian [lid=" + lid + ", lname=" + lname + ", lmailid=" + lmailid + ", lcontactno=" + lcontactno
				+ ", lpassword=" + lpassword + ", lgender=" + lgender + "]";
	}

}
