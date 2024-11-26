import java.net.*;
import java.io.*;

public class CliSocket{
  public static void main(String[] args) throws Exception{
    Socket CliSocket;
    String host = "localhost";

    CliSocket = new Socket(host,8421);
    System.out.println("You have finally reached your destination = The Server - connection has been made to the server");
    CliSocket.close();
  }
}

