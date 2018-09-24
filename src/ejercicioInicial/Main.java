package ejercicioInicial;

public class Main {
    public static void main(String[] args) {
        Saludo s = new Saludo();
        s.start();
        System.out.printf("%s: Adios", Thread.currentThread().getName());
    }
}
