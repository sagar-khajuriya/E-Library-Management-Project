package in.company.servicefactory;

import in.company.service.ILibrarianService;
import in.company.service.LibrarianServiceImpl;

public class ServiceFactory {

	private static ILibrarianService libService = null;

	private ServiceFactory() {
		// TODO Auto-generated constructor stub
	}

	public static ILibrarianService getLibrarianService() {
		if (libService == null) {
			libService = new LibrarianServiceImpl();
		}
		return libService;
	}

}
