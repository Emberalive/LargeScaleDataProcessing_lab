import java.io.*;
import java.net.*;
import java.util.Scanner;

public class clientSocket {
  public static void main (String[] args) throws Exception{
    Socket cliSocket = null; 
    DataInputStream is = null;
    DataOutputStream out = null; 	
    int socket = 8421;
    Scanner scanner = new Scanner(System.in);
    String Desktop = "192.168.0.125";
    String laptop = "10.8.18.92";
    String port = "localhost";
    
    System.out.println("Made connection to the Server");
    
  try {
    //client connection to the server
    cliSocket = new Socket (port, socket);
    
    //creating input and output streams
    is = new DataInputStream(cliSocket.getInputStream());
    out = new DataOutputStream(cliSocket.getOutputStream());
    
    is.readUTF();
    
    //read the users message and send it to the server
    String uMessage = "";
    
    
    
    while (true) {
    	System.out.printf("%nEnter a message for the server (Type 'end' to exit): ");
    	uMessage = scanner.nextLine();    	
    	
    	// Send users message to the server
   	 	out.writeUTF(uMessage);
    	out.flush();
    	
    	//Exit the loop if the users types end
    	if (uMessage.equalsIgnoreCase("end")) {
    		System.out.println("Closing connection as requested.");
    		break;
    		}
    		
    		//recieveing and display the servers response
    		String serverResponse = is.readUTF();
    		System.out.println("Server Says: " + serverResponse);
   }


    //reading the message from the server
    //out.writeUTF("Hello Server, I am the client"); //this writes a message from to the server
    
    //Reading the serverGoodbye message
		out.writeUTF("end");
		out.flush();
    
    
    
    
    } catch (IOException e){
      System.out.println("An error occurred: " + e.getMessage());
   } finally {
   		try {
		    //Properly closing resources
		    if (cliSocket != null) cliSocket.close();
		    if (is != null) is.close();
		    if (out != null) out.close();
      } catch (IOException e) {
      	System.out.print("Error closing resources: " + e.getMessage());
      }
      scanner.close();
    }
  }
}

