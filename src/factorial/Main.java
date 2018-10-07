package factorial;

public class Main {
    public static void main(String[] args) {
        Factorial f1 = new Factorial(20);
        Factorial f2 = new Factorial(15);
        Factorial f3 = new Factorial(10);
        Thread t1 = new Thread(f1);
        Thread t2 = new Thread(f2);
        Thread t3 = new Thread(f3);

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


    }
}
