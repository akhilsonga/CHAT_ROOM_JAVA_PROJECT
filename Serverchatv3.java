//Serverchatv2.java
import java.net.*;
import java.util.*;
import java.io.*;

public class Serverchatv3 extends Thread 
{

	
   private ServerSocket ss;
   public static String connect;
   public static String connectyes = "y";
   public static boolean loop = true;
   public static String messages;
   
   public Serverchatv3(int port) throws IOException 
   {
      ss = new ServerSocket(port);
      ss.setSoTimeout(10000);
   }
   public void run() 
   {
               try {
               System.out.println("Waiting for client on port(server) " + ss.getLocalPort() + "...");
               Socket socket = ss.accept();
               System.out.println("Just connected to (server)" + socket.getRemoteSocketAddress());
               InputStream inputStream = socket.getInputStream();
               DataInputStream dataInputStream = new DataInputStream(inputStream);
               String message = dataInputStream.readUTF();
               System.out.println(dataInputStream.readUTF());
               DataOutputStream out = new DataOutputStream(socket.getOutputStream());
               Scanner s = new Scanner(System.in);
               System.out.println("enter message to send (server to client): ");
                messages = s.nextLine();
               out.writeUTF(message);
               System.out.println("do you want to stay connected?"+"\n"+"'y' - yes"+"\n"+"'n' - no");
               connect=s.nextLine();
               if(connect.equals(connectyes))
               {
                  loop = true;
               }
               else
               {
                  socket.close();
                  loop =false;
               }
            }
            catch (SocketTimeoutException s) 
            {
            System.out.println("Socket timed out!");
            } 
            catch (IOException e) 
            {
               e.printStackTrace();
            }
            catch(Exception eqw)
                  {
                     System.out.println("Exception");
                  }
   }
   public static void main(String [] args) {
      int port = 1234;
      try 
      {
         Thread t = new Serverchatv2(port);
         t.start();
      } catch (IOException e) 
      {
         e.printStackTrace();
      }
   }
}