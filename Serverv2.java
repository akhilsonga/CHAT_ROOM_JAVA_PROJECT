//Serverv2.java
import java.io.*; 
import java.text.*; 
import java.util.*; 
import java.net.*; 
// Server class 
public class Serverv2
{ 
	public static void main(String[] args) throws IOException 
	{ 
		// server is listening on port 5056 
		ServerSocket ss = new ServerSocket(1234); 
		int count = 0;
		int rnt=0; 
		String c="obj",r,x,y;
		count++;
		rnt++;
		String c1=String.valueOf(count);
		String r1=String.valueOf(rnt);
		x = c + c1;
		y = r + r1;
		System.out.println("Server Started :" ); 
		while (true) 
		{ 
			Socket s = null; 
			try
			{ 
				s = ss.accept(); 
				System.out.println("A new client is connected : " + s); 
				System.out.println("client: "+count); 
				// obtaining input and out streams 
				DataInputStream dis = new DataInputStream(s.getInputStream()); 
				DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
				InputStream inputStream = s.getInputStream();
				// create a DataInputStream so we can read data from it.
				//DataInputStream dis = new DataInputStream(inputStream);
				String message = dis.readUTF();
				System.out.println("Id: " +message); 
				String port = String.valueOf(s.getPort());
				System.out.println(port);
							FileWriter w = new FileWriter( "ServerLogs.txt", true); 
							w.write("*started "+port);
							w.write("\n");
							w.close();
							System.out.println("file");
				//s.getRemoteSocketAddress()
				System.out.println("Assigning new thread for this client");
				Object obj1=x; 
				ClientHandler obj1 + count  = new ClientHandler(s, dis, dos); 
				obj1.newton();
				count++;
				rnt++;
				 //c1=String.valueOf(count);
				 //r1=String.valueOf(rnt);
				//x = c + c1;
				//y = r + r1;
				}
				catch(Exception e)
				{
					System.out.println("exception main");
				}
		}
	}
}		


class ClientHandler 
{
	public DataInputStream dis1; 
	public DataOutputStream dos1; 
	public Socket s1; 
	public static String modify,port;
	

	// Constructor 
	public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) 
	{ 
		s1 = s; 
		dis1 = dis; 
		dos1= dos; 
	} 
	public void newton()
	{
		String received,check1,check2; 
		String toreturn; 
		boolean loop = false;
		int count=0,rnt=0,q=0;
		String c,r,x,y;
		try
		{ 
		do
		{
		InputStream inputStream = s1.getInputStream();
		// create a DataInputStream so we can read data from it.
		DataInputStream dis1 = new DataInputStream(inputStream);
		String message = dis1.readUTF();
		/* ncount++;
		rnt++;
		String c1=String.valueOf(count);
		String r1=String.valueOf(rnt);
		x = c + c1;
		y = r + r1;
		// read the message from the socket*/
		System.out.println("client:"+message);
		FileWriter w = new FileWriter( "ABChatD.txt", true); 
		w.write("*"+message);
		w.write("\n");
		 port = String.valueOf(s1.getPort());
		System.out.println(port);
		//Check12();
		//Sends();
		//InputStream y = s1.getInputStream();
		//DataInputStream x = new DataInputStream(inputStream);
		 //check1 = x.readUTF();
		/*Scanner sc1 = new Scanner(System.in);
			String qwer1 = sc1.nextLine();
			if(qwer1.equals("exit"))
			{
				System.exit(0);
			}
			*/
		 check2 = ".exit";
		if(message.equals(check2))
		{
			loop = false;
			System.out.println("chat terminated");	
			 port = String.valueOf(s1.getPort());
			System.out.println(port);	
			w.close(); 
			dis1.close(); 
			dos1.close();
		}
		else
		{
			loop = true;
			System.out.println("looping");
			 port = String.valueOf(s1.getPort());
			System.out.println(port); 	
		}

		}while(loop);
	}
	catch(IOException e)
			{ 
			//e.printStackTrace(); 
			//w.close(); 
			//dis1.close(); 
			//dos1.close();
			System.out.println(port+" disconnected from server!");
			Scanner sc = new Scanner(System.in);
			String qwer = sc.nextLine();
			if(qwer.equals("exit"))
			{
				System.exit(0);
			}
		} 
	}
}

















