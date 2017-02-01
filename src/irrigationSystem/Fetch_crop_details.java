package irrigationSystem;

import java.sql.*;
import java.util.*;

public class Fetch_crop_details {

	public static ArrayList<String> crop_name = new ArrayList<String>();
	public static ArrayList<Integer> mrplist = new ArrayList<Integer>();
	public static ArrayList<Integer> yieldlist = new ArrayList<Integer>();
	public static ArrayList<Integer> crop_id = new ArrayList<Integer>();
	JavaSingleton jdbc= JavaSingleton.getInstance();
	public static String soiltype;
	static Connection C;
	static PreparedStatement S = null;
	static PreparedStatement S1 = null;
	static PreparedStatement S2 = null;
	public static String query;
	public static ResultSet RS;
	public static int soilId;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
	}
	
	public void function_return_details(String soil_Type)
	{
		try
		{
			C = jdbc.getConnection();
			S = C.prepareStatement("Select *from soil where type = ?");
			//System.out.println("enter your soil type");
			//Scanner sc = new Scanner(System.in);
			soiltype = soil_Type;
			//System.out.println(soiltype);
			S.setString(1, soiltype);
			//query = "Select *from soil";
			RS = S.executeQuery();
			while(RS.next())
			{
				//System.out.println("Entered");
				soilId = RS.getInt(1);
			}
			System.out.println(soilId);
			S1 = C.prepareStatement("Select *from soil_crop where soil_id = ?");
			S1.setInt(1, soilId);
			RS = S1.executeQuery();
			while(RS.next())
			{
				crop_id.add(RS.getInt(2));
			}
			System.out.println("Printing crop id : ");
			for(int i = 0; i<crop_id.size(); i++)
				System.out.println(crop_id.get(i));
			S2 = C.prepareStatement("Select *from crop where crop_id = ?");
			for(int i = 0; i<crop_id.size(); i++)
			{
				S2.setInt(1, crop_id.get(i));
				RS = S2.executeQuery();
				while(RS.next())
				{
					crop_name.add(RS.getString(2));
					mrplist.add(RS.getInt(7));
					yieldlist.add(RS.getInt(8));
				}
			}
		}
		catch(ClassNotFoundException|SQLException se)
		{
			se.printStackTrace();
		}
	}
}
