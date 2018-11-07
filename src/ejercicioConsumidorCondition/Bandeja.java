package ejercicioConsumidorCondition;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Bandeja {
    private LinkedList<String> pasteles = new LinkedList<>();
    private ReentrantLock cerrojo = new ReentrantLock();
    private Condition estaLleno = cerrojo.newCondition();
    private Condition estaVacio = cerrojo.newCondition();

    public void addPastel(String pastel) throws InterruptedException {
        cerrojo.lock();
            while (this.pasteles.size() == 10) {
                estaLleno.await();
            }
            this.pasteles.addLast(pastel);
            System.out.println("Poner "+ pastel);
            estaVacio.signalAll();
        cerrojo.unlock();
    }

    public void mangarPastel() throws InterruptedException {
        cerrojo.lock();
            while (pasteles.size() == 0) {
                estaVacio.await();
            }
            System.out.println("Coger "+ pasteles.pollFirst());
            estaLleno.signalAll();
        cerrojo.unlock();
    }
}
