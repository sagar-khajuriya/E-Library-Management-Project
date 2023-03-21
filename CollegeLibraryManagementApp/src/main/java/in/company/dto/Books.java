package in.company.dto;

import java.io.Serializable;

public class Books implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer bookId;
	private String bookName;
	private String subject;
	private String author;
	private String title;
	private String category;
	private Integer qty;
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", bookName=" + bookName + ", subject=" + subject + ", author=" + author
				+ ", title=" + title + ", category=" + category + ", qty=" + qty + ", getBookId()=" + getBookId()
				+ ", getBookName()=" + getBookName() + ", getSubject()=" + getSubject() + ", getAuthor()=" + getAuthor()
				+ ", getTitle()=" + getTitle() + ", getCategory()=" + getCategory() + ", getQty()=" + getQty()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
