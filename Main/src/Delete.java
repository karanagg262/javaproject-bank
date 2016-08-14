import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Delete extends WindowAdapter implements ActionListener{
	JFrame k=new JFrame("Delete");
	JLabel l=new JLabel("Account Number : ");
	JTextField t=new JTextField(20);
	JButton b=new JButton("Delete");
	public Delete() {
		// TODO Auto-generated constructor stub
		k.add(l);
		k.add(t);
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
		if(e.getSource()==b){
			String account = t.getText();
			String s = "DELETE FROM userlogin WHERE account='"+account+"'";
			Statement st=JDBCClass.con();
			try
			{
				st.executeUpdate(s);
				JOptionPane.showMessageDialog(k,"Account Deleted");
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(k,""+ex);
			}
		}
		}
}
