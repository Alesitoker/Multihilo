package ejercicioCine;

public class Main {
    public static void main(String[] args) {
        Cine cine = new Cine(20);
        Thread t1 = new Thread(new Taquilla1(cine));
        Thread t2 = new Thread(new Taquilla2(cine));
        Thread t3 = new Thread(new Taquilla3(cine));

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(cine.toString());
    }
}
