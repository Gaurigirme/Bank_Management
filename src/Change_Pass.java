//Change password

//imported classes
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import DbConnection.MyConnection;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class Change_Pass extends JFrame {

	private JPasswordField txtconpass;
	private JTextField txtpass;
	
	private JPanel contentPane;
	//Parametric constructor
	public Change_Pass(String name) {
		//create the frame 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350,80,900,700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 51, 51));
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//add Jpanel
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 51, 51));
		panel.setBounds(206,124,511,458);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//add JLabel
		JLabel lblpass = new JLabel("Enter New Password :");
		lblpass.setForeground(Color.WHITE);
		lblpass.setFont(new Font("Verdana", Font.PLAIN, 22));
		lblpass.setBounds(39, 120, 267, 32);
		panel.add(lblpass);
		
		//add JLabel
		JLabel lblconpass = new JLabel("Confirm Password :");
		lblconpass.setForeground(Color.WHITE);
		lblconpass.setFont(new Font("Verdana", Font.PLAIN, 22));
		lblconpass.setBounds(39, 204, 237, 32);
		panel.add(lblconpass);
		
		//add action listener interface
		JButton btnchange = new JButton("Change");
		btnchange.addActionListener(new ActionListener() {
			//action listener method
			public void actionPerformed(ActionEvent e) {
					
					String pass=txtconpass.getText();
					//Apply validations to the form
					//check is there any text field  empty
					if(txtpass.getText().trim().isEmpty()||txtconpass.getText().trim().isEmpty()) {
						
						JOptionPane.showMessageDialog(null,"Please enter the password.","Error",JOptionPane.ERROR_MESSAGE);
					}
					//check the password and confirm password is matching or not
					else if(!(txtpass.getText().matches(pass)))
					{
						JOptionPane.showMessageDialog(null,"Confirm password is not matching to the password.","Error",JOptionPane.ERROR_MESSAGE);
					}
					//check the password length
					else if(txtpass.getText().length()<8) {
						JOptionPane.showMessageDialog(null,"Password should be grater than 8 characters.","Error",JOptionPane.ERROR_MESSAGE);

					}
					//storing the data to the database
					else 
					{
						//call myconnection method to connect the database to the java 
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
							//executing query
							pstate=dbcon.prepareStatement("update register set password=? where userName=?");
							pstate.setString(1,txtpass.getText());
							pstate.setString(2,name);
							
							i=pstate.executeUpdate();
							if(i>0) 
							{
								JOptionPane.showMessageDialog(null,"Successfully changed the password");
								Main ma=new Main(name);
								ma.setVisible(true);
								dispose();
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
		btnchange.setBackground(Color.WHITE);
		btnchange.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnchange.setBounds(372, 395, 118, 42);
		panel.add(btnchange);
		
		//add button
		JButton btnexit = new JButton("Exit");
		//action listener interface
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main m=new Main(name);
				m.setVisible(true);
				dispose();
			}
		});
		btnexit.setBackground(Color.WHITE);
		btnexit.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnexit.setBounds(24, 395, 109, 42);
		panel.add(btnexit);
		
		//add Jpasswordfield
		txtconpass = new JPasswordField();
		txtconpass.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtconpass.setBounds(316, 208, 136, 30);
		panel.add(txtconpass);
		
		//add Jtextfiled
		txtpass = new JTextField();
		txtpass.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpass.setBounds(316, 120, 136, 30);
		panel.add(txtpass);
		txtpass.setColumns(10);
		
		//add Jpanel
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(30, 33, 835, 636);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		//add JPanel
		JLabel lblheading = new JLabel("Change Password");
		lblheading.setBounds(271, 10, 322, 48);
		panel_1.add(lblheading);
		lblheading.setFont(new Font("Verdana", Font.PLAIN, 34));
		
		//add separator
		JSeparator headingline = new JSeparator();
		headingline.setBounds(271, 57, 322, 9);
		panel_1.add(headingline);
		headingline.setBackground(Color.BLACK);
		headingline.setForeground(Color.BLACK);
		setUndecorated(true);
	}
}
