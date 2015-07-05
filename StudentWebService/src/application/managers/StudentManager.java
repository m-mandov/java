package application.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import application.models.Mark;
import application.models.Student;

public class StudentManager {

	public void addStudent(Student student) {
		Connection connection = null;
		Statement statement = null;

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager
					.getConnection("jdbc:postgresql://localhost/postgres",
							"postgres", "admin");
			statement = connection.createStatement();
			String sql = "INSERT INTO students (first_name, last_name, faculty) values ('"
					+ student.getFirstName()
					+ "', '"
					+ student.getLastName()
					+ "', '" + student.getFaculty() + "')";

			statement.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Student getStudentByFacNumber(int facNumber) {
		Student student = new Student();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager
					.getConnection("jdbc:postgresql://localhost/postgres",
							"postgres", "admin");
			statement = connection
					.prepareStatement("SELECT * FROM students WHERE fac_number = ?");
			statement.setLong(1, facNumber);
			result = statement.executeQuery();

			if (result.next()) {
				student.setFirstName(result.getString("first_name"));
				student.setLastName(result.getString("last_name"));
				student.setFaculty(result.getString("faculty"));
				student.setFacNumber(result.getInt("fac_number"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				result.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return student;
	}

	public Student getStudentByName(String firstName, String lastName) {
		Student Student = new Student();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager
					.getConnection("jdbc:postgresql://localhost/postgres",
							"postgres", "admin");
			statement = connection
					.prepareStatement("SELECT * FROM students WHERE first_name = ? and last_name = ?");
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			result = statement.executeQuery();

			if (result.next()) {
				Student.setFirstName(result.getString("first_name"));
				Student.setLastName(result.getString("last_name"));
				Student.setFaculty(result.getString("faculty"));
				Student.setFacNumber(result.getInt("fac_number"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				result.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return Student;
	}

	public void deleteStudent(int facNumber) {
		Connection connection = null;
		Statement statement = null;

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager
					.getConnection("jdbc:postgresql://localhost/postgres",
							"postgres", "admin");
			statement = connection.createStatement();
			String sql = "DELETE FROM students WHERE fac_number = " + facNumber
					+ "";

			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public List<Mark> getStudentMarks(int facNumber) {
	
		List<Mark> marksList = new ArrayList<Mark>();
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager
					.getConnection("jdbc:postgresql://localhost/postgres",
							"postgres", "admin");
			statement = connection
					.prepareStatement("SELECT * FROM marks WHERE fac_number = ?");
			statement.setInt(1, facNumber);
			result = statement.executeQuery();

			while (result.next()) {
				Mark mark = new Mark();
				
				mark.setSubject(result.getString("subject"));
				mark.setMark(result.getInt("mark"));
				mark.setDate(result.getDate("date"));
				marksList.add(mark);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				result.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return marksList;
		
	}

	public List<Student> getAllStudents() {
		List<Student> studentsList = new ArrayList<Student>();
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager
					.getConnection("jdbc:postgresql://localhost/postgres",
							"postgres", "admin");
			statement = connection
					.prepareStatement("SELECT * FROM students");
			
			result = statement.executeQuery();

			while (result.next()) {
				Student student = new Student();
				
				student.setFacNumber(result.getInt("fac_number"));
				student.setFaculty(result.getString("faculty"));
				student.setFirstName(result.getString("first_name"));
				student.setLastName(result.getString("last_name"));
				studentsList.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				result.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return studentsList;
	}
	
	public boolean isAuthorized(String userName, String pass) {
		boolean authorized = false;

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager
					.getConnection("jdbc:postgresql://localhost/postgres",
							"postgres", "admin");
			statement = connection
					.prepareStatement("SELECT * FROM users WHERE user_name = ? and pass = ?");
			statement.setString(1, userName);
			statement.setString(2, pass);
			result = statement.executeQuery();

			if (result.next()) {
				authorized = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				result.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return authorized;
	}
	
}
