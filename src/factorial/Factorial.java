package factorial;

public class Factorial implements Runnable{
    int numero;
    long resultado;

    Factorial(int numero){
        this.numero = numero;
    }

    @Override
    public void run() {
        long factorial = 1;
        int i = 1;
        while (i <= numero) {
            factorial *= i;
            i++;
        }
        resultado = factorial;
    }

}
