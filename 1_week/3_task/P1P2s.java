/* P1P2s.java */
public class P1P2s {
    public static void main(String[] args) {
    Semaphore sem = new Semaphore();
        
        Consumer p1 = new Consumer(sem);
        Producer p2 = new Producer(sem);

        p1.start();
        p2.start();
    }
}
