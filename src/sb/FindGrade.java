package sb;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.tree.TreePath;

public class FindGrade extends JFrame {
	private JTextField jtfSSN = new JTextField(9);
	private JTextField jtfCourseID = new JTextField(5);
	private JButton jbtShowGrade = new JButton("ShowGrade");
	
	private Statement stmt;
	
	public FindGrade(){
		initializeDB();
		
		jbtShowGrade.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jbtShowGrade_actionPerformed(e);
			}
		});
		
		JPanel panel1 = new JPanel();
		panel1.add(new JLabel("SSN"));
		panel1.add(jtfSSN);
		panel1.add(new JLabel("Course ID"));
		panel1.add(jtfCourseID);
		panel1.add(jbtShowGrade);
		
		add(panel1,BorderLayout.NORTH);
	}
	
	private void initializeDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook","root","111");
			System.out.println("Database COnnected");
			
			stmt = connection.createStatement();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private void jbtShowGrade_actionPerformed(ActionEvent e){
		String ssn = jtfSSN.getText();
		String courseID = jtfCourseID.getText();
		try {
			String queryString = "select firstName, mi,lastName,title,grade from Student, Enrollment, Course " +
					"where Student.ssn = '" + ssn + "' and Enrollment.courseId = '" + courseID + "' and Enrollment.courseId = " +
					"COurse.courseId and Enrollment.ssn = Student.ssn";
			ResultSet rSet = stmt.executeQuery(queryString);
			
			if(rSet.next()){
				String lastName = rSet.getString(1);
				String mi = rSet.getString(2);
				String firstName = rSet.getString(3);
				String title = rSet.getString(4);
				String grade = rSet.getString(5);
				
				JOptionPane.showMessageDialog(null, firstName + " " + mi + " " + lastName + " " + "'s grade on Course " + title + " is " + grade);
				
			}else {
				JOptionPane.showMessageDialog(null, "Not Found");
			}
		} catch (SQLException e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new FindGrade();
		frame.pack();
		frame.setVisible(true);
	}

}
