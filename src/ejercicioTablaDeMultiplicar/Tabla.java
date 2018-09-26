package ejercicioTablaDeMultiplicar;

public class Tabla implements Runnable {
    private int numero;

    Tabla(int numero) {
        this.numero = numero;
    }

    @Override
    public void run() {
        for(int i = 0; i <= 10; i++) {
            System.out.printf("%s: %d*%d = %d\n", Thread.currentThread().getName(), numero, i, numero*i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
