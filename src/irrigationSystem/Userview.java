package irrigationSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;

import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Panel;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Userview extends JDialog {

	private JPanel contentPane;
	public static String nameRegion;
	public static String soilType;
	public static String startMonth;
	public static String endMonth;
	public static JComboBox region_combobox;
	public static JComboBox soil_combobox;
	public static JComboBox start_month;
	public static JComboBox end_month;
	static DB_Forecasting rain_water = new DB_Forecasting();
	static River_Forecast river_water = new River_Forecast();
	public static Double rain_amount;
	public static Double river_amount;
	static FetchCropName FCN = new FetchCropName();
	//static Fetch_crop_details FCD = new Fetch_crop_details();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Userview frame = new Userview();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Userview() 
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 563);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("./src/images/logo.jpg"));
		lblNewLabel.setBounds(294, 37, 161, 98);
		contentPane.add(lblNewLabel);
		
		region_combobox = new JComboBox();
		region_combobox.setModel(new DefaultComboBoxModel(new String[] {"North", "South", "East", "West"}));
		region_combobox.setFont(new Font("Times New Roman", Font.BOLD, 12));
		region_combobox.setForeground(new Color(102, 153, 0));
		region_combobox.setBounds(149, 158, 179, 35);
		contentPane.add(region_combobox);
		
		JLabel region = new JLabel("Region");
		region.setHorizontalAlignment(SwingConstants.CENTER);
		region.setForeground(new Color(102, 153, 0));
		region.setFont(new Font("Tahoma", Font.BOLD, 14));
		region.setBounds(26, 162, 70, 25);
		contentPane.add(region);
		
		JLabel soil_type = new JLabel("Soil Type");
		soil_type.setForeground(new Color(102, 153, 0));
		soil_type.setFont(new Font("Tahoma", Font.BOLD, 14));
		soil_type.setHorizontalAlignment(SwingConstants.CENTER);
		soil_type.setBounds(368, 162, 79, 25);
		contentPane.add(soil_type);
		
		soil_combobox = new JComboBox();
		soil_combobox.setModel(new DefaultComboBoxModel(new String[] {"Alluvial Soil", "Black Soil", "Laterite Soil", "Mountain Soil", "Red Soil", "Clay Soil", "Desert Soil", "Loamy Soil"}));
		soil_combobox.setForeground(new Color(102, 153, 0));
		soil_combobox.setFont(new Font("Times New Roman", Font.BOLD, 12));
		soil_combobox.setBounds(471, 158, 179, 35);
		contentPane.add(soil_combobox);
		
		JButton search_btn = new JButton("Search");
		search_btn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{	
				nameRegion = (String) region_combobox.getSelectedItem();
				soilType = (String) soil_combobox.getSelectedItem();
				startMonth = (String) start_month.getSelectedItem();
				endMonth = (String) end_month.getSelectedItem();
				System.out.println(soilType + " " + startMonth + " " + endMonth);
				rain_amount = rain_water.CalculateRainfall(startMonth, endMonth);
				river_amount = river_water.CalculateRiverWater(startMonth, endMonth);
				//System.out.println(river_amount);
				FCN.setVariables();
				Crop_table_show ts= new Crop_table_show();
				ts.setVisible(true);
				ts.loadData();
			}
		});
		
		search_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		search_btn.setBackground(new Color(102, 153, 0));
		search_btn.setBounds(283, 371, 134, 35);
		contentPane.add(search_btn);
		
		JLabel lblStartMonth = new JLabel("Start Month");
		lblStartMonth.setForeground(new Color(102, 153, 0));
		lblStartMonth.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStartMonth.setHorizontalAlignment(SwingConstants.CENTER);
		lblStartMonth.setBounds(36, 257, 86, 25);
		contentPane.add(lblStartMonth);
		
		JLabel lblEndMonth = new JLabel("End Month");
		lblEndMonth.setForeground(new Color(102, 153, 0));
		lblEndMonth.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEndMonth.setBounds(378, 257, 79, 25);
		contentPane.add(lblEndMonth);
		
		start_month = new JComboBox();
		start_month.setFont(new Font("Times New Roman", Font.BOLD, 12));
		start_month.setForeground(new Color(0, 100, 0));
		start_month.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December", ""}));
		start_month.setBounds(149, 256, 179, 25);
		contentPane.add(start_month);
		
		end_month = new JComboBox();
		end_month.setForeground(new Color(0, 128, 0));
		end_month.setFont(new Font("Times New Roman", Font.BOLD, 12));
		end_month.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December", ""}));
		end_month.setBounds(471, 256, 179, 25);
		contentPane.add(end_month);
		setLocationRelativeTo(null);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
	}
}
