package Program14;

//import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

//import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

//import org.omg.CORBA.Current;

public class TestCalendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar calendar = new GregorianCalendar();
		System.out.println("Current time is " + new Date());
		System.out.println("Year:\t" + calendar.get(Calendar.YEAR));
		System.out.println("Month:\t" + calendar.get(Calendar.MONTH));
		System.out.println("Date:\t" + calendar.get(Calendar.DATE));
		System.out.println("Hour:\t" + calendar.get(Calendar.HOUR));
		System.out.println("Hour of Day:\t" + calendar.get(Calendar.HOUR_OF_DAY));
		System.out.println("Minute:\t" + calendar.get(Calendar.MINUTE));
		System.out.println("Second:\t" + calendar.get(Calendar.SECOND));
		System.out.println("Day of Week:\t" + calendar.get(Calendar.DAY_OF_WEEK));
		System.out.println("Day of Month:\t" + calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println("Day of Year:\t" + calendar.get(Calendar.DAY_OF_YEAR));
		System.out.println("Week of Month:\t" + calendar.get(Calendar.WEEK_OF_MONTH));
		System.out.println("Week of Year:\t" + calendar.get(Calendar.WEEK_OF_YEAR));
		System.out.println("AM-PM:\t" + calendar.get(Calendar.AM_PM));
		
		Calendar calendar1 = new GregorianCalendar(2001,8,11);
		System.out.println("September 11, 2001 is a " + dayNameOfWeek(calendar1.get(Calendar.DAY_OF_WEEK)));
	} 
	
	public static String dayNameOfWeek(int dayOfWeek){
		switch (dayOfWeek) {
		case 1:
			return "Sunday";
		case 2:
			return "Monday";
		case 3:
			return "Tuesday";
		case 4:
			return "Wednesday";
		case 5:
			return "Thursday";
		case 6:
			return "Friday";
		case 7:
			return "Saturday";
		default:
			return null;
		}
	}

}
