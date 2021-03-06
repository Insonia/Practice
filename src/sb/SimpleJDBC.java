package sb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleJDBC {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook","root","111");
		System.out.println("Database connected");
		
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery("select firstName, mi, lastName from Student where lastName = 'Smith'");
		
		while(resultSet.next())
			System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3));
		
		connection.close();
	}

}
