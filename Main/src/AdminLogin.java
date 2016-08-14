import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class AdminLogin extends WindowAdapter implements ActionListener
{
	JFrame k=new JFrame("AdminLogin");
	JLabel l1=new JLabel("USER NAME");
	JLabel l2=new JLabel("PASSWORD");
	JLabel l3 = new JLabel("userid not valid");
	JTextField t1=new JTextField(20);
	JTextField t2=new JTextField(20);
	
	JButton b1=new JButton("LOGIN");
	JButton b2=new JButton("CREATE N ACCOUNT");
	JButton b3=new JButton("FORGET PASSWORD");
	
		AdminLogin()
		{
			k.add(l1);
			k.add(t1);
			k.add(l2);
			k.add(t2);
			k.add(b1);
			k.add(b2);
			k.add(b3);
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			k.addWindowListener(this);
			k.setVisible(true);
			k.setLayout(new FlowLayout());
			k.setLocation(300,100);
			k.setBackground(Color.WHITE);
	
			k.setSize(300,300);
		}
	public void windowClosing(WindowEvent e)
		{
			System.out.println("windowClosing");
			System.exit(0);
		}
		public void actionPerformed(ActionEvent e)
		{	
			if(e.getSource()==b1)
				{
					String login = t1.getText();
					String password = t2.getText();
					String s = "SELECT userid, password from adminlogin WHERE userid='"+login+"' and password='"+password+"'";
					Statement st=JDBCClass.con();
					try {
						ResultSet rs=st.executeQuery(s);
						if(rs.next())
						{
							k.setVisible(false);
							new ActionPage();
						}
						else {
							k.add(l3);
						}
							
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(e.getSource()==b2)
				{
					k.setVisible(false);
				   new CreateAccount();
				
				}
				else if(e.getSource()==b3)
				{
				   k.setVisible(false);
				   new ForgetPass();
				}
		}
	}

