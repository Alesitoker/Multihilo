package countDownLatch;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Pais implements Runnable {
    Conferencia conferencia;
    String nombre;
    int numAsesores;
    private Random rnd = new Random();

    public Pais(Conferencia conferencia, String nombre, int numAsesores) {
        this.conferencia = conferencia;
        this.nombre = nombre;
        this.numAsesores = numAsesores;
    }

    @Override
    public void run() {
        conferencia.entrarConferencia(numAsesores, nombre);
        try {
            TimeUnit.SECONDS.sleep(rnd.nextInt(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s - sugerencia\n", nombre);
        conferencia.sugerencias();
    }
}
