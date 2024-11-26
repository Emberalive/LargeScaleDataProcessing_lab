import java.net.*;
import java.io.*;

public class ServerSocket{
  //ServerSocket srvSocket;
  //Socket cliSocket;
  //DataInputStream is = null;
  //DataOutputStream os = null;
  //int port = 8421;
  public static void mainng(String[] args) 
      throws java.io.IOException{
    //ServerSocket srvSocket;
    InputStreamReader isr = null;
    DataOutputStream od = null;
    System.out.println("Server is running....");

    ServerSocket srvSocket= new ServerSocket(8421);
    Socket CliSocket = srvSocket.accept();

    out = new DataOutputStream(cliSocket.getOutputStream());
    out.writeUTF("Hi Client, connection with the Server has been made");
    srvSocket.close();
    cliSocket.close();
  }
}
