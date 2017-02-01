package irrigationSystem;

import java.util.*;

public class GetAreaDetails {

	public Double area[] = new Double[9];
	//public static Crop_table_show CTS = new Crop_table_show();
	public GetAreaDetails()
	{
		
	}
	
	public void get_area_from()
	{
		Crop_table_show CTS = new Crop_table_show();
		int i;
		for(i = 0; i<9; i++)
		{
			area[i] = Double.parseDouble(CTS.fieldArea[i].getText());
		}
		
		for(i = 0; i<9; i++)
		{
			System.out.println("Area of field " + (i+1) + "is : " + (area[i]));
		}
	}
}
