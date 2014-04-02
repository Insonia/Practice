package isA;

import java.util.ArrayList;

public class CourseWithEnrollmentEvent {
	private String name = "defalu name";
	private ArrayList<String> students = new ArrayList<String>();
	private int enrollmenCap = 10;
	
	private ArrayList<EnrollmentListener> enrollmentListenerList;
	
	public CourseWithEnrollmentEvent(){
		
	}
	
	public CourseWithEnrollmentEvent(String name){
		this.name = name;
	}
	
	public void addStudent(String student){
		students.add(student);
		
		if(students.size() > enrollmenCap)
			////todo
			processEvent(new EnrollmentEvent(this, student, getEnrollmentCap()));			
	}
	
	public String[] getStudents() {
		return (String[])students.toArray();
	}
	
	public int getNumberOfStudent() {
		return students.size();
	}
	
	public int getEnrollmentCap() {
		return enrollmenCap;
	}
	
	public void setEnrollmentCap(int enrollmentCap) {
		this.enrollmenCap = enrollmentCap;
	}
	
	public synchronized void addEnrollmentListener(EnrollmentListener listener) {
		if(enrollmentListenerList == null)
			enrollmentListenerList = new ArrayList<EnrollmentListener>(2);
		
		if(!enrollmentListenerList.contains(listener))
			enrollmentListenerList.add(listener);
	}
	
	public synchronized void removeEnrollmentListener(EnrollmentListener listener) {
		if(enrollmentListenerList != null && enrollmentListenerList.contains(listener))
			enrollmentListenerList.remove(listener);
	}
	
	private void processEvent(EnrollmentEvent e) {
		ArrayList list;
		
		synchronized (this) {
			if(enrollmentListenerList == null) return;
			list = (ArrayList)enrollmentListenerList.clone();
		}
		
		for(int i= 0; i< list.size(); i++){
			EnrollmentListener listener = (EnrollmentListener)list.get(i);
			listener.enrollmentExceeded(e);
		}
	}
}
