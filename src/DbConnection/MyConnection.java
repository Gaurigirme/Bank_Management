package DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class MyConnection {
	public Connection getConnection() {
		Connection con=null;
		try {
			//step 1: Local drive for a database
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			//step 2: Connection to database
			//C:\oraclexe\app\oracle\product\10.2.0\server\NETWORK\ADMIN
			//Url information will get in the above path

			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String uname="System";
			String pass="gauri123";
			
			con=DriverManager.getConnection(url,uname,pass);
			
			System.out.println("Connection established");		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Connection exception.","Error",JOptionPane.ERROR_MESSAGE);
		}
		return con;
	}
}
