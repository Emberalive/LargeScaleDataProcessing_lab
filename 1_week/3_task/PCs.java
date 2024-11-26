/* P1P2s.java */
public class PCs  {
    public static void main(String[] args) {
    Semaphore sem = new Semaphore();
        
        Producer Producer = new Producer(sem);
        Consumer Consumer = new Consumer(sem);

        Producer.start();
        Consumer.start();
    }
}
