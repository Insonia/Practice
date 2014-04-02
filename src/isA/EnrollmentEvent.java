package isA;

import java.util.EventObject;

public class EnrollmentEvent extends EventObject {
	private String studentToEroll;
	private int enrollmentCap;
	
	public EnrollmentEvent(Object source, String studentToEroll, int enrollmentCap) {
		super(source);
		// TODO Auto-generated constructor stub
		
		this.studentToEroll = studentToEroll;
		this.enrollmentCap = enrollmentCap;
	}
	
	public String getStudentToEnroll() {
		return studentToEroll;
	}
	
	public int getEnrollmentCap() {
		return enrollmentCap;
	}
	
}
