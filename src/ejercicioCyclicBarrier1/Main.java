package ejercicioCyclicBarrier1;

import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        final int NUM_AMIGOS = 5;
        CyclicBarrier barrier = new CyclicBarrier(NUM_AMIGOS);
        Thread amigos[] = new Thread[NUM_AMIGOS];

        for (int i = 0; i < NUM_AMIGOS; i++) {
            amigos[i] = new Thread(new Amigo(barrier), "Amigo"+i);
            amigos[i].start();
        }

        for (int i = 0; i < NUM_AMIGOS; i++) {
            try {
                amigos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Nos vamos");
    }
}
