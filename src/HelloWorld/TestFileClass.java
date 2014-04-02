package HelloWorld;

import java.io.File;
import java.util.Date;

public class TestFileClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("src/HelloWorld/E3_1.java");
		System.out.println("Does it exits? " + file.exists());
		System.out.println("The file has: " + file.length() + " bytes.");
		System.out.println("Can it read: " + file.canRead());
		System.out.println("Can ite be wirtten? " + file.canWrite());
		System.out.println("Is it a directory? " + file.isDirectory());
		System.out.println("Is it a file? " + file.isFile());
		System.out.println("Is it absolute? " + file.isAbsolute());
		System.out.println("Is it hidden? " + file.isHidden());
		System.out.println("Absolue path is " + file.getAbsolutePath());
		System.out.println("Last modified on " + new Date(file.lastModified()));
	}

}
