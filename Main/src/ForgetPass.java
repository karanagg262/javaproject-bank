import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class ForgetPass extends WindowAdapter implements ActionListener{
	
	JFrame k=new JFrame("BHUL GYA");
	JLabel l1=new JLabel("ENTER THE USER ID : ");
	JLabel l2=new JLabel("wrond id");
	JTextField t1=new JTextField(20);
	JButton b=new JButton("Submit");
	public ForgetPass() {
		// TODO Auto-generated constructor stub
		k.add(l1);
		k.add(t1);
		k.add(b);
		b.addActionListener(this);
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b)
		{
			String userid =  t1.getText();
			String s = "SELECT password from adminlogin WHERE userid='"+userid+"'";
			Statement st=JDBCClass.con();
			try {
				ResultSet rs=st.executeQuery(s);
				if(rs.next())
				{
					String s1 = rs.getString(1);
					JOptionPane.showMessageDialog(k,"The password is : "+s1);
					k.setVisible(false);
					new  AdminLogin();
					
				}
				else {
					k.add(l2);
				}
			}catch(SQLException e1){
				e1.printStackTrace();
			}
		}
		
	}

}
