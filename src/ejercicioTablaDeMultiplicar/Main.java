package ejercicioTablaDeMultiplicar;

public class Main {
    public static void main(String[] args) {
        Tabla tabla;
        Thread t;
        int i;

        for (i = 0; i <= 10; i++) {
            tabla = new Tabla(i);
            t = new Thread(tabla);
            t.start();
        }
    }
}
