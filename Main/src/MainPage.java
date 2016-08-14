import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class MainPage extends WindowAdapter implements ActionListener
{
		JFrame k=new JFrame("MainPage");
		JButton b1=new JButton("Admin");
		JButton b2=new JButton("user");
			MainPage()
			{
				k.add(b1);
				k.add(b2);
				b1.addActionListener(this);
				b2.addActionListener(this);
				
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
						k.setVisible(false);
					   new AdminLogin();
					}
					else if(e.getSource()==b2)
					{	
						k.setVisible(false);
						new UserLogin();
					
					}
			}
		}
