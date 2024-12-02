import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;

public class HelloServer implements HelloInterface {
private static final long serialVersionUID = 1L;
public static final String MESSAGE = "Hello World";
public HelloServer( ) { }
public String sayHello() {
return MESSAGE;
}
public static void main(String[] args) {
System.out.println("RMI Hello Server started");
// Create the server object
try {
HelloInterface server = new HelloServer();
HelloInterface stub = (HelloInterface) UnicastRemoteObject.exportObject(server, 0);
System.out.println("Stub created and object exported");
Registry registry = LocateRegistry.createRegistry(1099);
System.out.println("Registry created");
System.setProperty("java.rmi.server.hostname", "<<rmi server ip>>");
// Bind this object to the name
Naming.bind("HelloInterface", stub);
System.out.println("Hello Server is bound and ready to receive requests.");
} catch (final Exception e) {
System.out.println("HelloServer failed: "+e);
}
}
}
