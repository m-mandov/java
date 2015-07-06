package application.services;

public class Service {
	
	static StudentServiceService myService = new StudentServiceService();
	static StudentService service = myService.getStudentServicePort();
	
	public static StudentService getStub() {
		return service;
	}

}
