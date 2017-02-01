package irrigationSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.sql.*;

public class FetchCropName {
	
	static List<String> crop_name = new ArrayList<String>();
	public static ArrayList<Integer> crop_id = new ArrayList<Integer>();
	JavaSingleton jdbc= JavaSingleton.getInstance();
	Connection C = null;
	static PreparedStatement S = null;
	static PreparedStatement S1 = null;
	static PreparedStatement S2 = null;
	public static String soilType;
	public static String endMonth;
	public static String startMonth;
	public static ResultSet RS;
	public int soilId;
	static Userview UV = new Userview();
	
	public FetchCropName() 
	{
		
	}
	
	public void setVariables()
	{
		System.out.println("hell");
		soilType = UV.soilType;
		endMonth = UV.endMonth;
		startMonth = UV.startMonth;
		System.out.println(soilType + " " + endMonth + " " + startMonth);
	}
	
	public List getCropName()
	{
		try
		{
			C = jdbc.getConnection(); 
			S = C.prepareStatement("Select *from soil where type = ?");
			S.setString(1, soilType);
			RS = S.executeQuery();
			while(RS.next())
			{
				soilId = RS.getInt(1);
			}
			System.out.println("Soil Id : " + soilId);
			S1 = C.prepareStatement("Select *from soil_crop where soil_id = ?");
			S1.setInt(1, soilId);
			RS = S1.executeQuery();
			while(RS.next())
			{
				crop_id.add(RS.getInt(2));
			}
			System.out.println("Crop Id : ");
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
				}
			}
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
		return crop_name;
	}
}
