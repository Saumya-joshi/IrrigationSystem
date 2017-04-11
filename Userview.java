package algoProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
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

public class Userview extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public Userview() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 563);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\java_development\\algoProject\\src\\images\\logo.jpg"));
		lblNewLabel.setBounds(250, 11, 207, 122);
		contentPane.add(lblNewLabel);
		
		JComboBox region_combobox = new JComboBox();
		region_combobox.setModel(new DefaultComboBoxModel(new String[] {"North", "South", "East", "West"}));
		region_combobox.setFont(new Font("Tahoma", Font.BOLD, 12));
		region_combobox.setForeground(new Color(102, 153, 0));
		region_combobox.setBounds(106, 158, 179, 35);
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
		soil_type.setBounds(312, 162, 79, 25);
		contentPane.add(soil_type);
		
		JComboBox soil_combobox = new JComboBox();
		soil_combobox.setModel(new DefaultComboBoxModel(new String[] {"Alluvial Soil", "Black Soil", "Literite Soil", "Mountain soil", "Red soil"}));
		soil_combobox.setForeground(new Color(102, 153, 0));
		soil_combobox.setFont(new Font("Tahoma", Font.BOLD, 12));
		soil_combobox.setBounds(394, 158, 179, 35);
		contentPane.add(soil_combobox);
		
		JButton search_btn = new JButton("Search");
		search_btn.setForeground(new Color(51, 0, 0));
		search_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Crop_table_show ts= new Crop_table_show();
				ts.setVisible(true);
				ts.loadData();
				
			}
		});
		search_btn.setFont(new Font("Tahoma", Font.BOLD, 15));
		search_btn.setBackground(new Color(102, 153, 0));
		search_btn.setBounds(283, 371, 134, 35);
		contentPane.add(search_btn);
		
		JLabel lblStartMonth = new JLabel("Start Month");
		lblStartMonth.setForeground(new Color(102, 153, 0));
		lblStartMonth.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStartMonth.setHorizontalAlignment(SwingConstants.CENTER);
		lblStartMonth.setBounds(10, 276, 86, 25);
		contentPane.add(lblStartMonth);
		
		JLabel lblEndMonth = new JLabel("End Month");
		lblEndMonth.setForeground(new Color(102, 153, 0));
		lblEndMonth.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEndMonth.setBounds(312, 276, 79, 25);
		contentPane.add(lblEndMonth);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox.setForeground(new Color(102, 153, 0));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox.setBounds(106, 273, 179, 35);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setForeground(new Color(102, 153, 0));
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox_1.setBounds(394, 280, 179, 28);
		contentPane.add(comboBox_1);
	}
}
