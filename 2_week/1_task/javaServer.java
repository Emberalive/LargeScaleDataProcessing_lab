import java.io.*;
import java.net.*;
class javaServer {
  public static void main(String args[]) throws java.io.IOException{
    ServerSocket srvSocket = null;
    Socket cliSocket = null;
    DataInputStream is = null;
    DataOutputStream out = null;
    
try{
    //creating  server socket, waiting for a request from a client
    srvSocket = new ServerSocket(8421);
        System.out.printf("Server running..... %nWaiting for the client to connect");

    //accepting client connection
    cliSocket = srvSocket.accept();
    System.out.printf("%nclient has been connected%n");
    
    //creating input and output streams
    is = new DataInputStream(cliSocket.getInputStream());
    out = new DataOutputStream(cliSocket.getOutputStream());
    
    //writing to a client socket
    out.writeUTF("Hello client, connection successful!");
    
    //reading the message sent by the client (if any)
    String clientMessage = is.readUTF();
    System.out.println("received from client: " + clientMessage);
    
    //sending farewell message to the client
    out.writeUTF("Goodbye client, closing the connection.");
    
    
    } catch (IOException e) {
      System.out.println("Error occurred: " + e.getMessage());
   } finally {
    try {
        if (is != null) is.close();
        if (out != null) out.close();
        if (cliSocket != null) cliSocket.close();
        if (srvSocket != null) srvSocket.close();
    } catch (IOException e) {
        System.out.println("Error while closing resources: " + e.getMessage());
    }
}
}
}

      //echo server writes back to client what they typed
      //String s;
      //while ((s = is.readLine())!= null){
        //System.out.println("client: " + s);
        //out.println (s);
    //}
  //}
//}

