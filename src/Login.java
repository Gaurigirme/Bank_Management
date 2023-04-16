

//imported classes
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import DbConnection.MyConnection;
import javax.swing.*;
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterUsername;
	private JPasswordField passwordField;

	public static void main(String[] args) {
					Login frame = new Login();
					frame.setVisible(true);
					frame.show();		
	}

	//constructor
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 80, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		//add JPanel
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(2, 0, 2, 2, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 51, 51));
		panel.setBounds(503, 0, 397, 700);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//add JLabel
		JLabel lblNewLabel_1 = new JLabel("Welcome");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 25));
		lblNewLabel_1.setBounds(117, 49, 146, 42);
		panel.add(lblNewLabel_1);
		
		//add JLabel
		JLabel lblNewLabel_2 = new JLabel("Login To Your Account");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 25));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(39, 104, 307, 32);
		panel.add(lblNewLabel_2);
		
		//add JLabel
		JLabel lblNewLabel_2_1 = new JLabel("Username :");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(68, 176, 157, 32);
		panel.add(lblNewLabel_2_1);
		
		//add JTextField
		txtEnterUsername = new JTextField();
		txtEnterUsername.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtEnterUsername.setForeground(Color.BLACK);
		txtEnterUsername.setBounds(68, 224, 249, 32);
		panel.add(txtEnterUsername);
		txtEnterUsername.setColumns(10);
		
		//add JLabel
		JLabel lblNewLabel_2_1_1 = new JLabel("Password :");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_2_1_1.setBounds(68, 282, 157, 32);
		panel.add(lblNewLabel_2_1_1);
		
		//add JButton
		JButton btnlogin = new JButton("Login");
		btnlogin.setBorder(new LineBorder(new Color(0, 0, 0)));
		//action listener method
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=txtEnterUsername.getText();
				String password=passwordField.getText();
				
					//if both username and password are blank...
					if(username.equals("")&&password.equals(""))
					{
						JOptionPane.showMessageDialog(null,"Please enter the username and password.","Error",JOptionPane.ERROR_MESSAGE);
					}
					//if username is enter but password is null...
					else if(!(username.equals(""))&& password.equals(""))
					{
						JOptionPane.showMessageDialog(null,"Please enter the password.","Error",JOptionPane.ERROR_MESSAGE);
					}
					//if password is enter but username is null...
					else if(username.equals("")&& !(password.equals("")))
					{
						JOptionPane.showMessageDialog(null,"Please enter the username.","Error",JOptionPane.ERROR_MESSAGE);
					}
					else {
						MyConnection m=new MyConnection();
						Connection dbcon=null;
						PreparedStatement pstate=null;
						int i=0;
						//call my connection method
						dbcon=m.getConnection();
						Statement st;
						ResultSet rs;
						//checked exception
						//try block
						try
						{
							//execute query
							pstate=dbcon.prepareStatement("select userName from register");
							ResultSet rst=pstate.executeQuery();
							while(rst.next()) {
								System.out.println("Hello");
								if(rst.getString(1).equals(txtEnterUsername.getText())){
									pstate=dbcon.prepareStatement("select password from register where userName=?");
									pstate.setString(1,txtEnterUsername.getText());
									rs=pstate.executeQuery();
									
									if(rs.next()) {
										if(rs.getString(1).matches(passwordField.getText()))
										{
											JOptionPane.showMessageDialog(null,"Login successful");
											Main ma=new Main(txtEnterUsername.getText());
											ma.show();
											dispose();
										}
										else
										{
											JOptionPane.showMessageDialog(null,"Wrong username or password.","Error",JOptionPane.ERROR_MESSAGE);
										}
									}
									break;
								}
								else {
									JOptionPane.showMessageDialog(null,"Please enter the correct user name.","Error",JOptionPane.ERROR_MESSAGE);

								}
							}
							
						}
						//catch block
						catch(Exception e1)
						{
							//exception handling
							JOptionPane.showMessageDialog(null,"Exception get occured while instering a data.","Error",JOptionPane.ERROR_MESSAGE);

						}
					}
					
				}
		});
		
		btnlogin.setForeground(Color.BLACK);
		btnlogin.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnlogin.setBounds(263, 646, 124, 30);
		panel.add(btnlogin);
		
		String user=txtEnterUsername.getText();
		
		//add JButton
		JButton btnNewButton_1 = new JButton("Forget Password?");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(204, 204, 204));
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnNewButton_1.addActionListener(new ActionListener() {
			//action listener method
			public void actionPerformed(ActionEvent e) {
				if(txtEnterUsername.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Please enter the username.","Error",JOptionPane.ERROR_MESSAGE);
				}
				else if(!(txtEnterUsername.getText().trim().isEmpty())) {
					MyConnection m=new MyConnection();
					Connection dbcon=null;
					PreparedStatement pstate=null;
					int i=0;
				
					dbcon=m.getConnection();
					Statement st;
					//checked exception
					//try block
					try
					{
						st=dbcon.createStatement();
						String sql="Select userName from register";
						ResultSet rs=st.executeQuery(sql);
						if(rs.next())
						{
							if(!(rs.getString(1).matches(txtEnterUsername.getText())))
							{
								JOptionPane.showMessageDialog(null,"Please enter the correct username.","Error",JOptionPane.ERROR_MESSAGE);
							}
							else {
								
								String name=txtEnterUsername.getText();
								forget_pass fp=new forget_pass(name);
								fp.setVisible(true);
								dispose();
							}
						}
					}
					//catch block
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null,"Exception get occured while instering a data.","Error",JOptionPane.ERROR_MESSAGE);

					}
				}
				else {
				forget_pass fp=new forget_pass(user);
				fp.setVisible(true);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnNewButton_1.setBounds(112, 383, 205, 30);
		panel.add(btnNewButton_1);
		
		//add JPasswordField
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Verdana", Font.PLAIN, 18));
		passwordField.setBounds(68, 335, 249, 32);
		panel.add(passwordField);
		
		//add JButton
		JButton btnback = new JButton("Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//call front page
				Front f=new Front();
				f.setVisible(true);
				dispose();
			}
		});
		btnback.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnback.setForeground(Color.BLACK);
		btnback.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnback.setBounds(10, 647, 124, 32);
		panel.add(btnback);
		
		//add JPanel
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 504, 700);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		//add JLabel
		JLabel lblNewLabel_3 = new JLabel("");
		ImageIcon icon=new ImageIcon(this.getClass().getResource("/ma.jpg"));
		lblNewLabel_3.setBounds(37, 139, 370, 419);
		panel_1.add(lblNewLabel_3);
		
		//add JLabel
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.setBounds(37, 113, 355, 432);
		panel_1.add(lblNewLabel);
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setIcon(icon);
		//contentPane.add(panel_1);
	}
	
		
}
