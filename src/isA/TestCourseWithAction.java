package isA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestCourseWithAction {
	CourseWithActionEvent course = new CourseWithActionEvent("Java");
	
	public TestCourseWithAction(){
		course.setEnrollmentCap(2);
		ActionListener listener = new Listener();
		course.addActionListener(listener);
		course.addStudent("Milo");
		course.addStudent("isA");
		course.addStudent("SB");
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestCourseWithAction();
	}
	
	private class Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Enrollment cap exceeded");
		}
		
	}

}
