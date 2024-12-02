import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.*;

public class CalcServer implements CalcInterface {
  private static final long serialVersionUID =1L;
  public static final String MESSAGE = "Hello World";

  public CalcServer(){}
  
  //methods for the calculator are implemented
  
  @Override
  public long add(long a, long b){
    long c = 0;
    c = a + b;
    return c;
  }
  @Override
    public long sub(long a, long b){
    long c = 0;
    c = a - b;
    return c;
  }
  @Override
    public long mul(long a, long b){
    long c = 0;
    c = a * b;
    return c;
  }
  @Override
    public long div(long a, long b){
    long c = 0;
    c = a / b;
    return c;
  }


  public static void main (String [] args){
    System.out.println("RMI Hello server started");
    //create server UnicastRemoteObject
    try{
      CalcInterface server = new CalcServer();
      CalcInterface stub = (CalcInterface) UnicastRemoteObject.exportObject(server, 0);
      System.out.println("stub created and object exported");

     Registry registry = LocateRegistry.createRegistry(1099);
     System.out.println("Registry created");

     //Bind this object to name
     Naming.bind("CalcInterface", stub);
     System.out.println("CalcServer is bound and ready to recieve requests");
    } catch (final Exception e) {
      System.out.println("CalcServer failed: " + e);
    }
  }
}
