package irrigationSystem;

import java.sql.*;
import java.util.HashMap;

public class DB_Forecasting {

	public static HashMap<Integer,String> month=new HashMap<>();
	public static HashMap<String,Integer> month1=new HashMap<>();
	static JavaSingleton jdbc= JavaSingleton.getInstance();
	public static Double TotalRainFall=0.0, RainThisMonth;

	public static Double CalculateRainfall(String s1,String s2)
	{
		month.put(1,"January");
		month.put(2,"February");
		month.put(3,"March");
		month.put(4,"April");
		month.put(5,"May");
		month.put(6,"June");
		month.put(7,"July");
		month.put(8,"August");
		month.put(9,"September");
		month.put(10,"October");
		month.put(11,"November");
		month.put(12,"December");

		month1.put("January",1);
		month1.put("February",2);
		month1.put("March",3);
		month1.put("April",4);
		month1.put("May",5);
		month1.put("June",6);
		month1.put("July",7);
		month1.put("August",8);
		month1.put("September",9);
		month1.put("October",10);
		month1.put("November",11);
		month1.put("December",12);

		System.out.println(s1);
		System.out.println(s2);
		int StartMonth=month1.get(s1);
		int EndMonth=month1.get(s2);

		Connection c=null;
		Statement s=null;

		try
		{
			c = jdbc.getConnection();

			s=c.createStatement();

			String sql;
			sql="SELECT * from rainforecast where month='january'";
			ResultSet r=s.executeQuery(sql);
			int rows=0;
			while(r.next())
			{
				rows++;
			}
			//System.out.println(rows);

			float amt[]=new float[rows];

			for(int i=StartMonth;i<=EndMonth;i++)
			{
				sql="SELECT amount from rainforecast where month='" + month.get(i) +"'";
				ResultSet res=s.executeQuery(sql);
				int k=0;
				//System.out.println("Rainfall in the month of [" + month.get(i) + "]");
				while(res.next())
				{
					//String m=res.getString("month");
					amt[k++]=res.getInt("amount");				
					//System.out.println(m + "-----" + amt );
				}

				/*for(int j=0;j<rows;j++)
					System.out.println(amt[j]);*/

				RainThisMonth=(double) TotalForecast(amt);
				//System.out.println("Rain in this month - " + RainThisMonth);
				TotalRainFall+=RainThisMonth;

			}
			System.out.println();
			//System.out.println("Total available RainWater - " + TotalRainFall);
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return TotalRainFall;
	}

	public static float TotalForecast(float[] amt) 
	{

		int sumTime=0,sumTimeSquare=0,sumRain=0,sumRainTime=0;
		int n=amt.length;
		float rain;

		for(int t=1;t<=amt.length;t++)
		{
			sumTime+=t;
			sumTimeSquare+=(t*t);
			sumRain+=amt[t-1];
			sumRainTime+=(amt[t-1]*t);
		}
		float L=lcm(n,sumTime);
		float p=(L/n)*sumTime;
		float q=(L/sumTime)*sumTimeSquare;
		float x=(L/n)*sumRain;
		float y=(L/sumTime)*sumRainTime;
		//System.out.println(L);
		float b=(x-y)/(p-q);
		float R0=(x-(p*b))/L;
		rain=R0+(b*(n+1));

		return rain;
	}

	private static int lcm(int length, int sumTime) 
	{

		int l=Math.max(length, sumTime);		
		while(true)
		{
			if(l%length==0&&l%sumTime==0)
			{
				break;
			}
			l++;
		}		
		return l;
	}

}
