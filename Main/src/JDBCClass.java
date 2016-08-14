import java.sql.*;
import javax.swing.*;
public class JDBCClass
{
	public static Statement con()
	{
		String url="jdbc:mysql://localhost:3306/database";
		String pass="akash";
		String user="root";
		Statement st=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,pass);
			 st=con.createStatement();
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,""+ex);
		}
		return st;
	}
	
}
