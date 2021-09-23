import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
import java.io.*; 
import java.net.*;
public class Serverchat{
	public static String serverName="localhost" ;
	public static String message1; 
	public static int port=000;
	public static String s1;
		static JFrame f = new JFrame("Student Details form -newton"); 
		static JLabel l1, l2, l3, l4, l5; 
		static JTextField t1, t2, t3; 
		static JComboBox j1, j2; 
		static JButton b1, b2, b3; 
	public static void Servertalk() 
	{ 
		l1 = new JLabel("Enter message:"); 
		l1.setBounds(50, 50, 100, 30); 
		l2 = new JLabel("ip address:"); 
		l2.setBounds(50, 120, 120, 30); 
		//l3 = new JLabel("Branch:"); 
		//l3.setBounds(50, 190, 50, 30); 
		//l4 = new JLabel("Section:"); 
		//l4.setBounds(420, 50, 70, 30); 
		//l5 = new JLabel("Mobile No:"); 
		//l5.setBounds(420, 120, 70, 30); 
		t1 = new JTextField(); 
		t1.setBounds(150, 50, 130, 30); 
		t2 = new JTextField(); 
		t2.setBounds(160, 120, 130, 30); 
		t3 = new JTextField(); 
		t3.setBounds(490, 120, 130, 30); 
		//String s1[] = { " ", "CSE", "ECE", "EEE","CIVIL", "MEC", "Others" }; 
		//String s2[] = { " ", "B1", "B2", "B3", "B4","B5","B14"}; 
		//j1 = new JComboBox(s1); 
		//j1.setBounds(120, 190, 100, 30); 
		//j2 = new JComboBox(s2); 
		//j2.setBounds(470, 50, 140, 30); 
		b1 = new JButton("send"); 
		b1.setBounds(120, 300, 70, 30); 
		b2 = new JButton("close"); 
		b2.setBounds(420, 300, 70, 30);
		b3 = new JButton("clear");
		b3.setBounds(270, 300, 70, 30 );
		//connecting server to send message
		b1.addActionListener(new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent e) 
			{ 
				s1 = t1.getText(); //message
				String s2 = t2.getText(); //ipaddress
				//String s3 = j1.getSelectedItem() + ""; 
				//String s4 = j2.getSelectedItem() + ""; 
				//String s5 = t3.getText(); 
				if (e.getSource() == b1) 
				{ 
					try 
					{ 
						FileWriter w = new FileWriter( "Messagechat.txt", true); 
						w.write("*started"+"\n");
						w.write("@" + s1 + "\n"); //message
						w.write("#" + s2 + "\n"); //ipaddress of reciever
						//w.write("$" + s3 + "\n"); //branch
						//w.write("%" + s4 + "\n"); //section
						//w.write("^" + s5 + "\n"); //mobile number
						w.write("completed*"+"\n");
						w.close(); 
						t1.setText("");
						t2.setText("");
						Socket client = new Socket(serverName, port);
						t3.setText("connected to"+ client.getRemoteSocketAddress());
			 			//System.out.println("connected to " + client.getRemoteSocketAddress());
						message1 = s1;
 						OutputStream outToServer = client.getOutputStream();
 						DataOutputStream out = new DataOutputStream(outToServer);
 						out.writeUTF(message1 + client.getLocalSocketAddress());
         				client.close();
         				s1="";
					}
					catch (Exception ae) 
					{ 
						System.out.println(ae); 
					} 
					} 
					if(e.getSource()==b3)
					{
						t1.setText("");
						t2.setText("");
						t3.setText("");
						s1="";
					}
					JOptionPane.showMessageDialog(f,"Successfully message send");
				}
			}); 
					b2.addActionListener(new ActionListener() 
					{ 
					public void actionPerformed(ActionEvent e) 
					{ 
						f.dispose(); 
					} 
					}); 

				// Default method for closing the frame 
				f.addWindowListener(new WindowAdapter() { 
				public void windowClosing(WindowEvent e) 
				{ 
					System.exit(0); 
				} 
				}); 
				f.add(l1); 
				f.add(t1); 
				f.add(l2); 
				f.add(t2); 
				//f.add(l3); 
				//f.add(j1); 
				//f.add(l4); 
				//f.add(j2); 
				//.add(l5); 
				f.add(t3); 
				f.add(b1); 
				f.add(b2); 
				f.add(b3);
				f.setLayout(null); 
				f.setSize(700, 600); 
				f.setVisible(true); 
	} 
	public static void main(String args[]) 
	{ 
		Servertalk();
		System.out.println("program exited with 0"); 
	} 
} 