import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloClient {

  public static void main (String args[]) {
    String host = "localhost";
    //String host = "10.8.63.184";
    //System.setSecurityManager(new RMISecurityManager());

    try {
      Registry registry = LocateRegistry.getRegistry(host);
      HelloInterface stub = (HelloInterface) registry.lookup("HelloInterface");

      String message = stub.sayHello();
      System.out.println("Response from RMI Server: " + message);
        
      String nameMessage = stub.sayHelloTo("Sam");
      System.out.println("Response from RMI Server: " + nameMessage);
      
    } catch (Exception e) {
      System.out.println("Exception in main: " + e);
    } 
  }
}
