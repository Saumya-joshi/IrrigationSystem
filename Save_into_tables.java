package algoProject;

import java.sql.*;
import java.util.*;

import com.mysql.jdbc.PreparedStatement;


public class Save_into_tables {
	static Connection c=null;
	static java.sql.PreparedStatement S = null;
	static JavaSingleton jdbc= JavaSingleton.getInstance();
	public static void main(String[] args)
	{
		/*try 
		{
			c = jdbc.getConnection();
			S = c.prepareStatement("Insert into soil(id, type) values(?, ?)");
			S.setInt(1, 7);
			S.setString(2, "hell");
			int RS = S.executeUpdate();
			System.out.println("INSERTED");
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
}
