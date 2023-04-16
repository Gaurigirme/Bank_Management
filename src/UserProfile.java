

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import DbConnection.MyConnection;
import javax.swing.*;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserProfile extends JFrame {

	private JPanel userprofile;
	private JTextField txtfirstname;
	private JTextField txtlname;
	private JTextField txtusername;
	private JTextField txtpass;
	private JTextField txtmobile;
	private JTextField txtmail;
	private JTextField txtgender;
	private JTextField txtaccno;
	private JTextField txtaccbal;

	public UserProfile(String name) {
		String fname=null,lname=null,pass=null,mail=null,ugender=null,uname=null;
		String umobile = null,uaccno=null,uaccbal=null;
		MyConnection m=new MyConnection();
		Connection dbcon=null;
		PreparedStatement pstate=null;
		int i=0;
	
		dbcon=m.getConnection();
		Statement st;
		try {
			pstate=dbcon.prepareStatement("select * from register where userName=?");
			pstate.setString(1,name);
			ResultSet rs=pstate.executeQuery();
			
			while(rs.next()) {
				fname=rs.getString(1);
				lname=rs.getString(2);
				uname=rs.getString(3);
				pass=rs.getString(4);
				umobile=rs.getString(5);
				mail=rs.getString(6);
				uaccno=rs.getString(7);
				uaccbal=rs.getString(8);
				ugender=rs.getString(9);
			}
			}
		catch(Exception e) {
			
		}
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350,80,900,700);
		userprofile = new JPanel();
		userprofile.setBackground(Color.WHITE);
		userprofile.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(userprofile);
		userprofile.setLayout(null);
		
		JPanel profilepanel = new JPanel();
		profilepanel.setBounds(0, 0, 475, 700);
		profilepanel.setBackground(new Color(255, 51, 51));
		profilepanel.setBorder(new MatteBorder(2, 2, 2, 0, (Color) new Color(0, 0, 0)));
		userprofile.add(profilepanel);
		profilepanel.setLayout(null);
		
		JLabel hading = new JLabel("User");
		hading.setFont(new Font("Verdana", Font.BOLD, 30));
		hading.setForeground(new Color(255, 255, 255));
		hading.setBounds(397, 10, 78, 40);
		profilepanel.add(hading);
		
		JSeparator separator1 = new JSeparator();
		separator1.setForeground(new Color(255, 255, 255));
		separator1.setBounds(386, 48, 89, 12);
		profilepanel.add(separator1);
		
		JLabel firstname = new JLabel("First Name :");
		firstname.setForeground(Color.WHITE);
		firstname.setFont(new Font("Verdana", Font.PLAIN, 20));
		firstname.setBounds(71, 95, 152, 30);
		profilepanel.add(firstname);
		
		txtfirstname = new JTextField();
		txtfirstname.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtfirstname.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtfirstname.setForeground(new Color(255, 255, 255));
		txtfirstname.setBackground(new Color(255, 51, 51));
		txtfirstname.setBounds(216, 100, 234, 30);
		profilepanel.add(txtfirstname);
		txtfirstname.setColumns(10);
		txtfirstname.setText(fname);
		
		JSeparator fnameline = new JSeparator();
		fnameline.setForeground(new Color(255, 255, 255));
		fnameline.setBounds(71, 124, 120, 2);
		profilepanel.add(fnameline);
		
		JLabel lastname = new JLabel("Last Name :");
		lastname.setForeground(Color.WHITE);
		lastname.setFont(new Font("Verdana", Font.PLAIN, 20));
		lastname.setBounds(71, 148, 152, 30);
		profilepanel.add(lastname);
		
		JSeparator lnameline = new JSeparator();
		lnameline.setForeground(Color.WHITE);
		lnameline.setBounds(71, 177, 120, 2);
		profilepanel.add(lnameline);
		
		txtlname = new JTextField();
		txtlname.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtlname.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtlname.setForeground(new Color(255, 255, 255));
		txtlname.setBackground(new Color(255, 51, 51));
		txtlname.setBounds(216, 150, 234, 30);
		profilepanel.add(txtlname);
		txtlname.setColumns(10);
		txtlname.setText(lname);
		
		JLabel username = new JLabel("Username :");
		username.setForeground(Color.WHITE);
		username.setFont(new Font("Verdana", Font.PLAIN, 20));
		username.setBounds(71, 206, 152, 30);
		profilepanel.add(username);
		
		JSeparator unameline = new JSeparator();
		unameline.setForeground(Color.WHITE);
		unameline.setBounds(71, 235, 120, 2);
		profilepanel.add(unameline);
		
		txtusername = new JTextField();
		txtusername.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtusername.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtusername.setForeground(new Color(255, 255, 255));
		txtusername.setBackground(new Color(255, 51, 51));
		txtusername.setBounds(216, 210, 234, 30);
		profilepanel.add(txtusername);
		txtusername.setColumns(10);
		txtusername.setText(uname);
		
		JLabel password = new JLabel("Password :");
		password.setForeground(Color.WHITE);
		password.setFont(new Font("Verdana", Font.PLAIN, 20));
		password.setBounds(71, 263, 152, 30);
		profilepanel.add(password);
		
		txtpass = new JTextField();
		txtpass.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtpass.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtpass.setForeground(new Color(255, 255, 255));
		txtpass.setBackground(new Color(255, 51, 51));
		txtpass.setColumns(10);
		txtpass.setBounds(216, 268, 234, 30);
		profilepanel.add(txtpass);
		txtpass.setText(pass);
		
		JSeparator passline = new JSeparator();
		passline.setForeground(Color.WHITE);
		passline.setBounds(71, 292, 106, 2);
		profilepanel.add(passline);
		
		JLabel mobile = new JLabel("Mobile No :");
		mobile.setForeground(Color.WHITE);
		mobile.setFont(new Font("Verdana", Font.PLAIN, 20));
		mobile.setBounds(71, 318, 152, 30);
		profilepanel.add(mobile);
		
		txtmobile = new JTextField();
		txtmobile.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtmobile.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtmobile.setForeground(new Color(255, 255, 255));
		txtmobile.setBackground(new Color(255, 51, 51));
		txtmobile.setColumns(10);
		txtmobile.setBounds(216, 323, 234, 30);
		profilepanel.add(txtmobile);
		txtmobile.setText(umobile);
		
		JSeparator mobileline = new JSeparator();
		mobileline.setForeground(Color.WHITE);
		mobileline.setBounds(71, 347, 120, 2);
		profilepanel.add(mobileline);
		
		JLabel mailid = new JLabel("Mail ID :");
		mailid.setForeground(Color.WHITE);
		mailid.setFont(new Font("Verdana", Font.PLAIN, 20));
		mailid.setBounds(71, 371, 152, 30);
		profilepanel.add(mailid);
		
		txtmail = new JTextField();
		txtmail.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtmail.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtmail.setForeground(new Color(255, 255, 255));
		txtmail.setBackground(new Color(255, 51, 51));
		txtmail.setColumns(10);
		txtmail.setBounds(216, 376, 234, 30);
		profilepanel.add(txtmail);
		txtmail.setText(mail);
		
		JSeparator mailine = new JSeparator();
		mailine.setForeground(Color.WHITE);
		mailine.setBounds(71, 400, 89, 2);
		profilepanel.add(mailine);
		
		JLabel gender = new JLabel("Gender :");
		gender.setForeground(Color.WHITE);
		gender.setFont(new Font("Verdana", Font.PLAIN, 20));
		gender.setBounds(71, 426, 152, 30);
		profilepanel.add(gender);
		
		txtgender = new JTextField();
		txtgender.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtgender.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtgender.setForeground(new Color(255, 255, 255));
		txtgender.setBackground(new Color(255, 51, 51));
		txtgender.setColumns(10);
		txtgender.setBounds(216, 431, 234, 30);
		profilepanel.add(txtgender);
		txtgender.setText(ugender);
		
		JSeparator genderline = new JSeparator();
		genderline.setForeground(Color.WHITE);
		genderline.setBounds(71, 455, 89, 2);
		profilepanel.add(genderline);
		
		JLabel accno = new JLabel("Account No :");
		accno.setForeground(Color.WHITE);
		accno.setFont(new Font("Verdana", Font.PLAIN, 20));
		accno.setBounds(71, 481, 152, 30);
		profilepanel.add(accno);
		
		
		txtaccno = new JTextField();
		txtaccno.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtaccno.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtaccno.setForeground(new Color(255, 255, 255));
		txtaccno.setBackground(new Color(255, 51, 51));
		txtaccno.setColumns(10);
		txtaccno.setBounds(216, 481, 234, 30);
		profilepanel.add(txtaccno);
		txtaccno.setText(uaccno);
		
		JSeparator accnoline = new JSeparator();
		accnoline.setForeground(Color.WHITE);
		accnoline.setBounds(71, 510, 125, 2);
		profilepanel.add(accnoline);
		
		JLabel accbal = new JLabel("Account Balance :");
		accbal.setForeground(Color.WHITE);
		accbal.setFont(new Font("Verdana", Font.PLAIN, 20));
		accbal.setBounds(71, 536, 205, 30);
		profilepanel.add(accbal);
		
		txtaccbal = new JTextField();
		txtaccbal.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtaccbal.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtaccbal.setForeground(new Color(255, 255, 255));
		txtaccbal.setBackground(new Color(255, 51, 51));
		txtaccbal.setColumns(10);
		txtaccbal.setBounds(216, 577, 234, 30);
		profilepanel.add(txtaccbal);
		txtaccbal.setText(uaccbal);
		
		JSeparator accballine = new JSeparator();
		accballine.setForeground(Color.WHITE);
		accballine.setBounds(71, 565, 181, 2);
		profilepanel.add(accballine);
		
		JButton btnNewButton = new JButton();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main m=new Main(name);
				m.setVisible(true);
				dispose();
			}
		});
		ImageIcon bicon=new ImageIcon(this.getClass().getResource("/back.jpg"));
		btnNewButton.setIcon(bicon);
		btnNewButton.setBounds(24, 654, 26, 24);
		profilepanel.add(btnNewButton);
		
		JLabel hading2 = new JLabel("Profile");
		hading2.setForeground(new Color(255, 51, 51));
		hading2.setFont(new Font("Tahoma", Font.BOLD, 28));
		hading2.setBounds(475, 10, 113, 40);
		userprofile.add(hading2);
		
		JSeparator separator2 = new JSeparator();
		separator2.setForeground(new Color(255, 51, 51));
		separator2.setBounds(475, 48, 108, 12);
		userprofile.add(separator2);
		
		JLabel lblimg = new JLabel();
		ImageIcon icon=new ImageIcon(this.getClass().getResource("/profile.jpg"));
		lblimg.setIcon(icon);
		lblimg.setBounds(485, 76, 405, 562);
		userprofile.add(lblimg);
		
	}
}
