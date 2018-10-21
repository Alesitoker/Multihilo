package factorial;

public class Factorial implements Runnable{
    private int numero;
    private long resultado = 1;

    Factorial(int numero){
        this.numero = numero;
    }

    @Override
    public void run() {
        int i = 1;
        while (i <= numero) {
            resultado *= i;
            i++;
        }
    }

    public long getResultado() {
        return resultado;
    }
}
