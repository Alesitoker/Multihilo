package countDownLatch;

import java.util.concurrent.CountDownLatch;

public class Conferencia implements Runnable {
    CountDownLatch countParticipantes;
    CountDownLatch countSugerencias;

    public Conferencia(int numMinParticipantes, int numParticipantes) {
        this.countParticipantes = new CountDownLatch(numMinParticipantes);
        this.countSugerencias = new CountDownLatch(numParticipantes);
    }

    public void entrarConferencia(int numParticipantes, String pais) {
        for (int i = 0; i < numParticipantes; i++) {
            countParticipantes.countDown();
        }
        System.out.printf("%s ha entrado con %d asesores\n", pais, numParticipantes);
        try {
            countParticipantes.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void sugerencias() {
        countSugerencias.countDown();
    }

    @Override
    public void run() {
        try {
            countParticipantes.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Comienza la conferencia\n");
        try {
            countSugerencias.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Termina la conferencia\n");
    }

}
