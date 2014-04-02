package HelloWorld;

import javax.swing.JOptionPane;

//import javax.swing.JOptionPane;

public class Hello_world {
	public static void main(String args[])
	{
		//System.out.println("Hello Wolrd!");
		//JOptionPane.showMessageDialog(null, "Hello World!","Display",JOptionPane.i);
		
		/*System.out.println("Welocome to Java");
		System.out.println("Welcome to Computer Science");
		System.out.println("Programming is Fun");*/
		
		/*for(int i =0; i<5; i++)
		{
			System.out.println("Welcome to Java");
		}*/
		String string = JOptionPane.showInputDialog(null);
		System.out.println(string);
		JOptionPane.showMessageDialog(null, string);
	}
}
