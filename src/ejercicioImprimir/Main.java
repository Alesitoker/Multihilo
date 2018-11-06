package ejercicioImprimir;

public class Main {
    public static void main(String[] args) {
        final int NUM_IMPRESION = 10;
        int i;
        Impresora impresora = new Impresora();
        Thread hilos[] = new Thread[NUM_IMPRESION];

        for (i = 0; i < NUM_IMPRESION; i++) {
            hilos[i] = new Thread(new Imprimidor(impresora), "Documento"+i);
        }

        for (i = 0; i< NUM_IMPRESION; i++) {
            hilos[i].start();
        }
    }
}
