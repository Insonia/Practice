package sb;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindUserTables {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Class Loaded");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook","root","111");
		System.out.println("database connected");
		
		DatabaseMetaData dbMetaData = connection.getMetaData();
		
		ResultSet resultSet = dbMetaData.getTables(null, null, null, new String[]{"TABLE"});
		System.out.println("User tables: ");
		while(resultSet.next())
			System.out.println(resultSet.getString("TABLE_NAME") + " ");
		
		connection.close();
	}

}
