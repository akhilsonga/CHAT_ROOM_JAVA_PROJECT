// File Name GreetingClient.java
import java.net.*;
import java.io.*;
import java.util.*;
//  java GreetingClient localhost 6066 --output
public class GreetingClient2v2
{
   public static boolean loop = true;
   public static String connect,connectyes = "y";



   public static void main(String [] args) 
   {
      String serverName = "localhost";
      int port = 1234;
     
   do
   { 
      try 
      {
        
         System.out.println("Connecting to " + serverName + " on port " + port);
         Socket client = new Socket(serverName, port);
         
         System.out.println("Just connected to " + client.getRemoteSocketAddress());
         OutputStream outToServer = client.getOutputStream();//(client) i  sends its message to server!
         DataOutputStream out = new DataOutputStream(outToServer);
         System.out.print("enter a message to send to server: ");
         Scanner S = new Scanner(System.in);
         String message = S.nextLine();

         out.writeUTF(message /*+ client.getLocalSocketAddress()*/);//takes input from server!
          out.flush();
         System.out.println("message sent sucessfully! ");
         InputStream inFromServer = client.getInputStream();
         DataInputStream in = new DataInputStream(inFromServer);
         
         System.out.println("Server says " + in.readUTF());
         System.out.println("do you want to stay connected?"+"\n"+"'y' - yes"+"\n"+"'n' - no");
           connect = S.nextLine();
         if(connect.equals(connectyes))
         {
            loop = true;
         }
         /*
          received = dis.readUTF(); 
                  
                System.out.println(received); 

         */
         else
         {
            client.close();
            loop = false;
         }
     

      } 
      catch (IOException e) 
      {
         e.printStackTrace();
      }
      catch(Exception e1)
      {
         System.out.print("exception in program!");
      }

   }while(loop);

}//main
}//class