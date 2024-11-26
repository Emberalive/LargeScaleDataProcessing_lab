/* P1.java */
 
public class Producer extends Thread {
  Semaphore sem;
  int ProducerTrans;
  public Producer(Semaphore t_sem) {
    sem=t_sem;
  }
  public void run() {
    System.out.println(" Producer STARTED");
    while(true) {
      Util.delay();
	sem.P();
      /** CRITICAL SECTION */
      System.out.println("****** Producer IN CRITICAL SECTION ***********");
      ProducerTrans=Data.number;
      System.out.println("Producer: Bank Balance = £"+ ProducerTrans);
      Data.number=ProducerTrans+1;
      System.out.println("P1: Producer added £1 to the balance = £"+ Data.number);
      Util.delay();
      /** END OF CRITICAL SECTION */
      System.out.println("****** Producer LEFT CRITICAL SECTION ***********");    
      	sem.V();    
    }
  }
}


