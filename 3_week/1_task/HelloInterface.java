import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloInterface extends Remote {
  public String sayHello()throws java.rmi.RemoteException;
  public String sayHelloTo (String name) throws RemoteException;
} 

