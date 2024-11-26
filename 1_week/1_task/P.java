/* P1.java */
 
public class P1 extends Thread {
  Semaphore sem;
  int p1Num;
  public P1(Semaphore t_sem) {
    sem=t_sem;
  }
  public void run() {
    System.out.println(" P1 STARTED");
    while(true) {
      Util.delay();
	sem.P();
      /** CRITICAL SECTION */
      System.out.println("****** P1 IN CRITICAL SECTION ***********");
      p1Num=Data.number;
      System.out.println("P1: Read Number = "+ p1Num);
      Data.number=p1Num+10;
      System.out.println("P1: Number increased by 10 = "+ Data.number);
      Util.delay();
      /** END OF CRITICAL SECTION */
	sem.V();
      System.out.println("****** P1 LEFT CRITICAL SECTION ***********");        
    }
  }
}


