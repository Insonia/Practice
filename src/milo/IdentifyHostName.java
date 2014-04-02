package milo;

import java.net.InetAddress;

public class IdentifyHostName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0;i < args.length; i++)
			try {
				InetAddress address = InetAddress.getByName(args[i]);
				System.out.print("Host nmae: " + address.getHostName());
				System.out.println("IP address: " + address.getHostAddress());
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("Unknown");
			}
	}

}
