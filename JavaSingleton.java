package algoProject;
import java.sql.*;

public class JavaSingleton {

	private static JavaSingleton database_connection;
	
	private JavaSingleton()
	{
	
	}
	
	public static JavaSingleton getInstance()
	{
		if(database_connection==null)
		{
			database_connection=new JavaSingleton();
		}
		return database_connection;
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sem4","root","root");
		return con;
	}
	
}
