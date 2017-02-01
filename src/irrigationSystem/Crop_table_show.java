package irrigationSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.prompt.PromptSupport;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingWorker;
import javax.swing.Timer;

import java.sql.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Crop_table_show extends JFrame 
{
	private JPanel contentPane;
	private JTable table;
	private JPanel fieldContainer;
	private JPanel[][] fieldCropInfo = new JPanel[3][3];
	public JTextField[] fieldArea = new JTextField[9];
	List<String> crop_Name = new ArrayList<String>();
	FetchCropName FC = new FetchCropName();
	int index_fieldAra = 0;
	int index_cropName = 0;
	Connection c=null;
	PreparedStatement s=null;
	Statement S = null;
	ResultSet RS;
	JavaSingleton jdbc= JavaSingleton.getInstance();
	GetAreaDetails get_details = new GetAreaDetails();
	private int soil_id;
	public Double area[] = new Double[9];
	public Integer[] water_req = new Integer[9];
	public Double total_water_req = 0.0;
	public Double total_area = 0.0;
	public Double total_rain;
	public Double total_river_water;
	static Userview UV = new Userview();
	//static CalculateWaterEffect CWE = new CalculateWaterEffect();
	public List<String> fetched_crops = new ArrayList<String>();
	static Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	public static String[] getCropName = new String[9];
	public static String[] getCropNameFromKnapsack = new String[9];
	static Knapsack KP = new Knapsack();
	static Fetch_crop_details obj = new Fetch_crop_details();
	public static Double total_rain_per_field[] = new Double[9];
	public static Double deficit;
	public static Double excess;
	public static Integer marketPrice[] = new Integer[9];
	
	public DefaultTableModel tablemodel= new DefaultTableModel()
	{
		public boolean isCellEditable(int row, int column) 
		{
			return false;
		}
	};

	Enumeration Venum;
	List<String> crop_name = new ArrayList<String>();
	
	private JTextField textField;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				try 
				{
					Crop_table_show frame = new Crop_table_show();
					frame.setVisible(true);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public Crop_table_show() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 750);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("./src/images/logo.jpg"));
		logo.setBounds(294, 21, 166, 111);
		contentPane.add(logo);

		JLabel lblRegion = new JLabel("Region : ");
		lblRegion.setForeground(new Color(102, 153, 0));
		lblRegion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRegion.setBounds(93, 161, 57, 21);
		contentPane.add(lblRegion);

		//UV.getRegionName();
		JLabel Region = new JLabel("");
		Region.setFont(new Font("Tahoma", Font.BOLD, 12));
		Region.setForeground(new Color(102, 153, 0));
		Region.setBounds(179, 165, 160, 14);
		contentPane.add(Region);
		Region.setText(UV.nameRegion);

		JLabel lblSoilType = new JLabel("Soil Type :");
		lblSoilType.setForeground(new Color(102, 153, 0));
		lblSoilType.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSoilType.setBounds(93, 194, 72, 14);
		contentPane.add(lblSoilType);

		//UV.getSoilType();
		JLabel soil_type = new JLabel("");
		soil_type.setFont(new Font("Tahoma", Font.BOLD, 12));
		soil_type.setForeground(new Color(102, 153, 0));
		soil_type.setBounds(179, 193, 150, 14);
		contentPane.add(soil_type);
		soil_type.setText(UV.soilType);

		JLabel lblNewLabel = new JLabel("Start month : ");
		lblNewLabel.setForeground(new Color(102, 153, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(404, 161, 99, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("End Month : ");
		lblNewLabel_1.setForeground(new Color(102, 153, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(404, 194, 86, 14);
		contentPane.add(lblNewLabel_1);

		//UV.getStartMonth();
		JLabel start_month = new JLabel("");
		start_month.setForeground(new Color(51, 153, 0));
		start_month.setFont(new Font("Tahoma", Font.BOLD, 12));
		start_month.setBounds(513, 161, 113, 14);
		contentPane.add(start_month);
		start_month.setText(UV.startMonth);


		//UV.getEndMonth();
		JLabel end_month = new JLabel("");
		end_month.setForeground(new Color(102, 153, 0));
		end_month.setFont(new Font("Tahoma", Font.BOLD, 12));
		end_month.setBounds(500, 194, 126, 14);
		contentPane.add(end_month);
		end_month.setText(UV.endMonth);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(86, 251, 561, 125);
		contentPane.add(scrollPane);

		table = new JTable(tablemodel);
		scrollPane.setViewportView(table);

		fieldContainer = new JPanel();
		fieldContainer.setBounds(86, 381, 561, 320);
		fieldContainer.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(fieldContainer);
		fieldContainer.setLayout(null);

		int x_value = 10;
		int y_value = 11;
		int w_width = 172;
		int h_height = 70;

		crop_Name = FC.getCropName();
		//obj.function_return_details(UV.soilType);
		
		for(int i = 0; i<fieldCropInfo.length; i++)
		{
			for(int j = 0; j<fieldCropInfo[i].length; j++)
			{
				System.out.println(i+" "+j);
				fieldCropInfo[i][j] = new JPanel();
				fieldCropInfo[i][j].setBounds(x_value, y_value, w_width, h_height);
				fieldCropInfo[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
				fieldContainer.add(fieldCropInfo[i][j]);
				fieldCropInfo[i][j].setLayout(null);
				fieldCropInfo[i][j].setVisible(true);
				x_value += 182;
			}
			y_value += 97;
			x_value = 10;
		}

		int x = 10;
		int y = 9;
		int w = 152;
		int h = 25;

		StringMatching match = new StringMatching(crop_Name);
		Autocomplete[] cropName = new Autocomplete[9];
		for(int i = 0; i<fieldCropInfo.length; i++)
		{
			for(int j = 0; j<fieldCropInfo[i].length; j++)
			{
				System.out.println(i+" "+j);
				fieldArea[index_fieldAra] = new JTextField();
				fieldArea[index_fieldAra].setBounds(x, y, w, h);
				PromptSupport.setPrompt("Enter Area", fieldArea[index_fieldAra]);
				fieldCropInfo[i][j].add(fieldArea[index_fieldAra]);
				index_fieldAra++;
				
				cropName[index_cropName] = new Autocomplete(match);
				cropName[index_cropName].setBounds(x, y+26, w, h);
				//cropName[index_cropName].
				
				fieldCropInfo[i][j].add(cropName[index_cropName]);
				index_cropName++;
			}
		}

		JButton viewCanalStructure = new JButton("Canal Structure");
		viewCanalStructure.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				RiverGraphics ex = new RiverGraphics();
				ex.setVisible(true);
			}
		});
		
		viewCanalStructure.setFont(new Font("Times New Roman", Font.BOLD, 13));
		viewCanalStructure.setBounds(250, 280, 125, 27);
		fieldContainer.add(viewCanalStructure);

		JButton viewIrrigation = new JButton("Proceed");
		viewIrrigation.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				for(int i = 0; i<9; i++)
				{
					System.out.println(fieldArea[i].getText());
					//get_details.get_area_from();
					area[i] = Double.parseDouble(fieldArea[i].getText());
					System.out.println("Area Values : ");
					System.out.println(area[i]);		
					total_area += area[i];
				}
				System.out.println("Total Area : " + total_area);
				System.out.println("Printing Selected Crops : ");
				for(int i = 0; i<9; i++)
				{
					System.out.println(cropName[i].getSelectedItem());
					getCropName[i] = cropName[i].getSelectedItem().toString();
				}
				Connection crop_water = null;
				PreparedStatement fetch_water = null;
				ResultSet RS_water;
				try 
				{
					crop_water = jdbc.getConnection();
					fetch_water = crop_water.prepareStatement("Select *from crop where crop_name = ?");
					for(int i = 0; i<9; i++)
					{
						fetch_water.setString(1, cropName[i].getSelectedItem().toString());
						RS_water = fetch_water.executeQuery();
						while(RS_water.next())
						{
							water_req[i] = RS_water.getInt(9);
						}
					}
					System.out.println("Water Requirement : ");
					for(int i = 0; i<9; i++)
					{
						System.out.println(water_req[i]);
					}
				}
				catch (ClassNotFoundException | SQLException e) 
				{
					e.printStackTrace();
				}

				for(int i = 0; i<9; i++)
				{
					total_water_req += area[i]*water_req[i];
				}
				System.out.println("Total Water Requirement : " + (total_water_req));
				total_rain = UV.rain_amount;
				total_river_water = UV.river_amount;
				System.out.println(total_river_water);
				System.out.println(total_rain);
				considerPollution();
				//calculate_water_effect();
			}
		});
		
		viewIrrigation.setFont(new Font("Times New Roman", Font.BOLD, 13));
		viewIrrigation.setBounds(395, 280, 125, 27);
		fieldContainer.add(viewIrrigation);
		
		JCheckBox chkBoxRecommendedSettings = new JCheckBox("Recommended Settings");
		chkBoxRecommendedSettings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				obj.function_return_details(UV.soilType);
				Double sum = 0.0;
				for(int i = 0; i<9; i++)
				{
					sum += Double.parseDouble(fieldArea[i].getText());
				}
				KP.fun(sum);
				/*JDialog.setDefaultLookAndFeelDecorated(true);
				JDialog D1 = new JDialog();
				D1.setSize(400, 400);
				D1.setVisible(true);*/
			}
		});
		chkBoxRecommendedSettings.setFont(new Font("Times New Roman", Font.BOLD, 13));
		chkBoxRecommendedSettings.setBounds(56, 282, 188, 23);
		fieldContainer.add(chkBoxRecommendedSettings);
	}

	public void considerPollution()
	{
		JDialog.setDefaultLookAndFeelDecorated(true);
		JDialog Dlg_show_result = new JDialog();
		Dlg_show_result.setLayout(null);
		Dlg_show_result.setSize(400, 400);
		Dlg_show_result.setVisible(true);
		Dlg_show_result.setLocationRelativeTo(null);
		JLabel lblEnterPollution = new JLabel();
		lblEnterPollution.setBounds(10, 10, 150, 35);
		Dlg_show_result.add(lblEnterPollution);
		lblEnterPollution.setText("Enter Pollution Level : ");
		JTextField txtEnterPollution = new JTextField();
		txtEnterPollution.setBounds(150, 16, 240, 25);
		//txtEnterPollution.setFocusable(f);
		PromptSupport.setPrompt("Enter Pollution Level(Total Dissolved Solids(mg/l))", txtEnterPollution);
		Dlg_show_result.add(txtEnterPollution);
		JButton btnViewResult = new JButton();
		btnViewResult.setBounds(200, 50, 150, 35);
		btnViewResult.setText("View Result");
		Dlg_show_result.add(btnViewResult);
		btnViewResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Integer.parseInt((txtEnterPollution.getText().toString())) < 2100)
				{
					calculate_water_effect();
				}
				else
				{
					JDialog.setDefaultLookAndFeelDecorated(true);
					JDialog Dlg_show_msg = new JDialog();
					Dlg_show_msg.setLayout(null);
					Dlg_show_msg.setSize(300, 100);
					Dlg_show_msg.setVisible(true);
					Dlg_show_msg.setLocationRelativeTo(null);
					JLabel lblMsg = new JLabel();
					lblMsg.setBounds(5, 5, 280, 45);
					Dlg_show_msg.add(lblMsg);
					lblMsg.setText("<html>OMG! The pollution level is unsafe for the supply <br>to the fields. Please don't supply the water to the<br>fields else the crops will be destroyed.</html>");
				}
			}
		});
	}
	
	public void setMrpList()
	{
		try 
		{
			c = jdbc.getConnection();
			PreparedStatement S = null;
			ResultSet RS;
			S = c.prepareStatement("Select *from crop where crop_name = ?");
			for(int i = 0; i<getCropName.length; i++)
			{
				S.setString(1, getCropName[i]);
				RS = S.executeQuery();
				while(RS.next())
				{
					marketPrice[i] = RS.getInt(7);
				}
			}
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i<marketPrice.length; i++)
		{
			System.out.println(marketPrice[i]);
		}
	}
	public void loadData()
	{
		try
		{
			c = jdbc.getConnection(); 
			s = c.prepareStatement("select *from crop where crop_id = ?");
			S = c.createStatement();
			ResultSet RS = S.executeQuery("select *from crop");
			ResultSetMetaData metaData = RS.getMetaData();
			Vector<String> columnNames = new Vector<String>();
			int columnCount = metaData.getColumnCount();
			for(int i = 1; i <= columnCount; i++)
			{
				columnNames.add(metaData.getColumnName(i));
			}
			System.out.println(FC.crop_id.size());
			for(int i = 0; i<FC.crop_id.size(); i++)
			{
				s.setInt(1, FC.crop_id.get(i));
				RS = s.executeQuery();
				while(RS.next())
				{
					Vector<Object> vector = new Vector<Object>();
					for (int j = 1; j <= columnCount; j++) 
					{
						vector.add(RS.getObject(j));
					}
					Venum = vector.elements();
					System.out.println("\nElements in vector:");
					while(Venum.hasMoreElements())
						System.out.print(Venum.nextElement() + " ");
					System.out.println();
					data.add(vector);
				}
			}
			
			tablemodel.setDataVector(data, columnNames);
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
	}
	
	public void calculate_water_effect()
	{
		int x = 0;
		int y = 10;
		int width = 750;
		int height = 40;
		JDialog.setDefaultLookAndFeelDecorated(true);
		JDialog Dlg_show_result = new JDialog();
		Dlg_show_result.setLayout(null);
		Dlg_show_result.setSize(770, 400);
		Dlg_show_result.setVisible(true);
		Dlg_show_result.setLocationRelativeTo(null);
		JButton btnEnd = new JButton();
		btnEnd.setBounds(600, 300, 150, 25);
		btnEnd.setText("Click Here!");
		btnEnd.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				EndPage EP = new EndPage();
				EP.setVisible(true);
			}
		});
		Dlg_show_result.add(btnEnd);
		JLabel lbl_display_res[] = new JLabel[9];
		setMrpList();
		Double NetProfit;
		Double tempSales;
		Double TotalSales;
		for(int i = 0; i<9; i++)
		{
			total_rain_per_field[i] = ((area[i]*10000)*(total_rain/1000))*1000;
			water_req[i]=(int) (water_req[i]*area[i]);
			TotalSales=marketPrice[i]*area[i];
			tempSales = TotalSales;
			lbl_display_res[i] = new JLabel();
			lbl_display_res[i].setBounds(x, y, width, height);
			Dlg_show_result.add(lbl_display_res[i]);
			if(total_rain_per_field[i] > water_req[i])
			{
				excess = total_rain_per_field[i]-water_req[i];//case of excess. only rainfall will satisfy the need.
				if(Math.abs(excess/1000000) >= 0.0 && Math.abs(excess/1000000) <= 0.01)
				{
					System.out.println("Crop Good");
					System.out.println("Total Sales for the field[" + (i+1) + "] is :- " + TotalSales);
					lbl_display_res[i].setText("Crop Good! "+" "+"Total Sales for the field[" + (i+1) + "] is :- " + " "+ TotalSales);
					//multiply the quantity taken in knapsack with its price stored in database and that will be the output.
				}

				else if(Math.abs(excess/1000000) >= 0.01 && Math.abs(excess/1000000) <= 0.05)
				{
					System.out.println("A Little Crop Destroyed.(5%)");
					System.out.println("Predicted Sales for the field[" + (i+1) + "] is :- " + TotalSales);
					//tempSales = TotalSales;
					TotalSales=TotalSales-(0.05*TotalSales);
					System.out.println("Actual Total Sales for the field[" + (i+1) + "] is :- " + TotalSales);
					lbl_display_res[i].setText("A Little Crop Destroyed! "+" "+"Predicted Sales for the field[" + (i+1) + "] is :- " + " " + tempSales + "Total Sales for the field[" + (i+1) + "] is :- " + TotalSales);
				}

				else if(Math.abs(excess/1000000) >= 0.05 && Math.abs(excess/1000000) <= 0.07)
				{
					System.out.println("Slightly Crop Destroyed.(15%)");
					System.out.println("Predicted Sales for the field[" + (i+1) + "] is :- " + TotalSales);
					TotalSales=TotalSales-(0.15*TotalSales);
					System.out.println("Actual Total Sales for the field[" + (i+1) + "] is :- " + TotalSales);
					lbl_display_res[i].setText("Slightly Crop Destroyed! "+" "+"Predicted Sales for the field[" + (i+1) + "] is :- " + " " + tempSales + "Total Sales for the field[" + (i+1) + "] is :- " + TotalSales);
				}

				else if(Math.abs(excess/1000000) >= 0.07 && Math.abs(excess/1000000) <= 0.09)
				{
					System.out.println("Very Much Crop Destroyed.(50%)");
					System.out.println("Predicted Sales for the field[" + (i+1) + "] is :- " + TotalSales);
					TotalSales=TotalSales-(0.5*TotalSales);
					System.out.println("Actual Total Sales for the field[" + (i+1) + "] is :- " + TotalSales);
					lbl_display_res[i].setText("Very Much Crop Destroyed! "+" "+"Predicted Sales for the field[" + (i+1) + "] is :- " + " " + tempSales + "Total Sales for the field[" + (i+1) + "] is :- " + TotalSales);
				}

				else
				{
					System.out.println("Extremely Destroyed (90%)");
					System.out.println("Predicted Sales for the field[" + (i+1) + "] is :- " + TotalSales);
					TotalSales=TotalSales-(0.9*TotalSales);
					System.out.println("Actual Total Sales for the field[" + (i+1) + "] is :- " + TotalSales);
					lbl_display_res[i].setText("Extremely Destroyed! "+" "+"Predicted Sales for the field[" + (i+1) + "] is :- " + " " +  tempSales + "Total Sales for the field[" + (i+1) + "] is :- " + TotalSales);
				}
			}
			else
			{
				deficit = water_req[i]-total_rain_per_field[i];//if rainfall is in shortage, then river water need to be diverted.
                if(total_river_water>deficit)
                {
                    System.out.println("Amount of RiverWater supplied to the field[" + (i+1) + "] is :- " + deficit);
                    lbl_display_res[i].setText("Amount of RiverWater supplied to the field[" + (i+1) + "] is :- " + deficit);
                    total_river_water=total_river_water-deficit;
                }
                else
                {
                    if(Math.abs(deficit/1000000) >= 0.0 && Math.abs(deficit/1000000) <= 0.01)
                    {
                        System.out.println("Crop Good");
                        System.out.println("Total Sales for the field[" + (i+1) + "] is :- " + TotalSales);
                        lbl_display_res[i].setText("Crop Good! "+" "+"Total Sales for the field[" + (i+1) + "] is :- " + TotalSales);
                        //multiply the quantity taken in knapsack with its price stored in database and that will be the output.
                    }

                    else if(Math.abs(deficit/1000000) >= 0.01 && Math.abs(deficit/1000000) <= 0.05)
                    {
                        System.out.println("A Little Crop Destroyed.(5%)");
                        System.out.println("Predicted Sales for the field[" + (i+1) + "] is :- " + TotalSales);
                        TotalSales=TotalSales-(0.05*TotalSales);
                        System.out.println("Actual Total Sales for the field[" + (i+1) + "] is :- " + TotalSales);
                        lbl_display_res[i].setText("A Little Crop Destroyed! "+" "+"Predicted Sales for the field[" + (i+1) + "] is :- " + " " + tempSales + "Total Sales for the field[" + (i+1) + "] is :- " + TotalSales);
                    }

                    else if(Math.abs(deficit/1000000) >= 0.05 && Math.abs(deficit/1000000) <= 0.07)
                    {
                        System.out.println("Slightly Crop Destroyed.(15%)");
                        System.out.println("Predicted Sales for the field[" + (i+1) + "] is :- " + TotalSales);
                        TotalSales=TotalSales-(0.15*TotalSales);
                        System.out.println("Actual Total Sales for the field[" + (i+1) + "] is :- " + TotalSales);
                        lbl_display_res[i].setText("Slightly Crop Destroyed! "+" "+"Predicted Sales for the field[" + (i+1) + "] is :- " + " " + tempSales + "Total Sales for the field[" + (i+1) + "] is :- " + TotalSales);
                    }

                    else if(Math.abs(deficit/1000000) >= 0.07 && Math.abs(deficit/1000000) <= 0.09)
                    {
                        System.out.println("Very Much Crop Destroyed.(50%)");
                        System.out.println("Predicted Sales for the field[" + (i+1) + "] is :- " + TotalSales);
                        TotalSales=TotalSales-(0.5*TotalSales);
                        System.out.println("Actual Total Sales for the field[" + (i+1) + "] is :- " + TotalSales);
                        lbl_display_res[i].setText("Very Much Crop Destroyed! "+" "+"Predicted Sales for the field[" + (i+1) + "] is :- " + " " + tempSales + "Total Sales for the field[" + (i+1) + "] is :- " + TotalSales);
                    }

                    else
                    {
                        System.out.println("Extremely Destroyed (90%)");
                        System.out.println("Predicted Sales for the field[" + (i+1) + "] is :- " + TotalSales);
                        TotalSales=TotalSales-(0.9*TotalSales);
                        System.out.println("Actual Total Sales for the field[" + (i+1) + "] is :- " + TotalSales);
                        lbl_display_res[i].setText("Extremely Destroyed! "+" "+"Predicted Sales for the field[" + (i+1) + "] is :- " + " " + tempSales + "Total Sales for the field[" + (i+1) + "] is :- " + TotalSales);
                    }
                }
			}
			y += 30;
		}
	}
}
