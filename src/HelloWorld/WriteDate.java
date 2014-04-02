package HelloWorld;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteDate {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("Score.txt");
		if(file.exists())
		{
			System.out.println("File is already exist! ");
			System.exit(0);
		}
		
		PrintWriter output = new PrintWriter(file);
		
		output.print("John T Smith ");
		output.println(90);
		output.print("Eric asd asd: ");
		output.println(80);
		
		output.close();
	}

}
