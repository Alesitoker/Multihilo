package sumatorio;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CalcularSumatorio implements Callable<Integer> {
    int numero;

    public CalcularSumatorio(int numero) {
        this.numero = numero;
    }

    @Override
    public Integer call() throws Exception {
        int resultado = 0;
        for (int i = 1; i <= numero; i++) {
            resultado += i;
            TimeUnit.MILLISECONDS.sleep(15);
        }
        return resultado;
    }
}
