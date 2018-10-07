package factorial;

public class Factorial implements Runnable{
    int numero;
    Long resultado;

    Factorial(int numero){
        this.numero = numero;
    }

    @Override
    public void run() {
        long suma = 0;
        for (int i = 0; i < numero; i++) {
            suma += i;
        }
    }
}
