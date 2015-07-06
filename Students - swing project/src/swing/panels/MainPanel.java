package swing.panels;

import java.awt.CardLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPasswordField;

import swing.models.OneRowSelectionModel;
import application.services.Mark;
import application.services.Service;
import application.services.Student;
import application.services.StudentService;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainPanel extends JPanel {
	private JPanel mainPanel;
	private JTable studentsTable;
	private JTextField fistNameField;
	private JTextField lastNameField;
	private JTextField facultyFiled;
	private JTable marksTable;
	private JTextField userNameField;
	private JPasswordField passwordField;
	private StudentService stub = Service.getStub();

	/**
	 * Create the panel.
	 */
	public MainPanel() {
		setLayout(new CardLayout(0, 0));
		mainPanel = this;
		DefaultTableModel marksTableModel = new DefaultTableModel() {
			@Override
			   public boolean isCellEditable(int row, int column) {
			       return false;
			   }
		};
		JPanel loginPanel = new JPanel();

		add(loginPanel, "name_13870500508560");

		JLabel userNameLabel = new JLabel("User Name :");

		JLabel passwordLabel = new JLabel("Password :");

		userNameField = new JTextField();
		userNameField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					StudentService stub = Service.getStub();
					String pass = new String(passwordField.getPassword());
					boolean authorised = stub.isAuthorized(
							userNameField.getText(), pass);
					if (authorised) {
						CardLayout cl = (CardLayout) mainPanel.getLayout();
						cl.show(mainPanel, "name_11967162243760");
					} else {
						JOptionPane.showMessageDialog(loginPanel,
								"Wrong user name or password!", "Inane error",
								JOptionPane.ERROR_MESSAGE);
						userNameField.setText("");
						passwordField.setText("");
					}
				}
			}
		});

		JButton loginButton = new JButton("Login");
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StudentService stub = Service.getStub();
				String pass = new String(passwordField.getPassword());
				boolean authorised = stub.isAuthorized(userNameField.getText(),
						pass);
				if (authorised) {
					CardLayout cl = (CardLayout) mainPanel.getLayout();
					cl.show(mainPanel, "name_11967162243760");
				} else {
					JOptionPane.showMessageDialog(loginPanel,
							"Wrong user name or password!", "Inane error",
							JOptionPane.ERROR_MESSAGE);
					userNameField.setText("");
					passwordField.setText("");
				}
			}
		});

		JButton exitButton2 = new JButton("Exit");
		exitButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		GroupLayout gl_loginPanel = new GroupLayout(loginPanel);
		gl_loginPanel
				.setHorizontalGroup(gl_loginPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								Alignment.TRAILING,
								gl_loginPanel
										.createSequentialGroup()
										.addGap(49)
										.addGroup(
												gl_loginPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																Alignment.TRAILING,
																gl_loginPanel
																		.createSequentialGroup()
																		.addComponent(
																				userNameLabel)
																		.addGap(18))
														.addGroup(
																gl_loginPanel
																		.createSequentialGroup()
																		.addComponent(
																				passwordLabel)
																		.addGap(24)))
										.addGroup(
												gl_loginPanel
														.createParallelGroup(
																Alignment.LEADING,
																false)
														.addGroup(
																gl_loginPanel
																		.createSequentialGroup()
																		.addComponent(
																				loginButton,
																				GroupLayout.PREFERRED_SIZE,
																				95,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				exitButton2,
																				GroupLayout.PREFERRED_SIZE,
																				89,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																passwordField)
														.addComponent(
																userNameField,
																GroupLayout.DEFAULT_SIZE,
																268,
																Short.MAX_VALUE))
										.addContainerGap()));
		gl_loginPanel
				.setVerticalGroup(gl_loginPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_loginPanel
										.createSequentialGroup()
										.addGap(52)
										.addGroup(
												gl_loginPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																userNameField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																userNameLabel))
										.addGap(71)
										.addGroup(
												gl_loginPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																passwordField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																passwordLabel))
										.addPreferredGap(
												ComponentPlacement.RELATED, 65,
												Short.MAX_VALUE)
										.addGroup(
												gl_loginPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																loginButton)
														.addComponent(
																exitButton2))
										.addGap(49)));
		loginPanel.setLayout(gl_loginPanel);

		JPanel studentsPanel = new JPanel();
		add(studentsPanel, "name_11967162243760");

		DefaultTableModel studentTableModel = new DefaultTableModel() {
			@Override
			   public boolean isCellEditable(int row, int column) {
			       return false;
			   }
		};
		studentTableModel.addColumn("Faculty number");
		studentTableModel.addColumn("First name");
		studentTableModel.addColumn("Last name");
		studentTableModel.addColumn("Faculty");

		List<Student> studentsList = stub.getAllStudents();
		Iterator<Student> iter = studentsList.iterator();

		while (iter.hasNext()) {
			Student student = iter.next();
			Object[] row = { student.getFacNumber(), student.getFirstName(),
					student.getLastName(), student.getFaculty() };
			studentTableModel.addRow(row);
		}

		JButton addStudentButton = new JButton("Add Student");
		addStudentButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) mainPanel.getLayout();
				cl.show(mainPanel, "name_12207827832640");
			}
		});

		JButton deleteStudentButton = new JButton("Delete Student");
		deleteStudentButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = studentsTable.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(loginPanel,
							"Please select a student!", "Inane error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					int facNum = (int) studentsTable.getValueAt(row, 0);
					stub.deleteStudent(facNum);
					studentTableModel.removeRow(row);
				}
			}
		});

		JButton marksButton = new JButton("View Marks");
		marksButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = studentsTable.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(loginPanel,
							"Please select a student!", "Inane error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					int facNum = (int) studentsTable.getValueAt(row, 0);
					List<Mark> marksList = stub.getMarks(facNum);
					Iterator<Mark> iter = marksList.iterator();

					while (iter.hasNext()) {
						Mark mark = iter.next();
						Object[] marksRow = { mark.getSubject(), mark.getMark() };
						marksTableModel.addRow(marksRow);
					}
					CardLayout cl = (CardLayout) mainPanel.getLayout();
					cl.show(mainPanel, "name_12574435460040");
				}
			}
		});

		JButton exitButton = new JButton("Exit");
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_studentsPanel = new GroupLayout(studentsPanel);
		gl_studentsPanel
				.setHorizontalGroup(gl_studentsPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_studentsPanel
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_studentsPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																scrollPane,
																GroupLayout.DEFAULT_SIZE,
																430,
																Short.MAX_VALUE)
														.addGroup(
																gl_studentsPanel
																		.createSequentialGroup()
																		.addComponent(
																				addStudentButton,
																				GroupLayout.PREFERRED_SIZE,
																				101,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				deleteStudentButton,
																				GroupLayout.PREFERRED_SIZE,
																				105,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				marksButton,
																				GroupLayout.DEFAULT_SIZE,
																				104,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				exitButton,
																				GroupLayout.PREFERRED_SIZE,
																				102,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap()));
		gl_studentsPanel.setVerticalGroup(gl_studentsPanel.createParallelGroup(
				Alignment.LEADING)
				.addGroup(
						gl_studentsPanel
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(scrollPane,
										GroupLayout.PREFERRED_SIZE, 241,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addGroup(
										gl_studentsPanel
												.createParallelGroup(
														Alignment.BASELINE)
												.addComponent(addStudentButton)
												.addComponent(exitButton)
												.addComponent(
														deleteStudentButton)
												.addComponent(marksButton))
								.addContainerGap(GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));

		studentsTable = new JTable();
		scrollPane.setViewportView(studentsTable);
		studentsTable.setModel(studentTableModel);
		studentsTable.setSelectionModel(new OneRowSelectionModel());
		studentsPanel.setLayout(gl_studentsPanel);

		JPanel addStudentPanel = new JPanel();
		add(addStudentPanel, "name_12207827832640");

		JLabel fistNameLabel = new JLabel("First Name :");

		JLabel lastNameLabel = new JLabel("Last Name :");

		JLabel facultyLabel = new JLabel("Faculty :");

		fistNameField = new JTextField();
		fistNameField.setColumns(10);

		lastNameField = new JTextField();
		lastNameField.setColumns(10);

		facultyFiled = new JTextField();
		facultyFiled.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					Student student = new Student();
					student.setFaculty(facultyFiled.getText());
					student.setFirstName(fistNameField.getText());
					student.setLastName(lastNameField.getText());
					stub.addStudent(student);

					studentTableModel.getDataVector().removeAllElements();
					revalidate();

					List<Student> studentsList = stub.getAllStudents();
					Iterator<Student> iter = studentsList.iterator();

					while (iter.hasNext()) {
						Student tempStudent = iter.next();
						Object[] row = { tempStudent.getFacNumber(),
								tempStudent.getFirstName(),
								tempStudent.getLastName(), tempStudent.getFaculty() };
						studentTableModel.addRow(row);
					}

					CardLayout cl = (CardLayout) mainPanel.getLayout();
					cl.show(mainPanel, "name_11967162243760");

					fistNameField.setText("");
					lastNameField.setText("");
					facultyFiled.setText("");
				}
			}
		});
		facultyFiled.setColumns(10);

		JButton backButton = new JButton("Back");
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) mainPanel.getLayout();
				cl.show(mainPanel, "name_11967162243760");
			}
		});

		JButton addButton = new JButton("Add");
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Student student = new Student();
				student.setFaculty(facultyFiled.getText());
				student.setFirstName(fistNameField.getText());
				student.setLastName(lastNameField.getText());
				stub.addStudent(student);

				studentTableModel.getDataVector().removeAllElements();
				revalidate();

				List<Student> studentsList = stub.getAllStudents();
				Iterator<Student> iter = studentsList.iterator();

				while (iter.hasNext()) {
					Student tempStudent = iter.next();
					Object[] row = { tempStudent.getFacNumber(),
							tempStudent.getFirstName(),
							tempStudent.getLastName(), tempStudent.getFaculty() };
					studentTableModel.addRow(row);
				}

				CardLayout cl = (CardLayout) mainPanel.getLayout();
				cl.show(mainPanel, "name_11967162243760");

				fistNameField.setText("");
				lastNameField.setText("");
				facultyFiled.setText("");
			}
		});
		GroupLayout gl_addStudentPanel = new GroupLayout(addStudentPanel);
		gl_addStudentPanel
				.setHorizontalGroup(gl_addStudentPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_addStudentPanel
										.createSequentialGroup()
										.addGap(38)
										.addGroup(
												gl_addStudentPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																fistNameLabel)
														.addComponent(
																lastNameLabel)
														.addComponent(
																facultyLabel))
										.addGap(35)
										.addGroup(
												gl_addStudentPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																Alignment.TRAILING,
																gl_addStudentPanel
																		.createSequentialGroup()
																		.addComponent(
																				backButton,
																				GroupLayout.PREFERRED_SIZE,
																				84,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				87,
																				Short.MAX_VALUE)
																		.addComponent(
																				addButton,
																				GroupLayout.PREFERRED_SIZE,
																				88,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																fistNameField,
																GroupLayout.DEFAULT_SIZE,
																259,
																Short.MAX_VALUE)
														.addComponent(
																lastNameField)
														.addComponent(
																facultyFiled))
										.addContainerGap(60, Short.MAX_VALUE)));
		gl_addStudentPanel
				.setVerticalGroup(gl_addStudentPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_addStudentPanel
										.createSequentialGroup()
										.addGap(40)
										.addGroup(
												gl_addStudentPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																fistNameLabel)
														.addComponent(
																fistNameField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(26)
										.addGroup(
												gl_addStudentPanel
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																lastNameLabel)
														.addComponent(
																lastNameField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(34)
										.addGroup(
												gl_addStudentPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																facultyLabel)
														.addComponent(
																facultyFiled,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED, 76,
												Short.MAX_VALUE)
										.addGroup(
												gl_addStudentPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(addButton)
														.addComponent(
																backButton))
										.addGap(41)));
		addStudentPanel.setLayout(gl_addStudentPanel);

		JPanel marksPanel = new JPanel();
		add(marksPanel, "name_12574435460040");

		marksTableModel.addColumn("Subject");
		marksTableModel.addColumn("Mark");

		JButton backButton1 = new JButton("Back");
		backButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) mainPanel.getLayout();
				cl.show(mainPanel, "name_11967162243760");
				marksTableModel.getDataVector().removeAllElements();
				revalidate();
			}
		});

		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_marksPanel = new GroupLayout(marksPanel);
		gl_marksPanel.setHorizontalGroup(
			gl_marksPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_marksPanel.createSequentialGroup()
					.addGroup(gl_marksPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_marksPanel.createSequentialGroup()
							.addGap(167)
							.addComponent(backButton1, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_marksPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_marksPanel.setVerticalGroup(
			gl_marksPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_marksPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(backButton1)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		marksTable = new JTable();
		scrollPane_1.setViewportView(marksTable);
		marksTable.setModel(marksTableModel);
		marksTable.setSelectionModel(new OneRowSelectionModel());
		marksPanel.setLayout(gl_marksPanel);

	}
}
