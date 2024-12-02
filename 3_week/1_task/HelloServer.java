import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.*;

public class HelloServer implements HelloInterface {
  private static final long serialVersionUID =1L;
  public static final String MESSAGE = "Hello World";

  public HelloServer(){}

  @Override
  public String sayHello(){
    return MESSAGE;
  }

  @Override
  public String sayHelloTo(String name) { // new method implimentation
    return "The server says hello to " + name;
  }

  public static void main (String [] args){
    System.out.println("RMI Hello server started");
    //create server UnicastRemoteObject
    try{
      HelloInterface server = new HelloServer();
      HelloInterface stub = (HelloInterface) UnicastRemoteObject.exportObject(server, 0);
      System.out.println("stub created and object exported");

     Registry registry = LocateRegistry.createRegistry(1099);
     System.out.println("Registry created");

     //Bind this object to name
     Naming.bind("HelloInterface", stub);
     System.out.println("Hello Server is bound and ready to recieve requests");
    } catch (final Exception e) {
      System.out.println("HelloServer failed: " + e);
    }
  }
}
