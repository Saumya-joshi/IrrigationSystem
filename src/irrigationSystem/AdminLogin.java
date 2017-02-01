package irrigationSystem;

import org.eclipse.wb.swing.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JPasswordField;
//import org.eclipse.wb.swing.FocusTraversalPolicy;
import java.awt.Component;
import javax.swing.JSeparator;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.Box;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminLogin extends JFrame{

	JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton login_btn;
	private static AdminLogin ex;

	/**
	 * Launch the application.
	 */
	Admin_verification db= new Admin_verification();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin window = new AdminLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminLogin() {
		initialize();
		setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 750, 563);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("./src/images/logo.jpg"));
		
		logo.setBounds(277, 39, 292, 107);
		frame.getContentPane().add(logo);
		
		JTextField user_name = new JTextField();
		user_name.setBounds(202, 267, 157, 30);
		frame.getContentPane().add(user_name);
		user_name.setColumns(10);
		
		JLabel username = new JLabel("Username");
		username.setFont(new Font("Tahoma", Font.BOLD, 12));
		username.setForeground(new Color(153, 153, 0));
		username.setBounds(202, 226, 77, 56);
		frame.getContentPane().add(username);
		
		JLabel password = new JLabel("Password");
		password.setFont(new Font("Tahoma", Font.BOLD, 12));
		password.setForeground(new Color(153, 153, 0));
		password.setBounds(202, 308, 77, 30);
		frame.getContentPane().add(password);
		
		JPasswordField password1 = new JPasswordField();
		password1.setBounds(202, 336, 157, 30);
		frame.getContentPane().add(password1);
		
		JLabel forgot = new JLabel("Forgot Your Password?");
		forgot.setFont(new Font("Tahoma", Font.PLAIN, 10));
		forgot.setForeground(new Color(0, 0, 204));
		forgot.setBounds(369, 336, 179, 30);
		frame.getContentPane().add(forgot);
		
		login_btn = new JButton("Log In");
		login_btn.setFont(new Font("Tahoma", Font.BOLD, 13));
		login_btn.setBackground(new Color(102, 153, 0));
		login_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click_login) {
				char[] temp_user_pwd = password1.getPassword();
				String pass= null;
				pass=String.copyValueOf(temp_user_pwd);
				if(db.check_login_details(user_name.getText(), pass))
				{
					System.out.println("Successful login");
					Adminview AV = new Adminview();
					AV.setVisible(true);
				}
				else
				{
					System.out.println("Login failed");
				}
				
			}
		});
		login_btn.setBounds(224, 377, 123, 38);
		frame.getContentPane().add(login_btn);
		
		JCheckBox chckbxRememberMe = new JCheckBox("Remember me");
		chckbxRememberMe.setForeground(new Color(0, 0, 153));
		chckbxRememberMe.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chckbxRememberMe.setBounds(202, 434, 112, 22);
		frame.getContentPane().add(chckbxRememberMe);
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(117, 190, 517, 323);
		frame.getContentPane().add(panel);
		
		JLabel admin = new JLabel("Admin");
		admin.setHorizontalAlignment(SwingConstants.CENTER);
		admin.setForeground(new Color(51, 153, 0));
		admin.setFont(new Font("Tahoma", Font.BOLD, 15));
		admin.setBounds(146, 161, 207, 32);
		frame.getContentPane().add(admin);
		
		JLabel user = new JLabel("User");
		user.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent event) {
				//JFrame frame=new JFrame("User View");
				//frame.setVisible(true);
				JDialog userView = new Userview();
				userView.setModal(true);
				userView.setVisible(true);
				
				//ex.frame.setVisible(false);
			}
		});
		user.setHorizontalAlignment(SwingConstants.CENTER);
		user.setForeground(new Color(102, 153, 0));
		user.setFont(new Font("Tahoma", Font.BOLD, 15));
		user.setBounds(390, 161, 207, 32);
		frame.getContentPane().add(user);
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{logo, textField, username, password1, forgot, login_btn, chckbxRememberMe, passwordField}));
	}
}