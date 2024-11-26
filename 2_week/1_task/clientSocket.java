import java.io.*;
import java.net.*;

public class clientSocket {
  public static void main (String[] args) throws Exception{
    Socket cliSocket = null;
    DataInputStream is = null;
    DataOutputStream out = null;
    int socket = 8421;
    
  try {
    //client connection to the server
    cliSocket = new Socket ("10.8.18.92", socket);
    System.out.println("connection with the server has been established.");
    
    //creating input and output streams
    is = new DataInputStream(cliSocket.getInputStream());
    out = new DataOutputStream(cliSocket.getOutputStream());
    
    //reading the message from the server
    out.writeUTF("Hello Server, I am the client"); //this writes a message from to the server
    
    //reading the servers farewell message
    String serverGoodbye = is.readUTF(); // this receives the message from the server
    System.out.println("server says: " + serverGoodbye);
    
    } catch (IOException e){
      System.out.println("An error occurred: " + e.getMessage());
   } finally {
      //Properly closing resources
      if (is != null) is.close();
      if (out != null) out.close();
      if (cliSocket != null) cliSocket.close();
    }
  }
}



