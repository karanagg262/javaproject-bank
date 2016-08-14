import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class UserLogin extends WindowAdapter implements ActionListener
{
	JFrame k=new JFrame("UserLogin");
	JLabel l1=new JLabel("Account Number : ");
	JTextField t1=new JTextField(20);
	JButton b1=new JButton("CONTINUE");
	
		UserLogin()
		{
			k.add(l1);
			k.add(t1);
			k.add(b1);
			b1.addActionListener(this);
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
					String account = t1.getText();
					k.setVisible(false);
					String s = "SELECT * from userlogin WHERE account='"+account+"'";
					Statement st=JDBCClass.con();
					try {
						ResultSet rs=st.executeQuery(s);
						Object rowData[][] = new Object[10][6];
						int i =0;
						if(rs.next())
						{
							rowData[i][0]=rs.getString(1);
							rowData[i][1]=rs.getString(2);
							rowData[i][2]=rs.getString(3);
							rowData[i][3]=rs.getString(4);
							rowData[i][4]=rs.getString(5);
							rowData[i][5]=rs.getString(6);
							i++;			;
						}
						JFrame frame = new JFrame();
					    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

					    Object columnNames[] = { "Name", "E-Mail", "Phone","Address","Account","balance" };
					    JTable table = new JTable(rowData, columnNames);
					    JScrollPane scrollPane = new JScrollPane(table);
					    frame.add(scrollPane, BorderLayout.CENTER);
					    frame.setSize(300, 150);
					    frame.setVisible(true);
							} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
		}
	} 