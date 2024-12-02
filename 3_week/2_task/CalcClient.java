import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class CalcClient {

  public static void main (String args[]) {
    String host = "localhost";
    //String host = "10.8.63.184";
    //System.setSecurityManager(new RMISecurityManager());

    try {
      Registry registry = LocateRegistry.getRegistry(host);
      CalcInterface stub = (CalcInterface) registry.lookup("CalcInterface");
      
      long add = stub.add(12, 15);
      System.out.println("Server says 12 + 15 is: " + add);
      
      long sub = stub.sub(100, 20);
      System.out.println("Server says 20 - 100 is: " + sub);
      
      long mul = stub.mul(5, 5);
      System.out.println("Server says 5 x 5 is: " + mul);
      
      long div = stub.div(25, 5);
      System.out.println("Server says 25 divided by 5 is: " + div);
      
    } catch (Exception e) {
      System.out.println("Exception in main: " + e);
    } 
  }
}
