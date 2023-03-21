package in.company.service;

public interface ILoginService {

	public String librarianLogin(int id, String password);

	public String adminLogin(int id, String password);
}
