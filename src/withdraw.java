

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import DbConnection.MyConnection;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.Action;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class withdraw extends JFrame 
{
	
	
	
	
	/**
	 * Create the frame.
	 */
	private JPanel contentPane;
	
	private JTextField txtamt;
	public withdraw(String name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350,80,900,700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 51, 51));
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(32, 33, 833, 636);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 51, 51));
		panel_1.setBounds(151,88,546,472);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblsen = new JLabel("Enter the Amount to withdraw : ");
		lblsen.setForeground(Color.WHITE);
		lblsen.setFont(new Font("Verdana", Font.PLAIN, 22));
		lblsen.setBounds(10, 146, 374, 29);
		panel_1.add(lblsen);
		
		JButton btnexit = new JButton("Exit");
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main ma=new Main(name);
				ma.setVisible(true);
				dispose();
			}
		});
		btnexit.setBackground(Color.WHITE);
		btnexit.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnexit.setBounds(10, 419, 102, 42);
		panel_1.add(btnexit);
		
		JButton btneithdraw = new JButton("Withdraw");
		btneithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response=JOptionPane.showConfirmDialog(null,"Are you confirm to withdraw money.","Confirm",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(response==JOptionPane.YES_OPTION) {
					if(txtamt.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null,"Please enter the amount","Error",JOptionPane.ERROR_MESSAGE);
					}
					else {
						MyConnection m=new MyConnection();
						Connection dbcon=null;
						PreparedStatement pstate=null;
						int i=0;
					
						dbcon=m.getConnection();
						Statement st;
						int currBal=0;
						try
						{
														pstate=dbcon.prepareStatement("select accBal from register where userName=?");
							pstate.setString(1,name);
							ResultSet rs=pstate.executeQuery();
							
							while(rs.next()) {
								currBal=Integer.parseInt(rs.getString(1));
								
							}
							String rupees=txtamt.getText();
							int newBal=0;
							if(currBal<Integer.parseInt(rupees)) {
								JOptionPane.showMessageDialog(null,"You have less balance in your account.","Error",JOptionPane.ERROR_MESSAGE);
							}
							else {
								newBal=currBal-Integer.parseInt(rupees);
								pstate=dbcon.prepareStatement("update register set accBal=? where userName=?");
								pstate.setString(1,Integer.toString(newBal));
								pstate.setString(2,name);
								i=pstate.executeUpdate();
							}
							if(i>0) {
								JOptionPane.showMessageDialog(null,"Amount Withdraw successfully.","Success",JOptionPane.PLAIN_MESSAGE);
								Main ma=new Main(name);
								ma.setVisible(true);
								dispose();
							}
							}
						
						catch(Exception e1)
						{
							//JOptionPane.showMessageDialog(null,"Exception in database.","Error",JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						}
					}
				}
			}
		});
		
		btneithdraw.setBackground(Color.WHITE);
		btneithdraw.setFont(new Font("Verdana", Font.PLAIN, 20));
		btneithdraw.setBounds(402, 418, 134, 44);
		panel_1.add(btneithdraw);
		
		txtamt = new JTextField();
		txtamt.setFont(new Font("Verdana", Font.PLAIN, 15));
		txtamt.setBounds(383, 139, 113, 36);
		panel_1.add(txtamt);
		txtamt.setColumns(10);
		
		JLabel lblheading = new JLabel("Withdraw Money");
		lblheading.setFont(new Font("Verdana", Font.PLAIN, 34));
		lblheading.setBounds(291, 23, 293, 48);
		panel.add(lblheading);
		
		JSeparator headingline = new JSeparator();
		headingline.setBackground(Color.BLACK);
		headingline.setForeground(Color.BLACK);
		headingline.setBounds(291, 69, 293, 9);
		panel.add(headingline);
		setUndecorated(true);
	}
	
	
}
