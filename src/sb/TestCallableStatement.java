package sb;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class TestCallableStatement {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook","root","111");
		System.out.println("Database Connected");
		
		CallableStatement callableStatement = connection.prepareCall("{? = call studentFound(?,?)}");
		
		Scanner input =new Scanner(System.in);
		System.out.println("Enter Student's firstName:");
		String firstName = input.nextLine();
		System.out.println("Enter student's last name:");
		String lastname = input.nextLine();
		
		callableStatement.setString(2, firstName);
		callableStatement.setString(3, lastname);
		callableStatement.registerOutParameter(1, Types.INTEGER);
		callableStatement.execute();
		
		if(callableStatement.getInt(1) >= 1)
			System.out.println(firstName + " " + lastname + " is in the database");
		else
			System.out.println(firstName + " " + lastname + " is not in the database");
		
	}

}
