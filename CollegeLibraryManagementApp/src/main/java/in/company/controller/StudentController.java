package in.company.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.company.dto.Student;
import in.company.service.IStudentService;
import in.company.servicefactory.StudentServiceFactory;

@WebServlet("/studentcontroller/*")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IStudentService studentService = StudentServiceFactory.getStudentService();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getRequestURI());
		if (request.getRequestURI().endsWith("addstudent")) {
			System.out.println("flow comes Here");
			Student student = new Student();
			student.setSname(request.getParameter("sname"));
			student.setMailid(request.getParameter("mailid"));
			student.setContactno(request.getParameter("contactno"));
			student.setPassword(request.getParameter("password"));
			student.setGender(request.getParameter("gender"));
			student.setDepartment(request.getParameter("department"));
			student.setCourse(request.getParameter("course"));
			student.setAdmissionyear(request.getParameter("admissionyear"));
			student.setDob(request.getParameter("dob"));

			String addStudent = studentService.addStudent(student);

			request.setAttribute("addStudent", addStudent);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("../studentregistrationresponse.jsp");
			requestDispatcher.forward(request, response);
		}

		if (request.getRequestURI().endsWith("getallstudents")) {

			List<Student> showAllStudents = studentService.showAllStudents();
			System.out.println(showAllStudents);
			request.setAttribute("showAllStudents", showAllStudents);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("../showallstudents.jsp");
			requestDispatcher.forward(request, response);
		}

		if (request.getRequestURI().endsWith("searchstudent")) {
			Integer sId=Integer.parseInt(request.getParameter("sid"));
			Student searchStudents = studentService.searchStudent(sId);
			request.setAttribute("searchStudents", searchStudents );
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("../searchstudentresponse.jsp");
			requestDispatcher.forward(request, response);
		}

	}

}
