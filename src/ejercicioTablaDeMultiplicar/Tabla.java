package ejercicioTablaDeMultiplicar;

public class Tabla implements Runnable {
    int numero;

    Tabla(int numero) {
        this.numero = numero;
    }

    @Override
    public void run() {
        for(int i = 0; i <= 10; i++) {
            System.out.printf("%d*%d = %d\n", numero, i, numero*i);
        }
    }
}
