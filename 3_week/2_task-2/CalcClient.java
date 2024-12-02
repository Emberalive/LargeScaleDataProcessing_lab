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
      
      // creating the scanner for the input
      Scanner scanner = new Scanner(System.in);

      System.out.println("This is an simple calculator server ...");    
      String mathType = "";
      
        //variables for the calculation functions
       long val1 = 0;
       long val2 = 0;
       long val3 = 0;
       boolean isFirstIteration = true;
//loop to allow for a repeat
  while (true){

      if (isFirstIteration){
        System.out.printf("%nPlease enter the type of function you want to do %nFunctions: addition, multiplication, subtraction, division%nTo quit please type 'end'%n");
      isFirstIteration = false;
      } else {
          System.out.printf("%nPlease select another function: or type 'end' to quit%n");
        }
        
        mathType = scanner.nextLine();
        
        if (mathType.equalsIgnoreCase("end")){
            System.out.println("The client will now close per your request");
            break;
        }
        
      switch(mathType.toLowerCase()){
        case "addition":
                    System.out.println("Enter the first value");
                    val1 = scanner.nextLong();
                    scanner.nextLine();    //clears the buffer
                    System.out.println("First Number: " + val1);
                    
                    System.out.println("Enter the second value");
                    val2 = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Second Number: " + val2);
                    
                    val3 = stub.add(val1, val2);
                    System.out.println("Server says " + val1 + " + " + val2 + " is: " + val3);
                    break;
         case "subtraction":
                    System.out.println("Enter the first value");
                    val1 = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("First Number: " + val1);
                    
                    System.out.println("Enter the second value");
                    val2 = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Second Number: " + val2);
                    
                    val3 = stub.sub(val1, val2);
                    System.out.println("Server says " + val1 + " - " + val2 + " is: " + val3);
                    break;
         case "division":
                    System.out.println("Enter the first value");
                    val1 = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("First Number: " + val1);
                    
                    System.out.println("Enter the second value");
                    val2 = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Second Number: " + val2);
                    
                    val3 = stub.div(val1, val2);
                    System.out.println("Server says " + val1 + " divided by " + val2 + " is: " + val3);
                    break;
        case "multiplication":
                    System.out.println("Enter the first value");
                    val1 = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("First Number: " + val1);
                    
                    System.out.println("Enter the second value");
                    val2 = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Second Number: " + val2);
                    
                    val3 = stub.mul(val1, val2);
                    System.out.println("Server says " + val1 + " x " + val2 + " is: " + val3);
                    break;
        default:
                System.out.println("This is not a given function");
                break;
      }
  }
    } catch (Exception e) {
      System.out.println("Exception in main: " + e);
    } 
  }
}
