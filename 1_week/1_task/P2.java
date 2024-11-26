/* P2.java */

public class P2 extends Thread {
  Semaphore sem;
  int p2Num;
  public P2(Semaphore t_sem) {
    sem=t_sem;
  }
  public void run() {
  
    System.out.println(" P2 STARTED");
    while(true) {
    Util.delay();
	 sem.P();
    /** CRITICAL SECTION */
      System.out.println("****** P2 IN CRITICAL SECTION ***********");
      p2Num=Data.number;
      System.out.println("P2: Read Number = "+ p2Num);
      Util.delay();
      Data.number=p2Num+1;      
      System.out.println("P2: Number increased by 1 = "+ Data.number);  
    /** END OF CRITICAL SECTION */
   	sem.V();
      System.out.println("****** P2 LEFT CRITICAL SECTION ***********");      
    }
  }
}
