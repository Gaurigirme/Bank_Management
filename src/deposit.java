
//imported classes
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import DbConnection.MyConnection;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class deposit extends JFrame 
{
	
	 //Create the frame.
	private JPanel contentPane;
	private JTextField txtamt;
	//parametric constructor
	public deposit(String name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350,80,900,700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 51, 51));
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//add JPanel
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(30, 33, 835, 636);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//add JPanel
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 51, 51));
		panel_1.setBounds(151,88,545,468);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		//add JLabel
		JLabel lblsen = new JLabel("Enter the Amount to deposit : ");
		lblsen.setForeground(Color.WHITE);
		lblsen.setFont(new Font("Verdana", Font.PLAIN, 22));
		lblsen.setBounds(10, 160, 374, 29);
		panel_1.add(lblsen);
		
		//add JButton
		JButton btnexit = new JButton("Exit");
		//action listener method
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main m=new Main(name);
				m.setVisible(true);
				dispose();
			}
		});
		btnexit.setBackground(Color.WHITE);
		btnexit.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnexit.setBounds(10, 415, 102, 42);
		panel_1.add(btnexit);
		
		//add JButton
		JButton btndeposit = new JButton("Deposit");
		btndeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response=JOptionPane.showConfirmDialog(null,"Are you confirm to deposit money.","Confirm",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(response==JOptionPane.YES_OPTION) {
					//check the validations
					
					//check the JTextfield is empty or not
					if(txtamt.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null,"Please enter the amount","Error",JOptionPane.ERROR_MESSAGE);
					}
					
					else {
						
						int i=0;
						int currBal=0;
						//call my connection method
						MyConnection m=new MyConnection();
						Connection dbcon=null;
						PreparedStatement pstate=null;
						dbcon=m.getConnection();
						Statement st;
						//checked exception
						//try block
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
								newBal=currBal+Integer.parseInt(rupees);
								pstate=dbcon.prepareStatement("update register set accBal=? where userName=?");
								pstate.setString(1,Integer.toString(newBal));
								pstate.setString(2,name);
								i=pstate.executeUpdate();
							
							if(i>0) {
								JOptionPane.showMessageDialog(null,"Amount deposited successfully.","Success",JOptionPane.PLAIN_MESSAGE);
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
			}
		});
		
		btndeposit.setBackground(Color.WHITE);
		btndeposit.setFont(new Font("Verdana", Font.PLAIN, 20));
		btndeposit.setBounds(408, 414, 127, 44);
		panel_1.add(btndeposit);
		
		//add JTextField
		txtamt = new JTextField();
		txtamt.setFont(new Font("Verdana", Font.PLAIN, 15));
		txtamt.setBounds(382, 153, 118, 36);
		panel_1.add(txtamt);
		txtamt.setColumns(10);
		
		//add JLabel
		JLabel lblheading = new JLabel("Deposit Money");
		lblheading.setFont(new Font("Verdana", Font.PLAIN, 34));
		lblheading.setBounds(291, 23, 293, 48);
		panel.add(lblheading);
		
		//add separator
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		separator.setBounds(291, 69, 254, 9);
		panel.add(separator);
		setUndecorated(true);
	}
}