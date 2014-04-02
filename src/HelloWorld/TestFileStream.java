package HelloWorld;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileStream {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream outputStream = new FileOutputStream("temp.dat");
		
		for(int i=1;i<=10;i++)
			outputStream.write(i);
		
		outputStream.close();
		
		FileOutputStream outputAppend = new FileOutputStream("temp.dat", true);
		for(int i=1;i<=10;i++)
			outputAppend.write(i);
		
		outputAppend.close();
		
		FileInputStream inputStream = new FileInputStream("temp.dat");
		
		int value;
		while((value = inputStream.read()) != -1)
			System.out.println(value);
		
		inputStream.close();
	}

}
