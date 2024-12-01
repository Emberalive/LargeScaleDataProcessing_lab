import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) throws Exception {
        System.out.println("Echo server is now online");
        int port = 8421;

        try (ServerSocket echoSocket = new ServerSocket(port)) {
            // Accept the client socket connection
            while (true) {
                Socket cliSocket = echoSocket.accept();
                System.out.println("Connection with Client has been established");
		
                // Handle the client in a new thread
                new Thread(new ClientHandler(cliSocket)).start();
            }
        } catch (IOException e) {
            System.out.println("Error in Server: " + e.getMessage());
        }
    }
}

// A separate class to handle each client
class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (DataInputStream is = new DataInputStream(clientSocket.getInputStream());
             DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream())) {

            // Greet the client
            out.writeUTF("Hello client, the connection with the echo server has been established");
            out.flush();

            String message;
            while (true) {
                message = is.readUTF();
                System.out.printf("%nFrom client: " + message);
                
            		if (message.equalsIgnoreCase("end")) {
                    out.writeUTF("Goodbye! closing the connection.");
                    out.flush();
                    break;
                }

                out.writeUTF(message); // Echo the message back to the client
                out.flush();
            }

            System.out.println("Closing connection to the client");
            out.writeUTF("Bye for now....");
            out.flush();

        } catch (IOException e) {
            System.out.println("Error closing client socket: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.out.println("Error closing client socket: " + e.getMessage());
            }
        }
    }
}
