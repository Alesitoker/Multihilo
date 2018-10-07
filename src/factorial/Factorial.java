package factorial;

public class Factorial implements Runnable{
    int numero;
    long resultado;

    Factorial(int numero){
        this.numero = numero;
    }

    @Override
    public void run() {
        long suma = 1;
        int i = 1;
        while (i <= numero) {
            suma *= i;
            i++;
        }
        resultado = suma;
    }

}
