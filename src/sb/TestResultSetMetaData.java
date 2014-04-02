package sb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class TestResultSetMetaData {

	public static void main(String[] args) throws SQLException,ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Class loaded");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook","root","111");
		System.out.println("Database Connected");
		
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery("select * from Enrollment");
		
		ResultSetMetaData rsMetaData = resultSet.getMetaData();
		for(int i = 1;i <= rsMetaData.getColumnCount(); i++)
			System.out.printf("%-12s\t", rsMetaData.getColumnName(i));
		System.out.println();
		
		while(resultSet.next()){
			for(int i =1; i<= rsMetaData.getColumnCount(); i++)
				System.out.printf("%-12s\t",resultSet.getObject(i));
			System.out.println();
		}
		
		connection.close();
	}

}
