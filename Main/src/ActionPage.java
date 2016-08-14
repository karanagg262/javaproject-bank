import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ActionPage extends WindowAdapter implements ActionListener{
	JFrame k=new JFrame("ActionPage");
	JButton b1=new JButton("Show all account");
	JButton b2=new JButton("Deposit");
	JButton b3=new JButton("Withdraw");
	JButton b4=new JButton("Fund Transfer");
	JButton b5=new JButton("Delete Account");
	JButton b6=new JButton("Create new Account");
	JLabel l = new JLabel("");
	ActionPage(){
		k.add(b1);
		k.add(b2);
		k.add(b3);
		k.add(b4);
		k.add(b5);
		k.add(b6);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
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

		if(e.getSource()==b1)
		{
			String s = "SELECT * from adminlogin";
			Statement st=JDBCClass.con();
			try {
				ResultSet rs=st.executeQuery(s);
				Object rowData[][] = new Object[10][5];
				int i =0;
				while(rs.next())
				{
					rowData[i][0]=rs.getString(1);
					rowData[i][1]=rs.getString(2);
					rowData[i][2]=rs.getString(3);
					rowData[i][3]=rs.getString(4);
					rowData[i][4]=rs.getString(5);
					i++;				
				}
				JFrame frame = new JFrame();
			    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			    Object columnNames[] = { "Name", "E-Mail", "Phone","Address","UserId" };
			    JTable table = new JTable(rowData, columnNames);
			    JScrollPane scrollPane = new JScrollPane(table);
			    frame.add(scrollPane, BorderLayout.CENTER);
			    frame.setSize(300, 150);
			    frame.setVisible(true);
			} 
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==b2)
		{
			k.setVisible(false);
			new Deposit();
		}

		else if(e.getSource()==b3)
		{
			k.setVisible(false);
			new Withdraw();
		}
		else if(e.getSource()==b4)
		{
			k.setVisible(false);
			new FundTransfer();
		}

		else if(e.getSource()==b5)
		{
			k.setVisible(false);
			new Delete();
		}
		else if(e.getSource()==b6)
		{
			k.setVisible(false);
			new CreateAccountU();
		}
		
	}
}
