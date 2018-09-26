package ejercicioTablaDeMultiplicar;

public class MainJoin {
    public static void main(String[] args) {
        Thread array[] = new Thread[11];
        for (int i = 0; i <= 10; i++) {
            array[i] = new Thread(new Tabla(i), "Thread-" + i);
        }

        for (Thread o : array) {
            o.start();
        }

        for(Thread o : array) {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Ya hemos terminado.");
    }
}
