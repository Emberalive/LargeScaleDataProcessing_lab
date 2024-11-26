/* P2.java */

public class Consumer extends Thread {
  Semaphore sem;
  int ConsumerTrans;
  public Consumer(Semaphore t_sem) {
    sem=t_sem;
  }
  public void run() {
  
    System.out.println(" Consumer STARTED");
    System.out.println("Balance is £" + Data.number);
   
    	while(true) {
    		Util.delay();
    		 if (Data.number >6){
			 sem.P();
	    		/** CRITICAL SECTION */
	      		System.out.println("****** Consumer IN CRITICAL SECTION ***********");
	      		ConsumerTrans=Data.number;
	      		System.out.println("Consumer: Bank Balance = £"+ ConsumerTrans);
	      		Util.delay();
	      		Data.number=ConsumerTrans-5;      
	      		System.out.println("Consumer: Balanced reduced by £5 = £"+ Data.number);  
	    		/** END OF CRITICAL SECTION */
	      		System.out.println("****** Consumer LEFT CRITICAL SECTION ***********"); 
      				sem.V();
	      		}else{
	      		Util.delay();
	    			System.out.println("Consumer did not have enough funds to complete Transaction");
	    		}
    		    
    		}
  
  }
}
