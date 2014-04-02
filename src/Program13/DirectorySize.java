package Program13;

import java.io.File;
import java.util.Scanner;

public class DirectorySize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Eneter a directory or a file: ");
		Scanner inputScanner = new Scanner(System.in);
		String directoryString = inputScanner.nextLine();
		
		System.out.println(getSize( new File(directoryString)) + "bytes");
	}
	
	public static long getSize(File file) {
		long size = 0;
		
		if(file.isDirectory()){
			File[] files = file.listFiles();
			for (File file2 : files) {
				size += getSize(file2);
			}
		}else {
			size += file.length();
		}
		return size;	
	}

}
