import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.*;
public class ClientB{
public static boolean loop = false;
public static int Id1 = 0002;
public static void main(String[] args) throws IOException 
{
	try{
Socket socket = new Socket("localhost", 1234);
System.out.println("Connected!");
// get the output stream from the socket.
OutputStream outputStream = socket.getOutputStream();
String Id = Integer.toString(Id1);
//InputStream inputStream = socket.getInputStream();
//DataInputStream dis = new DataInputStream(inputStream); 
// create a data output stream from the output stream so we can send data through it
DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
dataOutputStream.writeUTF(Id);
dataOutputStream.flush();

Scanner s = new Scanner(System.in);
do{
System.out.println("message:");
String A = s.nextLine();
//System.out.println("Sending string to the ServerSocket");
// write the message we want to send
        dataOutputStream.writeUTF("B*A "+A);
        dataOutputStream.flush(); // send the message

if(A.equals(".exit"))

{
	System.out.println("Chat terminated!");
	dataOutputStream.writeUTF("terminate");
	dataOutputStream.flush();
	System.exit(0);
}
		System.out.println("y - chat"+"\n"+"n - exit:");
        String A1 = "y";
        String B = s.nextLine();
        if(A1.equals(B))
        {
        	loop = true;
        	dataOutputStream.writeUTF("chat");
       		dataOutputStream.flush();

        }
        else
        {
        	loop = false;
        	socket.close();
        }

}while(loop);
        dataOutputStream.close(); // close the output stream when we're done.
		System.out.println("Closing socket and terminating program.");
        socket.close();
         }
    catch(Exception qwe)
    {
    	System.out.println("Server Disconnected! :(");
    }
    }
}