package isA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CourseWithActionEvent {
	private String courseName = "defalut name";
	private ArrayList<String> students= new ArrayList<String>();
	private int enrollment = 10;
	
	private ArrayList<ActionListener> actionListeners;
	
	public CourseWithActionEvent(){
		
	}
	
	public CourseWithActionEvent(String courseName){
		this.courseName = courseName;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void addStudent(String student) {
		students.add(student);
		
		if(students.size() > enrollment)
			processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
	}
	
	public String[] getStudent(){
		return (String[])students.toArray();
	}
	
	public int getNumberOfStudents() {
		return students.size();
	}
	
	public int getEnrollmentCap() {
		return enrollment;
	}
	
	public void setEnrollmentCap(int enrollmentCao){
		this.enrollment = enrollmentCao;
	}
	
	public synchronized void addActionListener(ActionListener listener) {
		if(actionListeners == null)
			actionListeners = new ArrayList<ActionListener>(2);
		
		if(!actionListeners.contains(listener))
			actionListeners.add(listener);
	}
	
	public void removeActionListener(ActionListener listener) {
		if(actionListeners != null && actionListeners.contains(listener))
			actionListeners.remove(listener);
	}
	
	private void processEvent(ActionEvent e) {
		ArrayList list;
		
		synchronized (this) {
			if(actionListeners == null) return;
			list = (ArrayList)actionListeners.clone();
		}
		
		for(int i= 0; i < list.size(); i++){
			ActionListener listener = (ActionListener)list.get(i);
			listener.actionPerformed(e);
		}
	}
}
