package ejercicioHoras.ejercicioHoras2;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
       Thread t = new Thread(new TimeElapsed());
       t.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
        System.out.println("Fin");
    }
}
