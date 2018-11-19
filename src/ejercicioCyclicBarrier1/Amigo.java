package ejercicioCyclicBarrier1;

import sun.awt.windows.ThemeReader;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Amigo implements Runnable {
    CyclicBarrier barrier;
    Random rnd = new Random();

    public Amigo(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            llegarAPuntoDeEncuentro();
            barrier.await(rnd.nextInt(15)+2, TimeUnit.SECONDS);
            tomarCubata();
            System.out.printf("%s: Vamos por el segundo\n", Thread.currentThread().getName());
            barrier.await();
            tomarCubata();
        } catch (InterruptedException e) {
            System.out.printf("%s: me han interrumpido\n", Thread.currentThread().getName());
            return;
        } catch (BrokenBarrierException e) {
            System.out.printf("%s: Ya no se queda\n", Thread.currentThread().getName());
        } catch (TimeoutException e) {
            System.out.printf("%s: Esta gente no llega, me voy\n", Thread.currentThread().getName());
        }
    }

    private void tomarCubata() throws InterruptedException {
        System.out.printf("Tomando cubata - %s\n", Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(rnd.nextInt(5)+1);
    }

    private void llegarAPuntoDeEncuentro() throws InterruptedException {
        System.out.printf("He salido de casa - %s\n", Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(rnd.nextInt(5)+1);
        System.out.printf("%s ha llegado\n", Thread.currentThread().getName());

    }
}
