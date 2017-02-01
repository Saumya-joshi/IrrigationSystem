package irrigationSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import java.awt.SystemColor;
import java.awt.Window;

public class Start extends JFrame 
{
	private JPanel contentPane;
	private static JProgressBar progressBar = new JProgressBar();
	private static int count;
    private static Timer timer1;
    private static Start execute;
    private static AdminLogin ex;
    private int value = 1000;
    private static JLabel progrss_info =  new JLabel("Loading...");

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try 
				{
					execute = new Start();
					execute.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public Start() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JLabel label_background = new JLabel("");
		label_background.setFont(new Font("FangSong", Font.BOLD, 12));
		label_background.setBackground(Color.WHITE);
		label_background.setIcon(new ImageIcon("./src/images/img.jpg"));
		//label_background.setIcon(new ImageIcon("./src/images/irrigation-canals.jpg"));
		label_background.setBounds(0, 0, 450, 300);
		contentPane.add(label_background);
		
		//JLabel lblNewLabel_1 = new JLabel("Loading");
		progrss_info.setBackground(Color.WHITE);
		progrss_info.setForeground(Color.WHITE);
		progrss_info.setFont(new Font("Serif", Font.BOLD, 12));
		progrss_info.setBounds(0, 275, 450, 14);
		label_background.add(progrss_info);
		progressBar.setForeground(new Color(0, 128, 0));
		progressBar.setBounds(0, 290, 450, 15);
		contentPane.add(progressBar);
		
		loadProgressBar();
		setLocationRelativeTo(null);
	}
	
	private void loadProgressBar() 
	{
		try
		{
			ActionListener AL = new ActionListener()
			{
				public void actionPerformed(java.awt.event.ActionEvent evt) 
				{
					try
					{
						Thread.sleep(value);
						count++;
		                progressBar.setValue(count);
		                if(count == 20)
		                {
		                	progrss_info.setText("Applying Settings..");
		                }
		                else if(count == 60)
		                {
		                	progrss_info.setText("Loading Components...");
		                }
		                else if(count == 90)
		                {
		                	progrss_info.setText("Loading Window..");
		                }
		                else if (count == 100) 
		                {
		                    createFrame();
		                    execute.setVisible(false);
		                    timer1.stop();
		                }
		                value = 50;
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
	            }
				private void createFrame()
				{
					ex = new AdminLogin();
					ex.frame.setVisible(true);
				}
			};
			timer1 = new Timer(50, AL);
			timer1.start();
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
	}
}
