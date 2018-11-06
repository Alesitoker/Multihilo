package ejercicioConsumidor;

public class Main {
    public static void main(String[] args) {
        Bandeja bandeja = new Bandeja();
        Thread pastelero = new Thread(new Pastelero(bandeja));
        Thread cliente = new Thread(new Cliente(bandeja));

        pastelero.start();
        cliente.start();

        try {
            pastelero.join();
            cliente.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
