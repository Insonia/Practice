package sb;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDatabaseMetaData {

	public static void main(String[] args) throws SQLException,ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook","root","111");
		System.out.println("Database connected");
		
		DatabaseMetaData dbMetaData = connection.getMetaData();
		System.out.println("database URL: " +dbMetaData.getURL());
		System.out.println("database userName: " + dbMetaData.getUserName());
		System.out.println("database product name: " + dbMetaData.getDatabaseProductName());
		System.out.println("JDBC Driver name: " + dbMetaData.getDriverName());
		System.out.println("JDBC Driver major version: " + dbMetaData.getJDBCMajorVersion());
		System.out.println("JDBC Driver minor version: " + dbMetaData.getJDBCMinorVersion());
		System.out.println("Max number of connection: " + dbMetaData.getMaxConnections());
		System.out.println("MaxTableNameLength: " + dbMetaData.getMaxTableNameLength());
		System.out.println("MaxcloumnInTable: " + dbMetaData.getMaxColumnsInTable());
		
		connection.close();
	} 

}
