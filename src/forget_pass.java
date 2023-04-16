

//imported classes
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import DbConnection.MyConnection;
import javax.swing.JSeparator;

public class forget_pass extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JPasswordField passwordField;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_2;
	private JSeparator separator;

	  //Create the frame.
	
	//parametric constructor
	public forget_pass(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 80, 650, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 51, 51));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		//add JLabel
		JLabel lblNewLabel = new JLabel("Create new password :");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblNewLabel.setBounds(41, 115, 242, 40);
		contentPane.add(lblNewLabel);
		
		//add JTextfield
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setBounds(302, 115, 176, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//add JLabel
		lblNewLabel_1 = new JLabel("Confirm password :");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblNewLabel_1.setBounds(41, 212, 217, 33);
		contentPane.add(lblNewLabel_1);
		
		//add JPasswordfield
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 255, 255));
		passwordField.setBounds(302, 210, 176, 39);
		contentPane.add(passwordField);
		
		//add JButton
		JButton btnNewButton = new JButton("Change");
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		//action listener method
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pass=passwordField.getText();
				//check validation
				//check the password validation
				if(!(textField.getText().matches(pass))) {
					JOptionPane.showMessageDialog(null,"Confirm password is not matching to the password.","Error",JOptionPane.ERROR_MESSAGE);
				}
				//check the JTextfiled is empty or not
				else if(textField.getText().trim().isEmpty()||passwordField.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Please enter the password.","Error",JOptionPane.ERROR_MESSAGE);

				}
				
				else {
					//create an object of my connection method
					MyConnection m=new MyConnection();
					Connection dbcon=null;
					PreparedStatement pstate=null;
					int i=0;
					//call my connection method
					dbcon=m.getConnection();
					Statement st;
				try
				{
					//execute query
					pstate=dbcon.prepareStatement("update register set password=? where userName=?");
					pstate.setString(1,textField.getText());
					pstate.setString(2,username);
					
					i=pstate.executeUpdate();
					if(i>0) {
						JOptionPane.showMessageDialog(null,"Successfully changed the password");
						//call the login page
						Login l=new Login();
						l.setVisible(true);
						dispose();
					}
					}
				
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"Exception get occured while instering a data.","Error",JOptionPane.ERROR_MESSAGE);

				}
				}
				
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnNewButton.setBounds(104, 326, 131, 40);
		contentPane.add(btnNewButton);
		
		//add JButton
		btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		//action listener method
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//call the login page
				Login l=new Login();
				l.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnNewButton_1.setBounds(337, 326, 124, 40);
		contentPane.add(btnNewButton_1);
		
		//add JLabel
		lblNewLabel_2 = new JLabel("Forget Password");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(199, 10, 308, 55);
		contentPane.add(lblNewLabel_2);
		
		//add separator
		separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(199, 57, 258, 7);
		contentPane.add(separator);
	}
}
