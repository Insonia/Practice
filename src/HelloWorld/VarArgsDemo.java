package HelloWorld;

public class VarArgsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		display();
		display(12,21,32,345,45);
		display(new double[]{12,34,465,56});
	}
	
	public static void display(double... numbers) {
		if(numbers.length == 0)
		{
			System.out.println("No args!!");
			return;
		}
		
		for (double d : numbers) {
			System.out.println(d);
		}
	}

}
