package ejercicioImprimirSemaforo;

public class Main {
    public static void main(String[] args) {
        final int NUM_IMPRESION = 10;
        int i;
        ColaImpresion colaImpresion = new ColaImpresion();
        Thread hilos[] = new Thread[NUM_IMPRESION];

        for (i = 0; i < NUM_IMPRESION; i++) {
            hilos[i] = new Thread(new Imprimidor(colaImpresion), "Documento"+i);
        }

        for (i = 0; i< NUM_IMPRESION; i++) {
            hilos[i].start();
        }
    }
}
