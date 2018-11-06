package ejercicioImprimir;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

public class Impresora {
    ReentrantLock cerrojo = new ReentrantLock();

    public void imprimir(int time, String name) {
        cerrojo.lock();
        System.out.printf("Imprimiendo el %s\n", name);
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.printf("El %s ha tardado %ds\n", name, time);
            cerrojo.unlock();
        }
    }
}
