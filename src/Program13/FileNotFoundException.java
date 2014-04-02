package Program13;

import java.io.File;
import java.util.Scanner;

public class FileNotFoundException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputScanner = new Scanner(System.in);
		
		System.out.println("Enetr a file name");
		String filenameString = inputScanner.nextLine();
		
		try{
			Scanner inputFromFileScanner = new Scanner(new File(filenameString));
			System.out.println(filenameString + "exists");
		}
		catch(Exception e){
			System.out.println("Exception: " + filenameString + " not found" );
		}
		
	}

}
