

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.border.MatteBorder;
import DbConnection.MyConnection;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField txtfirstname;
	private JTextField txtlastname;
	private JTextField txtusername;
	private JPasswordField txtpassword;
	
	private JPasswordField txtconfirmpass;
	private JTextField txtmobile;
	private JTextField txtmail;
	private JTextField txtaccountno;
	private JTextField txtbalance;
	
	public static void main(String[] args) {
		
					Registration frame = new Registration();
					frame.setVisible(true);
	}

	public Registration(){
		
		MyConnection m=new MyConnection();
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350,80,900,700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//add JPanel
		JPanel panelregister = new JPanel();
		panelregister.setBorder(new MatteBorder(2, 0, 2, 2, (Color) new Color(0, 0, 0)));
		panelregister.setBackground(new Color(255, 51, 51));
		panelregister.setBounds(415, 0, 485, 700);
		contentPane.add(panelregister);
		panelregister.setLayout(null);
		
		//add JLabel
		JLabel lblwelcome = new JLabel("Welcome..!");
		lblwelcome.setForeground(new Color(255, 255, 255));
		lblwelcome.setFont(new Font("Verdana", Font.PLAIN, 30));
		lblwelcome.setBounds(151, 10, 266, 32);
		panelregister.add(lblwelcome);
		
		//add JLabel
		JLabel lblregister = new JLabel("Register Now");
		lblregister.setForeground(new Color(255, 255, 255));
		lblregister.setFont(new Font("Verdana", Font.PLAIN, 30));
		lblregister.setBounds(125, 47, 325, 40);
		panelregister.add(lblregister);
		
		//add JLabel
		JLabel firstname = new JLabel("First Name : ");
		firstname.setForeground(new Color(255, 255, 255));
		firstname.setBackground(new Color(240, 240, 240));
		firstname.setFont(new Font("Verdana", Font.BOLD, 17));
		firstname.setBounds(28, 107, 127, 32);
		panelregister.add(firstname);
		
		//add JTextfield
		txtfirstname = new JTextField();
		txtfirstname.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtfirstname.setBounds(165, 114, 225, 24);
		panelregister.add(txtfirstname);
		txtfirstname.setColumns(10);
		
		//add JLabel
		JLabel lastname = new JLabel("Last Name : ");
		lastname.setForeground(new Color(255, 255, 255));
		lastname.setBackground(new Color(240, 240, 240));
		lastname.setFont(new Font("Verdana", Font.BOLD, 17));
		lastname.setBounds(28, 152, 127, 32);
		panelregister.add(lastname);
		
		//add JTextfield
		txtlastname = new JTextField();
		txtlastname.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtlastname.setBounds(165, 158, 225, 24);
		panelregister.add(txtlastname);
		txtlastname.setColumns(10);
		
		//add JLabel
		JLabel username = new JLabel("Username :");
		username.setForeground(Color.WHITE);
		username.setFont(new Font("Verdana", Font.BOLD, 17));
		username.setBackground(SystemColor.menu);
		username.setBounds(28, 203, 127, 32);
		panelregister.add(username);
		
		//add JTextfield
		txtusername = new JTextField();
		txtusername.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtusername.setColumns(10);
		txtusername.setBounds(165, 207, 225, 24);
		panelregister.add(txtusername);
		
		//add JLabel
		JLabel password = new JLabel("Password :");
		password.setForeground(Color.WHITE);
		password.setFont(new Font("Verdana", Font.BOLD, 17));
		password.setBackground(SystemColor.menu);
		password.setBounds(28, 245, 127, 32);
		panelregister.add(password);
		
		//add JPasswordField
		txtpassword = new JPasswordField();
		txtpassword.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtpassword.setColumns(10);
		txtpassword.setBounds(165, 252,225, 24);
		panelregister.add(txtpassword);
		
		JLabel confirmpass = new JLabel("Confirm  :");
		confirmpass.setForeground(Color.WHITE);
		confirmpass.setFont(new Font("Verdana", Font.BOLD, 17));
		confirmpass.setBackground(SystemColor.menu);
		confirmpass.setBounds(28, 286, 127, 32);
		panelregister.add(confirmpass);
		
		txtconfirmpass = new JPasswordField();
		txtconfirmpass.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtconfirmpass.setColumns(10);
		txtconfirmpass.setBounds(165, 293, 225, 24);
		panelregister.add(txtconfirmpass);
		
		JLabel Mobileno = new JLabel("Mobile No :");
		Mobileno.setForeground(Color.WHITE);
		Mobileno.setFont(new Font("Verdana", Font.BOLD, 17));
		Mobileno.setBackground(SystemColor.menu);
		Mobileno.setBounds(28, 328, 127, 32);
		panelregister.add(Mobileno);
		
		txtmobile = new JTextField();
		txtmobile.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtmobile.setColumns(10);
		txtmobile.setBounds(165, 335, 225, 24);
		panelregister.add(txtmobile);
		
		JLabel mail = new JLabel("Mail ID :");
		mail.setForeground(Color.WHITE);
		mail.setFont(new Font("Verdana", Font.BOLD, 17));
		mail.setBackground(SystemColor.menu);
		mail.setBounds(28, 370, 127, 32);
		panelregister.add(mail);
		
		txtmail = new JTextField();
		txtmail.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtmail.setColumns(10);
		txtmail.setBounds(165, 377, 225, 24);
		panelregister.add(txtmail);
		
		JLabel accountno = new JLabel("Account No  :");
		accountno.setForeground(Color.WHITE);
		accountno.setFont(new Font("Verdana", Font.BOLD, 16));
		accountno.setBackground(SystemColor.menu);
		accountno.setBounds(28, 412, 127, 32);
		panelregister.add(accountno);
		
		txtaccountno = new JTextField();
		txtaccountno.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtaccountno.setColumns(10);
		txtaccountno.setBounds(165, 419, 225, 24);
		panelregister.add(txtaccountno);
		
		JLabel balance = new JLabel("Balance :");
		balance.setForeground(Color.WHITE);
		balance.setFont(new Font("Verdana", Font.BOLD, 17));
		balance.setBackground(SystemColor.menu);
		balance.setBounds(28, 454, 127, 32);
		panelregister.add(balance);
		
		txtbalance = new JTextField();
		txtbalance.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtbalance.setColumns(10);
		txtbalance.setBounds(165, 461, 225, 24);
		panelregister.add(txtbalance);
		
		JLabel gender = new JLabel("Gender :");
		gender.setForeground(Color.WHITE);
		gender.setFont(new Font("Verdana", Font.BOLD, 17));
		gender.setBackground(SystemColor.menu);
		gender.setBounds(28, 496, 127, 32);
		panelregister.add(gender);
		
		JRadioButton rbtnmale = new JRadioButton("Male");
		rbtnmale.setForeground(Color.WHITE);
		rbtnmale.setFont(new Font("Verdana", Font.PLAIN, 18));
		rbtnmale.setBackground(new Color(255, 51, 51));
		rbtnmale.setBounds(162, 506, 79, 21);
		panelregister.add(rbtnmale);
		
		JRadioButton rbtnfemale = new JRadioButton("Female");
		rbtnfemale.setForeground(Color.WHITE);
		rbtnfemale.setFont(new Font("Verdana", Font.PLAIN, 18));
		rbtnfemale.setBackground(new Color(255, 51, 51));
		rbtnfemale.setBounds(236, 507, 91, 21);
		panelregister.add(rbtnfemale);
		
		rbtnmale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbtnmale.isSelected()) {
					rbtnfemale.setSelected(false);
				}
			}
		});
		
		rbtnfemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbtnfemale.isSelected()) {
					rbtnmale.setSelected(false);
				}
			}
		});
		
		JButton btnregister = new JButton("Register");
		btnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usergender = null;
				
				int mobileNo,accNo,accBal;
				Connection dbcon=null;
				PreparedStatement pstate=null;
				int i=0;
				
				dbcon=m.getConnection();
				Statement st;
				try {
					st = dbcon.createStatement();
					String sql="Select userName from register";
					ResultSet rs=st.executeQuery(sql);
					if(rs.next())
					{
						if(rs.getString(1).matches(txtusername.getText()))
						{
							JOptionPane.showMessageDialog(null,"Please enter other username it's repating.","Error",JOptionPane.ERROR_MESSAGE);
						}
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				if(txtfirstname.getText().trim().isEmpty()||txtlastname.getText().trim().isEmpty()||txtusername.getText().trim().isEmpty()||txtpassword.getText().trim().isEmpty()||txtmobile.getText().trim().isEmpty()||txtmail.getText().trim().isEmpty()||txtaccountno.getText().trim().isEmpty()||txtbalance.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Please fill the complete form.","Error",JOptionPane.ERROR_MESSAGE);
				}
				else if(!(txtmobile.getText().matches("^[0-9]*$")&&txtmobile.getText().length()==10)){
					JOptionPane.showMessageDialog(null,"Please enter valid mobile number.","Error",JOptionPane.ERROR_MESSAGE);
				}
				else if(!(txtmail.getText().matches("^[a-zA-Z0-0]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$"))) {
					JOptionPane.showMessageDialog(null,"Please enter valid mail id","Error",JOptionPane.ERROR_MESSAGE);
				}
				else if(!(txtpassword.getText().matches(txtconfirmpass.getText()))) {
					JOptionPane.showMessageDialog(null,"Password and confirm password is not matching.","Error",JOptionPane.ERROR_MESSAGE);
				}
				else if(txtpassword.getText().length()<8) {
					JOptionPane.showMessageDialog(null,"Password should be grater than 8 characters.","Error",JOptionPane.ERROR_MESSAGE);
				}
				else if(txtaccountno.getText().length()<12) {
					JOptionPane.showMessageDialog(null,"Please enter valid account number.","Error",JOptionPane.ERROR_MESSAGE);

				}
				else {
				try {
					String user=txtusername.getText();
					pstate=dbcon.prepareStatement("insert into register(firstName,lastName,userName,password,mobileNo,mailId,accNo,accBal,gender) values (?,?,?,?,?,?,?,?,?)");
					pstate.setString(1,txtfirstname.getText());
					pstate.setString(2,txtlastname.getText());
					pstate.setString(3,txtusername.getText());
					pstate.setString(4,txtpassword.getText());
					pstate.setString(5,txtmobile.getText());
					pstate.setString(6,txtmail.getText());
					pstate.setString(7,txtaccountno.getText());
					pstate.setString(8,txtbalance.getText());
					
					if(rbtnmale.isSelected()) {
						usergender="Male";
					}
					if(rbtnfemale.isSelected()) {
						usergender="Female";
					}
					pstate.setString(9,usergender);
					
					i=pstate.executeUpdate();
					if(i>0) {
						txtfirstname.setText("");
						txtlastname.setText("");
						txtusername.setText("");
						txtpassword.setText("");
						txtconfirmpass.setText("");
						txtmobile.setText("");
						txtmail.setText("");
						txtaccountno.setText("");
						txtbalance.setText("");
						JOptionPane.showMessageDialog(null,"You have registered successfully","Success",JOptionPane.INFORMATION_MESSAGE);
						/*Main m=new Main(user);
						m.setVisible(true);*/
						Login l=new Login();
						l.setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null,"There is a some eroor while registring");
					}
					
				} catch (SQLException e1) {
					
					JOptionPane.showMessageDialog(null,"Exception get occured while inserting a data.","Error",JOptionPane.ERROR_MESSAGE);
				}
				}
			}
		});
		
		btnregister.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnregister.setBorder(new LineBorder(new Color(255, 51, 51), 2));
		btnregister.setBackground(Color.WHITE);
		btnregister.setForeground(Color.BLACK);
		btnregister.setBounds(329, 650, 136, 32);
		panelregister.add(btnregister);
		
		JButton btnback = new JButton("Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Front f=new Front();
				f.setVisible(true);
				dispose();
			}
		});
		
		btnback.setForeground(Color.BLACK);
		btnback.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnback.setBorder(new LineBorder(new Color(255, 51, 51), 2));
		btnback.setBackground(Color.WHITE);
		btnback.setBounds(10, 650, 136, 32);
		panelregister.add(btnback);
		
		JLabel labelimg = new JLabel();
		ImageIcon icon=new ImageIcon(this.getClass().getResource("/registrationpage.jpeg"));
		labelimg.setIcon(icon);
		labelimg.setBounds(10, 73, 395, 502);
		contentPane.add(labelimg);	
	}
}
