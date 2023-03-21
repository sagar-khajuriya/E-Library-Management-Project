package in.company.dao;

import java.util.List;

import in.company.dto.Librarian;

public interface ILibrarianDao {
	
	public String addLibrarian(Librarian lib);
	
	public String updateLibrarian(Librarian lib);
	
	public String deleteLibrarian(Integer lid);
	
	public Librarian searchLibrarian(Integer lid);
	
	public String loginLibrarian(Integer id,String password);
	
	public List<Librarian> showAllLibrarian();

}
