import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Withdraw extends WindowAdapter implements ActionListener{
	JFrame k=new JFrame("Withdraw");
	JLabel l1=new JLabel("Account Number : ");
	JLabel l2=new JLabel("Amount : ");
	JLabel l3=new JLabel("wrong account number ");
	JTextField t1=new JTextField(20);
	JTextField t2=new JTextField(20);
	JButton b=new JButton("withdraw");
	public Withdraw() {
		// TODO Auto-generated constructor stub
		k.add(l1);
		k.add(t1);
		k.add(l2);
		k.add(t2);
		k.add(b);
		b.addActionListener(this);
		k.addWindowListener(this);
		k.setVisible(true);
		k.setLayout(new FlowLayout());
		k.setLocation(300,100);
		k.setBackground(Color.WHITE);
		k.setSize(300,300);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b)
		{
			String account =  t1.getText();
			String deposit =  t2.getText();
			int a = Integer.parseInt(deposit);
			String s = "SELECT balance from userlogin WHERE account='"+account+"'";
			Statement st=JDBCClass.con();
			try {
				ResultSet rs=st.executeQuery(s);
				if(rs.next())
				{
					int p = rs.getInt(1);
					p=p-a;
					String s1 = "UPDATE userlogin SET balance = "+p+" WHERE account = '"+account+"'";
					try
					{
						st.executeUpdate(s1);
						JOptionPane.showMessageDialog(k,"Amount Withdrawl");
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(k,""+ex);
					}
				}
				else {
					k.add(l3);
				}
					
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}

