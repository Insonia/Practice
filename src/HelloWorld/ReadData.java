package HelloWorld;

import java.io.File;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class ReadData {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		File file = new File("Score.txt");
		if(!file.exists())
		{
			System.out.println("Milo is a  Stupid boy");
			System.exit(0);
		}
		
		Scanner input = new Scanner(file);
		while(input.hasNext())
		{
			String firString = input.next();
			String miString = input.next();
			String lasString= input.next();
			int score = input.nextInt();
			System.out.println(firString + " " + miString + " " + lasString + "' scrore is " + score);
		}
		
		input.close();
	}

}
