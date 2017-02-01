package irrigationSystem;

import java.sql.*;
import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.io.IOException;

public class Knapsack 
{	
	static Fetch_crop_details obj = new Fetch_crop_details();
	public static List<String> crop_name= new ArrayList<String>();
	public static int index_crop = 0;
	public static Double sum = 0.0;
	static Userview UV = new Userview();
	public static int q = 150;
	public static void fun(Double Area)
	{
		int x = 0;
		int y = 10; 
		int width = 370;
		int height = 30;
		JDialog.setDefaultLookAndFeelDecorated(true);
		JDialog D1 = new JDialog();
		D1.setLayout(null);
		D1.setSize(400, 400);
		D1.setVisible(true);
		D1.setLocationRelativeTo(null);
		JLabel lbl[] = new JLabel[20];
		int n1=obj.crop_name.size();
		String[] cname = (String[]) obj.crop_name.toArray(new String[obj.crop_name.size()]);
		Integer[] cmrp = (Integer[]) obj.mrplist.toArray(new Integer[obj.mrplist.size()]);
		Integer[] cyield = (Integer[]) obj.yieldlist.toArray(new Integer[obj.yieldlist.size()]);
		int i, j=0, k = 0;  
		double max, area;  
		int array[][]=new int[3][20];  
		
		for(i=0;i<n1;i++)  
			array[0][i]=q;    

		for(i=0;i<n1;i++)  
		{
			array[1][i]=cmrp[i];
		}

		for(i=0;i<n1;i++)  
		{
			array[2][i]=cyield[i];
			///System.out.println(cyield[i]);
		}

		area = Area;  

		int count = 0;
		while(area>=0 && count <n1)  
		{  
			lbl[count] = new JLabel();
			lbl[count].setBounds(x, y, width, height);
			//lbl[count].setBorder(BorderFactory.createLineBorder(Color.black));
			D1.add(lbl[count]);
			max=0;
			for(i=0;i<n1;i++)  
			{  
				if(((float)array[1][i])*((float)array[2][i])>max)  
				{  
					max=((float)array[1][i])*((float)array[2][i]);  
					j=i;  
				}  
			}  
			if(array[0][j]>(area*array[2][j]))  
			{  
				System.out.println();
				System.out.println("Quantity of -: " +  cname[j] + " added is " + area*array[2][j]);
				lbl[count].setText("Quantity of -: " +  cname[j] + " added is " + area*array[2][j]);
				//setResult.setText(cname[j]);
				crop_name.add(cname[j]);
				sum+=max*area;  
				area=-1;  
			}  
			else  
			{  
				System.out.println("Quantity of: " + cname[j] + " added is " + array[0][j]); 
				lbl[count].setText("Quantity of: " + cname[j] + " added is " + array[0][j]);
				crop_name.add(cname[j]);
				area=area-(((float)array[0][j])/((float)array[2][j]));  
				sum+=((float)array[1][j])*((float)array[0][j]);  
				array[1][j]=0;  
			}  
			count++;
			y += 30;
		}  
		System.out.println("The total profit is " + sum);
		JLabel lbl_profit = new JLabel();
		lbl_profit.setBounds(0, y, 360, 30);
		//lbl_profit.setBorder(BorderFactory.createLineBorder(Color.black));
		D1.add(lbl_profit);
		lbl_profit.setText("The total profit is : " + sum);
		
		//sc.close();
		//return crop_name.get(0);
	}  

	public static void main(String[] args) 
	{
		Knapsack o1=new Knapsack();
		obj.function_return_details("Red Soil");
		o1.fun(15.0);
	}	
}