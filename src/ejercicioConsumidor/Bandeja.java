package ejercicioConsumidor;

import java.util.LinkedList;

public class Bandeja {
    private LinkedList<String> pastel = new LinkedList<>();

    public synchronized void addPastel(String pastel) throws InterruptedException {
        while (this.pastel.size() == 10) {
            wait();
        }
        this.pastel.addLast(pastel);
        System.out.println("Poner "+pastel);
        notifyAll();
    }

    public synchronized void mangarPastel() throws InterruptedException {
        String pastelito;
        while (pastel.size() == 0) {
            wait();
        }
        pastelito = pastel.pollFirst();
        System.out.println("Coger "+pastelito);
        notifyAll();
    }

    public synchronized int getSize() {
        return pastel.size();
    }
}
