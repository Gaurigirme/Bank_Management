

//imported classes
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
public class Front extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_1;
	private static Front frame;
	
	public static void main(String[] args) {
	
					frame = new Front();
					frame.setVisible(true);			
	}

	//constructor
	public Front() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350,80,900,700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//add JLabel
		JLabel lblNewLabel = new JLabel("Wonder Cash Bank");
		lblNewLabel.setAlignmentY(0.5f);
		lblNewLabel.setAlignmentX(0.5f);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setForeground(new Color(255, 51, 51));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 38));
		lblNewLabel.setBounds(328, 30, 427, 95);
		contentPane.add(lblNewLabel);
		
		//add separator
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(255, 51, 51));
		separator.setForeground(new Color(255, 51, 51));
		separator.setBounds(321, 98, 345, 12);
		contentPane.add(separator);
		
		//add JLabel
		lblNewLabel_1 = new JLabel();
		ImageIcon icon=new ImageIcon(this.getClass().getResource("/Registration.jpg"));
		lblNewLabel_1.setIcon(icon);
		lblNewLabel_1.setBounds(86, 214, 356, 334);
		contentPane.add(lblNewLabel_1);
		
		//add JLabel
		JLabel lblNewLabel_2 = new JLabel();
		ImageIcon icon2=new ImageIcon(this.getClass().getResource("/Login2.jpg"));
		lblNewLabel_2.setIcon(icon2);
		lblNewLabel_2.setBounds(488, 214, 356, 334);
		contentPane.add(lblNewLabel_2);
		
		//add JButton
		JButton btnNewButton = new JButton("Registration");
		//action listener method
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//call registration page
				Registration register=new Registration();
				register.setVisible(true);
				dispose();
			}
		});
		
		//add JButton
		btnNewButton.setBorder(new LineBorder(new Color(255, 51, 51), 2));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnNewButton.setBounds(112, 509, 272, 57);
		contentPane.add(btnNewButton);
		
		//add Jbutton
		JButton btnNewButton_1 = new JButton("Login");
		//action listener
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l=new Login();
				l.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBorder(new LineBorder(new Color(255, 51, 51), 2));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnNewButton_1.setBounds(538, 511, 272, 57);
		contentPane.add(btnNewButton_1);
		
		
		
	}
}
