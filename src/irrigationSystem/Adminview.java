package irrigationSystem;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Adminview extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Connection C = null;
	Statement S = null;
	//public static PreparedStatement S1 = null;
	JavaSingleton jdbc = JavaSingleton.getInstance();
	DefaultTableModel tableModel_crop = new DefaultTableModel();
	DefaultTableModel tableModel_rain = new DefaultTableModel();
	DefaultTableModel tableModel_soil = new DefaultTableModel();
	JTable table1 = new JTable(tableModel_rain);
	JTable table2= new JTable(tableModel_soil);
	JTable table3= new JTable(tableModel_crop);
	int row_rain, row_crop, row_soil;
	int count_rain=0, count_crop=0, count_soil=0;
	
	Enumeration Venum;
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Adminview frame = new Adminview();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public Adminview()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1362, 750);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("./src/images/logo.jpg"));
		logo.setBounds(577, 24, 264, 127);
		contentPane.add(logo);
		
		JPanel panel_rainfall = new JPanel();
		panel_rainfall.setBounds(141, 162, 504, 223);
		contentPane.add(panel_rainfall);
		panel_rainfall.setLayout(null);
		JScrollPane rainfall = new JScrollPane();
		rainfall.setBounds(10, 11, 484, 167);
		panel_rainfall.add(rainfall);
		
		rainfall.setViewportView(table1);
		table1.setEnabled(false);
		
		JButton update_rainfall = new JButton("Update");
		update_rainfall.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e1) 
			{
				table1.setEnabled(true);
			}
		});
		update_rainfall.setForeground(new Color(0, 0, 0));
		update_rainfall.setFont(new Font("Tahoma", Font.BOLD, 12));
		update_rainfall.setBackground(new Color(102, 153, 0));

		update_rainfall.setBounds(116, 189, 89, 23);
		panel_rainfall.add(update_rainfall);
		
		JButton save_rainfall = new JButton("Save");
		save_rainfall.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				table1.setEnabled(false);
				table1.getSelectionModel().clearSelection();
				table1.getCellEditor().stopCellEditing();
				for(int i=count_rain;i>0;i--)
				{
					int yr=Integer.parseInt(tableModel_rain.getValueAt(row_rain-i, 1).toString());
					System.out.print(yr+"  ");
					String mon=tableModel_rain.getValueAt(row_rain-i, 2).toString();
					System.out.print(mon+"  ");
					Double amt=Double.parseDouble(tableModel_rain.getValueAt(row_rain-i, 3).toString());
					System.out.println(amt);
					PreparedStatement S3 = null;
					try 
					{
						S3 = (PreparedStatement) C.prepareStatement("Insert into rainforecast(id, year, month, amount(mm)) values( ?, ?, ?, ?)");
						S3.setInt(1, row_rain-i+1);
						S3.setInt(2, yr);
						S3.setString(3, mon);
						S3.setDouble(4, amt);
						int RS = S3.executeUpdate();
						System.out.println("INSERTED");
					}	 
					catch (SQLException e1) 
					{
						e1.printStackTrace();	
					}
				}

			}
		});
		save_rainfall.setFont(new Font("Tahoma", Font.BOLD, 12));
		save_rainfall.setBackground(new Color(102, 153, 0));
		save_rainfall.setBounds(347, 189, 89, 23);
		panel_rainfall.add(save_rainfall);
		
		JButton insert_rainfall = new JButton("Insert");
		insert_rainfall.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				 tableModel_rain.insertRow(row_rain, new Object[] { row_rain+1, " " });
				 count_rain++;
				 row_rain++;
				 table1.setEnabled(true);
				
			}
		});
		
		insert_rainfall.setFont(new Font("Tahoma", Font.BOLD, 13));
		insert_rainfall.setBackground(new Color(102, 153, 0));
		insert_rainfall.setBounds(231, 189, 89, 23);
		panel_rainfall.add(insert_rainfall);
		panel_rainfall.setVisible(true);
		loadData("Select * from rainforecast", "rain");
		
		
		JPanel panel_soil = new JPanel();
		panel_soil.setBounds(748, 162, 496, 223);
		contentPane.add(panel_soil);
		panel_soil.setLayout(null);
		JScrollPane soil = new JScrollPane();
		soil.setBounds(10, 11, 475, 167);
		panel_soil.add(soil);
		
		soil.setViewportView(table2);
		table2.setEnabled(false);
		
		JButton update_soil = new JButton("Update");
		update_soil.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e2) 
			{
				table2.setEnabled(true);
				int row=table2.getSelectedRow();
				int column=table2.getSelectedColumn();
				String val= table2.getValueAt(row, column).toString();
				System.out.println(val);
			}
		});
		
		update_soil.setFont(new Font("Tahoma", Font.BOLD, 12));
		update_soil.setBackground(new Color(102, 153, 0));
		update_soil.setBounds(92, 189, 89, 23);
		panel_soil.add(update_soil);
		
		JButton save_soil = new JButton("Save");
		save_soil.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				table2.setEnabled(false);
				table2.getSelectionModel().clearSelection();
				table2.getCellEditor().stopCellEditing();
				System.out.println(count_soil);
				for(int i=count_soil;i>0;i--)
				{
					String inserted_string=tableModel_soil.getValueAt(row_soil-i, 1).toString();
					PreparedStatement S1 = null;
				
					try 
					{
						System.out.println(row_soil-i);
						S1 = (PreparedStatement) C.prepareStatement("Insert into soil(id, type) values(?, ?)");
						S1.setInt(1, row_soil-i+1);
						S1.setString(2, inserted_string);
						int RS = S1.executeUpdate();
						System.out.println("INSERTED");
					} 
					catch (SQLException e1) 
					{
						e1.printStackTrace();
					}
					System.out.println(inserted_string);
				}
			}
		});
		
		save_soil.setBackground(new Color(102, 153, 0));
		save_soil.setFont(new Font("Tahoma", Font.BOLD, 12));
		save_soil.setBounds(321, 189, 89, 23);
		panel_soil.add(save_soil);
		
		JButton insert_soil = new JButton("Insert");
		insert_soil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 tableModel_soil.insertRow(row_soil, new Object[] { row_soil+1, " " });
				 count_soil++;
				 row_soil++;
				 table2.setEnabled(true);
			}
		});
		insert_soil.setFont(new Font("Tahoma", Font.BOLD, 13));
		insert_soil.setBackground(new Color(102, 153, 0));
		insert_soil.setBounds(210, 189, 89, 23);
		panel_soil.add(insert_soil);
		panel_soil.setVisible(true);
		loadData("Select * from soil", "soil");
		
		JPanel panel_crop = new JPanel();
		panel_crop.setBounds(282, 431, 737, 269);
		contentPane.add(panel_crop);
		panel_crop.setLayout(null);
		JScrollPane crop = new JScrollPane();
		crop.setBounds(10, 11, 717, 213);
		panel_crop.add(crop);
		
		crop.setViewportView(table3);
		table3.setEnabled(false);
		
		JButton update_crop = new JButton("Update");
		update_crop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e3) {
				table3.setEnabled(true);
			}
		});
		update_crop.setFont(new Font("Tahoma", Font.BOLD, 12));
		update_crop.setBackground(new Color(102, 153, 0));
		update_crop.setBounds(199, 235, 89, 23);
		panel_crop.add(update_crop);
		
		JButton save_crop = new JButton("Save");
		save_crop.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				table3.setEnabled(false);
				table3.getSelectionModel().clearSelection();
				table3.getCellEditor().stopCellEditing();
				System.out.println(count_crop);
				for(int i=count_crop;i>0;i--)
				{
					String name=tableModel_crop.getValueAt(row_crop-i, 1).toString();
					Double min_rain=Double.parseDouble(tableModel_crop.getValueAt(row_crop-i, 2).toString());
					Double max_rain=Double.parseDouble(tableModel_crop.getValueAt(row_crop-i, 3).toString());
					Double min_temp=Double.parseDouble(tableModel_crop.getValueAt(row_crop-i, 4).toString());
					Double max_temp=Double.parseDouble(tableModel_crop.getValueAt(row_crop-i, 5).toString());
					Double mrp=Double.parseDouble(tableModel_crop.getValueAt(row_crop-i, 6).toString());
					Integer yield=Integer.parseInt(tableModel_crop.getValueAt(row_crop-i, 7).toString());
					Integer water=Integer.parseInt(tableModel_crop.getValueAt(row_crop-i, 8).toString());
					PreparedStatement S2 = null;
					try 
					{
						System.out.println(row_crop-i);
						System.out.println(name);
						System.out.println(min_rain);
						System.out.println(max_rain);
						System.out.println(min_temp);
						System.out.println(max_temp);
						System.out.println(mrp);
						S2 = (PreparedStatement) C.prepareStatement("Insert into crop(crop_id, crop_name, min_rainfall, max_rainfall, min_temp, max_temp, MRP, yield, water) values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
						S2.setInt(1, row_crop-i+1);
						S2.setString(2, name);
						S2.setDouble(3, min_rain);
						S2.setDouble(4, max_rain);
						S2.setDouble(5, min_temp);
						S2.setDouble(6, max_temp);
						S2.setDouble(7, mrp);
						S2.setInt(8, yield);
						S2.setInt(9, water);
						int RS = S2.executeUpdate();
						System.out.println("INSERTED");
					} 
					catch (SQLException e1) 
					{
						e1.printStackTrace();
					}
				}
			}
		});
		save_crop.setBackground(new Color(102, 153, 0));
		save_crop.setFont(new Font("Tahoma", Font.BOLD, 12));
		save_crop.setBounds(453, 235, 89, 23);
		panel_crop.add(save_crop);
		
		JButton insert_crop = new JButton("Insert");
		insert_crop.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				 tableModel_crop.insertRow(row_crop, new Object[] { row_crop+1, " " });
				 row_crop++;
				 count_crop++;
				 table3.setEnabled(true);
			}
		});
		insert_crop.setBackground(new Color(102, 153, 0));
		insert_crop.setFont(new Font("Tahoma", Font.BOLD, 12));
		insert_crop.setBounds(329, 235, 89, 23);
		panel_crop.add(insert_crop);
		
		JLabel lblRainfall = new JLabel("Rainfall :");
		lblRainfall.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRainfall.setBounds(60, 235, 88, 36);
		contentPane.add(lblRainfall);
		
		JLabel lblSoil = new JLabel("Soil :");
		lblSoil.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSoil.setBounds(684, 235, 80, 36);
		contentPane.add(lblSoil);
		
		JLabel lblCrops = new JLabel("Crops : ");
		lblCrops.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCrops.setBounds(191, 531, 64, 36);
		contentPane.add(lblCrops);
		panel_crop.setVisible(true);
		loadData("Select * from crop", "crop");
		
		
	}
	private void loadData(String s, String T)
	{
		try
		{
			C = jdbc.getConnection(); 
			S = C.createStatement();
			ResultSet RS = S.executeQuery(s);
			ResultSetMetaData metaData = RS.getMetaData();
			Vector<String> columnNames = new Vector<String>();
			int columnCount = metaData.getColumnCount();
			for(int i = 1; i <= columnCount; i++)
			{
				columnNames.add(metaData.getColumnName(i));
			}
			
			Vector<Vector<Object>> data = new Vector<Vector<Object>>();
			while(RS.next())
			{
				Vector<Object> vector = new Vector<Object>();
				for (int i = 1; i <= columnCount; i++) {
                    vector.add(RS.getObject(i));
                }
				Venum = vector.elements();
				System.out.println("\nElements in vector:");
			      while(Venum.hasMoreElements())
			         System.out.print(Venum.nextElement() + " ");
			     System.out.println();
                data.add(vector);
			}
			if(T.matches("soil"))
			{
				tableModel_soil.setDataVector(data, columnNames);
				row_soil = tableModel_soil.getRowCount();
			}
			else if(T.matches("crop"))
			{
				tableModel_crop.setDataVector(data, columnNames);
				row_crop = tableModel_crop.getRowCount();
			}
				else if(T.matches("rain"))
			{
				tableModel_rain.setDataVector(data, columnNames);
				row_rain = tableModel_rain.getRowCount();
			}
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
	}
}
