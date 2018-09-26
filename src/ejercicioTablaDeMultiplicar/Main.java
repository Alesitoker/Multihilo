package ejercicioTablaDeMultiplicar;

public class Main {
    public static void main(String[] args) {

        for (int i = 0; i <= 10; i++) {
            new Thread(new Tabla(i), "Thread-" + i).start();
        }
    }
}
