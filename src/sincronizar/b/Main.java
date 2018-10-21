package sincronizar.b;

public class Main {
    public static void main(String[] args) {
        Valor valor = new Valor();
        Thread t1 = new Thread(new Incrementador(valor));
        Thread t2 = new Thread(new Incrementador(valor));
        Thread t3 = new Thread(new Incrementador(valor));

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(valor.getNumero());
    }
}
