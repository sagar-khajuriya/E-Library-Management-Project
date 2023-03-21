package in.company.tester;

import java.util.List;

import in.company.dao.LibraryTransactionImpl;
import in.company.dao.StudentDaoImpl;
import in.company.dto.LibraryTransaction;
import in.company.dto.Student;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		IBooksDao bookdao = new BooksDaoImpl();
//		Books books = new Books();
//		books.setBookId(111);
//		books.setBookName("Complete Java Guide");
//		books.setSubject("Java");
//		books.setAuthor("James Ghosling");
//		books.setTitle("The Complete Reference");
//		books.setCategory("Programming");
//		books.setQty(10);
//		String addBook = bookdao.addBook(books);
//		if(addBook.equals("success")) {
//			System.out.println("Book Inserted Successfully");
//		}
//		else {
//			System.out.println("Book Insertion failed");
//		}

//		List<Books> allBooks = bookdao.getAllBooks();
//		Iterator<Books> iterator = allBooks.iterator();
//		while(iterator.hasNext()) {
//			Books next = iterator.next();
//			System.out.println(next );
//		}
////		Books searchBook = bookdao.searchBook(123);
//		System.out.println(searchBook);

//		String deleteBook = bookdao.deleteBook(123);
//		if(deleteBook.equals("success")) {
//			System.out.println("Book Deleted Successfully");
//		}
//		else {
//			System.out.println("Book Deletion failed");
//		}
		/*
		 * ILibrarianDao daoImpl = new LibrarianDaoImpl();
		 * 
		 * Librarian librarian = new Librarian(); librarian.setLid(2);
		 * librarian.setLname("Tendulkar"); librarian.setLmailid("Sachin@gmail.com");
		 * librarian.setLcontactno("3465464456"); librarian.setLpassword("8982223266");
		 * librarian.setLgender("Male");
		 * 
		 * String updateLibrarian = daoImpl.updateLibrarian(librarian);
		 * System.out.println(updateLibrarian); if (updateLibrarian.equals("success")) {
		 * System.out.println("Record Updated Successfully"); } else {
		 * System.out.println("Record Updation Failed"); }
		 */

		/*
		 * String deleteLibrarian = daoImpl.deleteLibrarian(1);
		 * if(deleteLibrarian.equals("success")) {
		 * System.out.println("Deletion Success"); }else {
		 * System.out.println("Deletion Failed"); }
		 */

		/*
		 * Librarian searchLibrarian = daoImpl.searchLibrarian(2); if (searchLibrarian
		 * != null) { System.out.println("Record Found");
		 * System.out.println(searchLibrarian); } else {
		 * System.out.println("Record Not Found"); }
		 */

//		LoginDaoImpl loginDaoImpl = new LoginDaoImpl();
//		String adminLogin = loginDaoImpl.adminLogin(123, "admin123");
//		System.out.println(adminLogin);
//	
//	StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
//	List<Student> showAllStudents = studentDaoImpl.showAllStudents();
//	System.out.println(showAllStudents);

		
		LibraryTransactionImpl libraryTransactionImpl = new LibraryTransactionImpl();
		List<LibraryTransaction> showAllLibraryTransaction = libraryTransactionImpl.showAllLibraryTransaction();
		System.out.println(showAllLibraryTransaction);
		
	}

}
