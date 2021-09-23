import java.net.*;
import java.util.*;
import java.io.*;

//$ java GreetingServer 6066    --output
public class GreetingServer2 extends Thread 
{
   private ServerSocket serverSocket;
   public static String connect;
   public static String connectyes = "y";
   public static boolean loop = true;
   
   public GreetingServer2(int port) throws IOException 
   {
      serverSocket = new ServerSocket(port);
      serverSocket.setSoTimeout(10000);
   }

   public void run() 
   {
      do
       {
         try {
               System.out.println("Waiting for client on port(server) " + serverSocket.getLocalPort() + "...");
               Socket server = serverSocket.accept();//accepts the client!
            
               System.out.println("Just connected to (server)" + server.getRemoteSocketAddress());
               DataInputStream in = new DataInputStream(server.getInputStream());//takes input from  client!
            
               System.out.println(in.readUTF());//display the input taken from client!
               DataOutputStream out = new DataOutputStream(server.getOutputStream());
               Scanner s = new Scanner(System.in);
               System.out.println("enter message to send (server to client): ");
               String message = s.nextLine();
               out.writeUTF(message);
               System.out.println("do you want to stay connected?"+"\n"+"'y' - yes"+"\n"+"'n' - no");
             //  Scanner s = new Scanner(System.in);
               connect=s.nextLine();
               if(connect.equals(connectyes))
               {
                  loop = true;
               }
               else
               {
                  server.close();
                  loop =false;
               }
            }
            
            catch (SocketTimeoutException s) 
            {
            System.out.println("Socket timed out!");
            break;
            } 
            catch (IOException e) 
            {
               e.printStackTrace();
               break;
            }
      } while(loop);

   }
   
   public static void main(String [] args) {
      int port = 1234;
      try 
      {
         Thread t = new GreetingServer2(port);
         t.start();
      } catch (IOException e) 
      {
         e.printStackTrace();
      }
   }
}