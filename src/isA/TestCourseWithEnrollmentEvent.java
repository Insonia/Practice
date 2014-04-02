package isA;

public class TestCourseWithEnrollmentEvent {
	CourseWithEnrollmentEvent course = new CourseWithEnrollmentEvent("Java");
	
	public TestCourseWithEnrollmentEvent(){
		course.setEnrollmentCap(2);
		course.addEnrollmentListener(new EnrollmentListener() {
			
			@Override
			public void enrollmentExceeded(EnrollmentEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getStudentToEnroll() + " attempted to enroll\n" + "The enrollment Cap is " + e.getEnrollmentCap());
			}
		});
		
		course.addStudent("Milo");
		course.addStudent("isA");
		course.addStudent("SB");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestCourseWithEnrollmentEvent();
	}

}
