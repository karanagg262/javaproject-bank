import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CreateAccount extends WindowAdapter implements ActionListener
{
	JFrame k=new JFrame(" OPEN NEW ACCOUNT");
	JLabel l8= new JLabel("PLEASE ENTER YOUR DATA");
	JLabel l1=new JLabel("Name:");
	JTextField t1=new JTextField(20);
	JLabel l2=new JLabel("E-mail:");
	JTextField t2=new JTextField(20);
	JLabel l3=new JLabel("Phone no:");
	JTextField t3=new JTextField(20);
	JLabel l4=new JLabel("Address:");
	JTextField t4=new JTextField(20);
	JLabel l5=new JLabel("User-Id:");
	JTextField t5=new JTextField(20);
	JLabel l6=new JLabel("Password:");
	JTextField t6=new JTextField(20);
	JLabel l7=new JLabel("Renter Password:");
	JTextField t7=new JTextField(20);
	JButton b1=new JButton("SUBMIT");
	
	CreateAccount()
	{	
		k.add(l8);
		k.add(l1);
		k.add(t1);
		k.add(l2);
		k.add(t2);
		k.add(l3);
		k.add(t3);
		k.add(l4);
		k.add(t4);
		k.add(l5);
		k.add(t5);
		k.add(l6);
		k.add(t6);
		k.add(l7);
		k.add(t7);
		k.add(b1);
		l8.setBounds(10,3,200,15);
		l1.setBounds(10,27,70,10);
		l2.setBounds(10,50,80,20);
		l3.setBounds(10,75,90,30);
		l4.setBounds(10,110,100,40);
		l5.setBounds(10,155,110,50);
		l6.setBounds(10,180,120,60);
		l7.setBounds(10,205,130,70);

		t1.setBounds(130,22,200,20);
		t2.setBounds(130,50,200,20);
		t3.setBounds(130,80,200,20);
		t4.setBounds(130,110,200,50);
		t5.setBounds(130,170,200,20);
		t6.setBounds(130,200,200,20);
		t7.setBounds(130,230,200,20);
		b1.setBounds(160,265,80,30);
		b1.addActionListener(this);
		k.setBackground(Color.BLUE);
		k.setLayout(null);
		k.setLocation(500,300);
		k.setSize(400,400);
		k.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		String name=t1.getText();
		String email=t2.getText();
		String phone=t3.getText();
		String add=t4.getText();
		String uid=t5.getText();
		String password=t6.getText();
		String repassword=t7.getText();
		if(password.equals(repassword))
		{
			String sql="insert into adminlogin values('"+name+"','"+email+"','"+phone+"','"+add+"','"+uid+"','"+password+"')";
			try
			{
				Statement st=JDBCClass.con();
				st.executeUpdate(sql);
				JOptionPane.showMessageDialog(k,"account is created");
				k.setVisible(false);
				new AdminLogin();
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(k,""+ex);
			}
			
		}
	}
public void windowClosing(WindowEvent e)
	{
		
		System.exit(0);
	}	
}	

