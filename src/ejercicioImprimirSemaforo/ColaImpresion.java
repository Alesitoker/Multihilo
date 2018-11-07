package ejercicioImprimirSemaforo;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ColaImpresion {
    private final int NUM_IMPRESORAS = 3;
    private Semaphore semaforo = new Semaphore(NUM_IMPRESORAS);
    private boolean disponible[] = new boolean[NUM_IMPRESORAS];
//    int impresora;
    Random rnd = new Random();
    private ReentrantLock cerrojo = new ReentrantLock();

    public ColaImpresion() {
        for (int i = 0; i < NUM_IMPRESORAS; i++) {
            disponible[i] = true;
        }
    }

    public void imprimir() {
        try {
            semaforo.acquire();
            int impresora = getImpresora();
            System.out.printf("Imprimiendo el %s en la impresora %s\n", Thread.currentThread().getName(), impresora);
            TimeUnit.SECONDS.sleep(rnd.nextInt(10)+1);
            System.out.printf("El %s ha terminado de imprimirse en la impresora %s\n", Thread.currentThread().getName(), impresora);
            disponible[impresora] = true;
        } catch (InterruptedException e) {

        } finally {
            semaforo.release();
        }
    }

    private int getImpresora() {
        int impresora = -1;
        boolean encontrarDisponible = false;
        cerrojo.lock();
        for (int i = 0; i < disponible.length && !encontrarDisponible; i++) {
            if (disponible[i]) {
                impresora = i;
                disponible[i] = false;
                encontrarDisponible = true;
            }
        }
        cerrojo.unlock();
        return impresora;
    }
}
