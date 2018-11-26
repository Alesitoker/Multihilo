package sumatorio;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {
        final int NUM_CALCULOS = 10;
        int numeros[] = new int[NUM_CALCULOS];
        int i;
        Integer resultado = null;
        ThreadPoolExecutor ejecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()+1);
        Future<Integer> futuros;
        ArrayList<Future<Integer>> listaFuturos = new ArrayList<>();
        Random rnd = new Random();

        for (i = 0; i < NUM_CALCULOS; i++) {
            numeros[i] = rnd.nextInt(21);
            futuros = ejecutor.submit(new CalcularSumatorio(numeros[i]));
            listaFuturos.add(futuros);
        }

        for (i = 0; i < listaFuturos.size(); i++) {
            try {
                resultado = listaFuturos.get(i).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            System.out.printf("Tarea %d - sumatorio de %d = %d\n", i, numeros[i], resultado);
        }
        ejecutor.shutdown();
    }
}
