package algoProject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.*;
import java.util.Enumeration;
import java.util.Vector;

public class Crop_table_show extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	Connection c=null;
	Statement s=null;
	JavaSingleton jdbc= JavaSingleton.getInstance();
	DefaultTableModel tablemodel= new DefaultTableModel();
	Enumeration Venum;
		/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Crop_table_show frame = new Crop_table_show();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Crop_table_show() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 563);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegion = new JLabel("Region : ");
		lblRegion.setForeground(new Color(102, 153, 0));
		lblRegion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRegion.setBounds(84, 29, 57, 21);
		contentPane.add(lblRegion);
		
		JLabel lblSoilType = new JLabel("Soil Type :");
		lblSoilType.setForeground(new Color(102, 153, 0));
		lblSoilType.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSoilType.setBounds(84, 61, 72, 14);
		contentPane.add(lblSoilType);
		
		JLabel lblNewLabel = new JLabel("Start month : ");
		lblNewLabel.setForeground(new Color(102, 153, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(401, 36, 99, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("End Month : ");
		lblNewLabel_1.setForeground(new Color(102, 153, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(401, 61, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(82, 96, 561, 133);
		contentPane.add(scrollPane);
		
		table = new JTable(tablemodel);
		scrollPane.setViewportView(table);
		
		JLabel region = new JLabel("");
		region.setForeground(new Color(102, 153, 0));
		region.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		region.setBounds(150, 29, 108, 21);
		contentPane.add(region);
		
		JLabel start_month = new JLabel("");
		start_month.setForeground(new Color(102, 153, 0));
		start_month.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		start_month.setBounds(497, 29, 108, 21);
		contentPane.add(start_month);
		
		JLabel soil_type = new JLabel("");
		soil_type.setForeground(new Color(102, 153, 0));
		soil_type.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		soil_type.setBounds(150, 61, 108, 24);
		contentPane.add(soil_type);
		
		JLabel end_month = new JLabel("");
		end_month.setBounds(497, 62, 108, 23);
		contentPane.add(end_month);
	}
	
	public void loadData()
	{
		try
		{
			c = JavaSingleton.getConnection(); 
			s = c.createStatement();
			ResultSet RS = s.executeQuery("select *from crop");
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
                    //System.out.println();
                }
				Venum = vector.elements();
				System.out.println("\nElements in vector:");
			      while(Venum.hasMoreElements())
			         System.out.print(Venum.nextElement() + " ");
			      System.out.println();
                data.add(vector);
			}
			tablemodel.setDataVector(data, columnNames);
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
	}
}

