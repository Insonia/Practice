package Program14;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DetectEndOfFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try{
			DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("temp.dat"));
			outputStream.writeDouble(2123);
			outputStream.writeDouble(345);
			outputStream.writeDouble(34545);
			outputStream.close();
			
			DataInputStream inputStream = new DataInputStream(new FileInputStream("temp.dat"));
			while (true) {
				System.out.println(inputStream.readDouble());
			}
		}
		catch(EOFException ex){
			System.out.println("Milo sb");
		}
	}

}
