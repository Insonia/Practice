package sb;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SpinnerModelEditorDemo extends JFrame {
	private JSpinner jspDate = new JSpinner(new SpinnerDateModel());
	private JSpinner jspDay = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
	private String[] monthNames = new DateFormatSymbols().getMonths();
	private JSpinner jspMonth = new JSpinner(new SpinnerListModel(Arrays.asList(monthNames).subList(0, 12)));
	private JSpinner jspYear = new JSpinner(new SpinnerNumberModel(2004, 1, 3000, 1));
	
	public SpinnerModelEditorDemo(){
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(4,1));
		panel1.add(new Label("Date"));
		panel1.add(new Label("Day"));
		panel1.add(new Label("Month"));
		panel1.add(new Label("Year"));
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(4,1));
		panel2.add(jspDate);
		panel2.add(jspDay);
		panel2.add(jspMonth);
		panel2.add(jspYear);
		
		add(panel1,BorderLayout.WEST);
		add(panel2,BorderLayout.CENTER);
		
		JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(jspDate, "MMM dd, yyyy");
		jspDate.setEditor(dateEditor);
		
		JSpinner.NumberEditor yearEditor = new JSpinner.NumberEditor(jspYear, "####");
		jspYear.setEditor(yearEditor);
		
		updateDate();
		
		jspDay.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				updateDate();
			}
		});
		
		jspMonth.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				updateDate();
			}
		});
		
		jspYear.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				updateDate();
			}
		});
	}
	
	private void updateDate(){
		int month = ((SpinnerListModel)jspMonth.getModel()).getList().indexOf(jspMonth.getValue());
		int year = ((Integer)jspYear.getValue()).intValue();
		
		SpinnerNumberModel numberModel = (SpinnerNumberModel)jspDay.getModel();
		numberModel.setMaximum(new Integer(maxDayInMonth(year, month)));
		
		if(((Integer)(numberModel.getValue())).intValue() > maxDayInMonth(year, month))
			numberModel.setValue(new Integer(maxDayInMonth(year, month)));
		
		int day = ((Integer)jspDay.getValue()).intValue();
		
		jspDate.setValue(new GregorianCalendar(year, month, day).getTime());
	}
	
	private int maxDayInMonth(int year, int month){
		Calendar calendar = new GregorianCalendar(year, month, 1);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new SpinnerModelEditorDemo();
		frame.pack();
		frame.setVisible(true);
	}

}
