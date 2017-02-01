package irrigationSystem;

import java.sql.*;

public class Admin_verification {
	Connection C;
	PreparedStatement S;
	JavaSingleton jdbc= JavaSingleton.getInstance();
	Admin_verification()
	{
		try
		{
			/*Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded");
			C= DriverManager.getConnection("jdbc:mysql://localhost:3306/sem4","root","root");*/
			C=jdbc.getConnection();
			System.out.println("Connected");
			S=C.prepareStatement("select * from admin where username= ? and password = ? ");
		}
		catch(ClassNotFoundException|SQLException se)
		{
			se.printStackTrace();
		
		}
	}
	public Boolean check_login_details(String username, String password)
	{
		try
		{
			S.setString(1, username);
			S.setString(2, password);
			ResultSet RS= S.executeQuery();
			if(RS.next())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception E)
		{
			System.out.println("Validation Failed..!");
			E.printStackTrace();
			return false;
		}
	}
	
}