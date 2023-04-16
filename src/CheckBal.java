

//imported classes
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import DbConnection.MyConnection;
import javax.swing.JTextField;
import java.awt.Component;

public class CheckBal extends JFrame {

	 //Create the frame.
	
	private JPanel contentPane;
	private JTextField txtacbal;
	private JTextField txtacno;
	private JTextField txtuname;
	private JTextField txtname;
	
	//Parametric constructor
	public CheckBal(String name) {
		
		String fname=null,lname=null,uname=null;
		String uaccno=null,uaccbal=null;
		MyConnection m=new MyConnection();
		Connection dbcon=null;
		PreparedStatement pstate=null;
		int i=0;
		
		//call connection method
		dbcon=m.getConnection();
		Statement st;
		
		//checked exception
		//try block
		try {
			
			pstate=dbcon.prepareStatement("select firstName,lastName,userName,accNo,accbal from register where userName=?");
			pstate.setString(1,name);
			ResultSet rs=pstate.executeQuery();
			
			while(rs.next()) {
				fname=rs.getString(1);
				lname=rs.getString(2);
				uname=rs.getString(3);
				uaccno=rs.getString(4);
				uaccbal=rs.getString(5);
				
			}
			}
		//catch block
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Exception get occured while instering a data.","Error",JOptionPane.ERROR_MESSAGE);
		}
		
		//Launch the frame
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350,80,900,700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//add JPanel
		JPanel toppanel = new JPanel();
		toppanel.setBorder(new MatteBorder(2, 2, 0, 2, (Color) new Color(0, 0, 0)));
		toppanel.setBackground(new Color(255, 51, 51));
		toppanel.setBounds(0, 0, 900, 39);
		contentPane.add(toppanel);
		
		//add JPanel
		JPanel leftpanel = new JPanel();
		leftpanel.setBorder(new MatteBorder(0, 2, 2, 0, (Color) new Color(0, 0, 0)));
		leftpanel.setBackground(new Color(255, 51, 51));
		leftpanel.setBounds(0, 33, 45, 667);
		contentPane.add(leftpanel);
		
		//add JPanel
		JPanel bottompanel = new JPanel();
		bottompanel.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(0, 0, 0)));
		bottompanel.setBackground(new Color(255, 51, 51));
		bottompanel.setBounds(44, 658, 856, 42);
		contentPane.add(bottompanel);
		
		//add JPanel
		JPanel rightpanel = new JPanel();
		rightpanel.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 0, 0)));
		rightpanel.setBackground(new Color(255, 51, 51));
		rightpanel.setBounds(854, 33, 46, 630);
		contentPane.add(rightpanel);
		
		//add JPanel
		JPanel middlepanel = new JPanel();
		middlepanel.setBackground(new Color(255, 51, 51));
		middlepanel.setBounds(206, 124, 511, 458);
		contentPane.add(middlepanel);
		middlepanel.setLayout(null);
		
		//add JButton
		JButton btnexit = new JButton("Exit");
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main m=new Main(name);
				m.setVisible(true);
				dispose();
			}
		});
		btnexit.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(22, 406, 100, 31);
		middlepanel.add(btnexit);
		
		//Add JLabel
		JLabel lblname = new JLabel("Name :");
		lblname.setForeground(Color.WHITE);
		lblname.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblname.setBounds(22, 63, 92, 31);
		middlepanel.add(lblname);
		
		//add JLabel
		JLabel lbluname = new JLabel("Username :");
		lbluname.setFont(new Font("Verdana", Font.PLAIN, 20));
		lbluname.setForeground(Color.WHITE);
		lbluname.setBounds(22, 115, 136, 38);
		middlepanel.add(lbluname);
		
		//add Jabel
		JLabel lblacbal = new JLabel("Account Balance is  : ");
		lblacbal.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblacbal.setForeground(Color.WHITE);
		lblacbal.setBounds(144, 258, 233, 31);
		middlepanel.add(lblacbal);
		
		//add JTextField
		txtacbal = new JTextField();
		txtacbal.setAlignmentX(Component.RIGHT_ALIGNMENT);
		txtacbal.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtacbal.setBackground(new Color(255, 51, 51));
		txtacbal.setForeground(Color.WHITE);
		txtacbal.setFont(new Font("Verdana", Font.PLAIN, 30));
		txtacbal.setBounds(144, 284, 220, 58);
		middlepanel.add(txtacbal);
		txtacbal.setColumns(10);
		txtacbal.setText(uaccbal);
		
		//add JLabel
		JLabel lblacno = new JLabel("Account Number : ");
		lblacno.setForeground(Color.WHITE);
		lblacno.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblacno.setBounds(22, 176, 191, 38);
		middlepanel.add(lblacno);
		
		//add JTextfield
		txtacno = new JTextField();
		txtacno.setForeground(new Color(255, 255, 255));
		txtacno.setBackground(new Color(255, 51, 51));
		txtacno.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtacno.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtacno.setColumns(10);
		txtacno.setBounds(213, 175, 298, 44);
		middlepanel.add(txtacno);
		txtacno.setText(uaccno);
		
		//add JTextField
		txtuname = new JTextField();
		txtuname.setForeground(Color.WHITE);
		txtuname.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtuname.setColumns(10);
		txtuname.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtuname.setBackground(new Color(255, 51, 51));
		txtuname.setBounds(185, 114, 292, 44);
		middlepanel.add(txtuname);
		txtuname.setText(uname);
		
		//add JTextField
		txtname = new JTextField();
		txtname.setForeground(Color.WHITE);
		txtname.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtname.setColumns(10);
		txtname.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtname.setBackground(new Color(255, 51, 51));
		txtname.setBounds(124, 61, 298, 38);
		middlepanel.add(txtname);
		String fullName=fname+" "+lname;
		txtname.setText(fullName);
		
		//add JLabel
		JLabel lblheading = new JLabel("Account Balance");
		lblheading.setFont(new Font("Verdana", Font.PLAIN, 34));
		lblheading.setBounds(331, 61, 371, 48);
		contentPane.add(lblheading);
		
		//add JSeprator
		JSeparator headingline = new JSeparator();
		headingline.setForeground(Color.BLACK);
		headingline.setBounds(331, 105, 265, 15);
		contentPane.add(headingline);
	}
}
