package application.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import application.managers.StudentManager;
import application.models.Mark;
import application.models.Student;

@WebService
public class StudentService {

	StudentManager studentManager = new StudentManager();

	@WebMethod
	public void addStudent(Student student) {
		studentManager.addStudent(student);
	}
	
	@WebMethod
	public List<Student> getAllStudents() {
		return studentManager.getAllStudents();
	}

	@WebMethod
	public Student getStudentByFacNumber(int facNumber) {
		return studentManager.getStudentByFacNumber(facNumber);
	}

	@WebMethod
	public Student getStudentByName(String firstName, String lastName) {
		return studentManager.getStudentByName(firstName, lastName);
	}

	@WebMethod
	public void deleteStudent(int facNumber) {
		studentManager.deleteStudent(facNumber);
	}
	
	@WebMethod
	public List<Mark> getMarks(int facNumber) {
		return studentManager.getStudentMarks(facNumber);
	}
	
	@WebMethod
	public boolean isAuthorized(String userName, String pass) {
		return studentManager.isAuthorized(userName, pass);
	}
}
