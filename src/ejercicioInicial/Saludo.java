package ejercicioInicial;

public class Saludo extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s: Hola", getName());
        }
    }
}
