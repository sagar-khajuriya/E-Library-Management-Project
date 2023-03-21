package in.company.dao;

public interface ILoginDao {

	public String adminLogin(int id, String password);

	public String librarianLogin(int id, String password);

}
