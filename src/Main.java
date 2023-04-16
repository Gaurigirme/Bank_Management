

//imported classes
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
public class Main extends JFrame {
	
	//Create the frame.
	 	
	 private JPanel contentPane;
	 //Parametric constructor
	public Main(String username) {
		
		String name=username;
		//launch frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 80, 900,700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setUndecorated(true);
		
		//add JPanel
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		contentPane.add(panel);
		
		//add JPanel
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(113, 10, 623, 65);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		//add JLabel
		JLabel lblNewLabel = new JLabel("Wonder Cash Bank");
		lblNewLabel.setForeground(new Color(255, 51, 51));
		lblNewLabel.setBounds(158, 10, 401, 38);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 36));		
		
		//add JPanel
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(49, 85, 175, 154);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		//add JLabel
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		//object of the image icon class
		ImageIcon icon=new ImageIcon(this.getClass().getResource("/profile2.png"));
		//add image on the JLabel
		lblNewLabel_1.setIcon(icon);
		lblNewLabel_1.setBounds(0, 0, 175, 154);
		panel_3.add(lblNewLabel_1,icon);
		
		//add JPanel
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(329, 85, 175, 154);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		//add JLabel
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		//object of the image icon class
		Icon icon2=new ImageIcon(this.getClass().getResource("/Recharge Service1.jpeg"));
		//add image on the JLabel
		lblNewLabel_2.setIcon(icon2);
		lblNewLabel_2.setBounds(0, 0, 175, 154);
		panel_4.add(lblNewLabel_2,icon2);
		
		//add JPanel
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(602, 85, 175, 154);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		//add JLabel
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBorder(new EmptyBorder(0, 0, 0, 0));
		//object of the image icon class
		Icon icon3=new ImageIcon(this.getClass().getResource("/password.jpeg"));
		//add image on the JLabel
		lblNewLabel_3.setIcon(icon3);
		lblNewLabel_3.setBounds(0, 0, 175, 154);
		panel_5.add(lblNewLabel_3,icon3);
		
		//add JPanel
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(49, 362, 175, 154);
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		//add JLabel
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBorder(new EmptyBorder(0, 0, 0, 0));
		//object of the image icon class
		Icon icon4=new ImageIcon(this.getClass().getResource("/withdraw_1.jpeg"));
		//add image on the JLabel
		lblNewLabel_5.setIcon(icon4);
		lblNewLabel_5.setBounds(0, 0, 175, 154);
		panel_6.add(lblNewLabel_5,icon4);
		
		//add JPanel
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(329, 362, 175, 154);
		panel.add(panel_7);
		panel_7.setLayout(null);
		
		//add JLabel
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBorder(new EmptyBorder(0, 0, 0, 0));
		//object of the image icon class
		ImageIcon icon5=new ImageIcon(this.getClass().getResource("/with1.jpg"));
		//add image on the JLabel
		lblNewLabel_4.setIcon(icon5);
		lblNewLabel_4.setBounds(0, 0, 175, 154);
		panel_7.add(lblNewLabel_4,icon5);
		
		//add JPanel
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(602, 362, 175, 154);
		panel.add(panel_8);
		panel_8.setLayout(null);
		
		//add JLabel
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBorder(new EmptyBorder(0, 0, 0, 0));
		//object of the image icon class
		Icon icon10=new ImageIcon(this.getClass().getResource("/check_balance.jpeg"));
		//add image on the JLabel
		lblNewLabel_6.setIcon(icon10);
		lblNewLabel_6.setBounds(0, 0, 175, 154);
		panel_8.add(lblNewLabel_6,icon10);
		
		//add JPanel
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(25, 75, 833, 528);
		panel.add(panel_9);
		panel_9.setLayout(null);
		
		//add JButton
		JButton btnNewButton_1 = new JButton("Profile");
		//action listener method
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//call the profile page
				UserProfile uprofile=new UserProfile(name);
				uprofile.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBorder(new LineBorder(new Color(255, 51, 51)));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		btnNewButton_1.setBounds(51, 197, 107, 40);
		panel_9.add(btnNewButton_1);
		
		//add JButton
		JButton btnNewButton_2 = new JButton("Recharge");
		//action listener method
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//call the recharge services page
				REchargeServices rs=new REchargeServices(name);
				rs.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBorder(new LineBorder(new Color(255, 51, 51)));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		btnNewButton_2.setBounds(328, 197, 107, 40);
		panel_9.add(btnNewButton_2);
		
		//add JButton
		JButton btnNewButton_3 = new JButton("Change Password");
		//add the action listener method
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//call the chnage password page
				Change_Pass chngpass=new Change_Pass(name);
				chngpass.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBorder(new LineBorder(new Color(255, 51, 51)));
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		btnNewButton_3.setBounds(581, 197, 195, 39);
		panel_9.add(btnNewButton_3);
		
		//add JButton
		JButton btnNewButton_4 = new JButton("Deposit Money");
		//action listener method
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//call the deposit page
				deposit d=new deposit(name);
				d.setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setBorder(new LineBorder(new Color(255, 51, 51)));
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		btnNewButton_4.setBounds(26, 470, 169, 40);
		panel_9.add(btnNewButton_4);
		
		//add JButton
		JButton btnNewButton_5 = new JButton("Withdraw Money");
		//action listener method
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//call the withdraw page
				withdraw d=new withdraw(name);
				d.setVisible(true);
				dispose();
			}
		});
		btnNewButton_5.setBorder(new LineBorder(new Color(255, 51, 51)));
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		btnNewButton_5.setBounds(311, 470, 195, 40);
		panel_9.add(btnNewButton_5);
		
		//add JButton
		JButton btnNewButton_5_1 = new JButton("Check Balance");
		//action listener method
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//call the check balance page
				CheckBal check=new CheckBal(name);
				check.setVisible(true);
				dispose();
			}
		});
		btnNewButton_5_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		btnNewButton_5_1.setBorder(new LineBorder(new Color(255, 51, 51)));
		btnNewButton_5_1.setBackground(Color.WHITE);
		btnNewButton_5_1.setBounds(581, 470, 195, 40);
		panel_9.add(btnNewButton_5_1);
		
		// add separator
		JSeparator separator = new JSeparator();
		separator.setBounds(421, 45, 1, 2);
		panel.add(separator);
		
		//add JButton
		JButton btnNewButton = new JButton();
		//action listener method
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response=JOptionPane.showConfirmDialog(null,"Do you confirm to logout?","Confirm",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(response==JOptionPane.YES_OPTION) {
					//call the front page
					Front f=new Front();
					f.setVisible(true);
					dispose();
				}
			}
		});
		//object of an image icon class
		Icon icon8=new ImageIcon(this.getClass().getResource("/log_2.png"));
		//add an image to the panel
		btnNewButton.setIcon(icon8);
		btnNewButton.setBounds(836, 10, 44, 47);
		panel.add(btnNewButton);
		
		//add JButton
		JButton btnNewButton_6 = new JButton();
		//action listener method
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//call the front page
				Front f=new Front();
				f.setVisible(true);
				dispose();
			}
		});
		//object of an image icon class
		ImageIcon icon9=new ImageIcon(this.getClass().getResource("/back.jpg"));
		//add an image to the panel
		btnNewButton_6.setIcon(icon9);
		btnNewButton_6.setBounds(25, 633, 62, 47);
		panel.add(btnNewButton_6);
		
		
	}
}