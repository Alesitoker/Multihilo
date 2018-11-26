package countDownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {
        int i;
        final int numMinParticipantes = 10;
        final int numParticipantes = 15;
        Conferencia conferencia = new Conferencia(numMinParticipantes, numParticipantes);
        Thread hiloConferencia = new Thread(conferencia);
        Thread paises[] = new Thread[numParticipantes];
        Random rnd = new Random();

        hiloConferencia.start();
        for (i = 0; i < paises.length; i++) {
            paises[i] = new Thread(new Pais(conferencia, "Pais"+i, rnd.nextInt(4)+1));
            paises[i].start();
        }
    }
}
