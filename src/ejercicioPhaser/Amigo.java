package ejercicioPhaser;

import java.util.Random;
import java.util.concurrent.*;

public class Amigo implements Runnable {
    Phaser secuenciador;
    Random rnd = new Random();

    public Amigo(Phaser secuenciador) {
        this.secuenciador = secuenciador;
    }

    @Override
    public void run() {
        try {
            secuenciador.arriveAndAwaitAdvance();
            llegarAPuntoDeEncuentro();

            secuenciador.arriveAndAwaitAdvance();
            tomarCubata();

            System.out.printf("%s: Vamos por el segundo\n", Thread.currentThread().getName());
            secuenciador.arriveAndAwaitAdvance();
            tomarCubata();
            Mensajes();

            secuenciador.arriveAndDeregister();
        } catch (InterruptedException e) {
            System.out.printf("%s: me han interrumpido\n", Thread.currentThread().getName());
            return;
        }
    }

    private void Mensajes() {
        if (Thread.currentThread().getName().equals("Amigo0")) {
            System.out.printf("%s: te reViento\n", Thread.currentThread().getName());
        } else if (Thread.currentThread().getName().equals("Amigo1")) {
            System.out.printf("%s: Bailando cumbiote\n", Thread.currentThread().getName());
        } else if (Thread.currentThread().getName().equals("Amigo2")) {
            System.out.printf("%s: Voy a llorar\n", Thread.currentThread().getName());
        } else if (Thread.currentThread().getName().equals("Amigo3")){
            System.out.printf("%s: xq\n", Thread.currentThread().getName());
        } else if (Thread.currentThread().getName().equals("Amigo4")) {
            System.out.printf("%s: Cmamut\n", Thread.currentThread().getName());
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
