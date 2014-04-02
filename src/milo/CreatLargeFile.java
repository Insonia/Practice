package milo;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class CreatLargeFile {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("largedata.dat")));
		
		for(int i = 0; i< 100000; i ++)
			output.writeInt((int)(Math.random() * 1000000));
		
		output.close();
	}

}
