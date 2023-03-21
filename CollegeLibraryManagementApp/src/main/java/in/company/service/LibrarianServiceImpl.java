package in.company.service;

import java.util.List;

import in.company.dao.ILibrarianDao;
import in.company.daofactory.DaoFactory;
import in.company.dto.Librarian;

public class LibrarianServiceImpl implements ILibrarianService {

	private ILibrarianDao librarianDao;

	@Override
	public String addLibrarian(Librarian lib) {
		librarianDao = DaoFactory.getLibrarianDao();
		return librarianDao.addLibrarian(lib);
	}

	@Override
	public String updateLibrarian(Librarian lib) {
		librarianDao = DaoFactory.getLibrarianDao();
		return librarianDao.updateLibrarian(lib);	}

	@Override
	public String deleteLibrarian(Integer lib) {
		librarianDao = DaoFactory.getLibrarianDao();
		return librarianDao.deleteLibrarian(lib);	}

	@Override
	public Librarian searchLibrarian(Integer lib) {
		librarianDao = DaoFactory.getLibrarianDao();
		return librarianDao.searchLibrarian(lib);
	}

	@Override
	public String loginLibrarian(Integer id, String password) {
		librarianDao = DaoFactory.getLibrarianDao();
		return librarianDao.loginLibrarian(id, password);
	}

	@Override
	public List<Librarian> showAllLibrarian() {
		librarianDao = DaoFactory.getLibrarianDao();
		return librarianDao.showAllLibrarian();
	}

}
