package Program14;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestDataStream {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	DataOutputStream output = new DataOutputStream(new FileOutputStream("temp.dat"));
	
	output.writeUTF("John");
	output.writeDouble(85.5);
	output.writeUTF("Jim");
	output.writeDouble(185.5);
	output.writeUTF("Geogoge");
	output.writeDouble(103/5);
	
	output.close();
	
	DataInputStream input = new DataInputStream(new FileInputStream("temp.dat"));
	
	System.out.println(input.readUTF() + " " + input.readDouble());
	System.out.println(input.readUTF() + " " + input.readDouble());
	System.out.println(input.readUTF() + " " + input.readDouble());
	}
}
