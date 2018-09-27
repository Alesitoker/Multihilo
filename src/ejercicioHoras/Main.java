package ejercicioHoras;

public class Main {
    public static void main(String[] args) {
       Thread t = new Thread(new TimeElapsed());
       t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Han pasado 20 segundos");
    }
}
