import java.io.*;
import java.net.*;

public class echoServer {
	public static void main (String [] args)throws Exception{
		System.out.println("echo server is now online");
		Socket = cliSocket = null;
		ServerSocket = echoSocket = null;
		DataInputStream = null;
		DataOutputStream = null;
		int port = 8421;
		
		echoSocket = new ServerSocket(port);
		
		while (true){
			cliSocket = echoSocket.accept();
			is = new DataInoputStream(cliSocket.ghetInpoutStream);
			out = new DataOutputStream(cliSocket.getOutputStream);
		}
		
		System.out.println("connection with echo server has established");
		out.writeUTF("Hello cliuent the connection with the echo server has been established");
		out.flush();
		
		String s;
		while ((s = is.readUTF()) != null) {
			if (s.equals("end")) {
			System.out.println("From client: " + s);
				break;
				
			}
			System.out.println("From client: " + s);
			out.writeUTF(s);
			out.flush();
			
		}
		System.out.println("closing connection");
			out.writeUTF("Bye for now....");
			out.flush();
		out.close();
		is.close();
		cliSocket.close();
		}
	}
