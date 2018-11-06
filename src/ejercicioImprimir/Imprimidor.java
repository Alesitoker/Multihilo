package ejercicioImprimir;

import java.util.Random;

public class Imprimidor implements Runnable {
    Impresora impresora;

    public Imprimidor(Impresora impresora) {
        this.impresora = impresora;
    }

    @Override
    public void run() {
        Random rnd = new Random();

        impresora.imprimir(rnd.nextInt(10)+1, Thread.currentThread().getName());
    }
}
