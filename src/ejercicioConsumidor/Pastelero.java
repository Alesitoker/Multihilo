package ejercicioConsumidor;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class Pastelero implements Runnable{
    Bandeja bandeja;

    public Pastelero(Bandeja bandeja) {
        this.bandeja = bandeja;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                bandeja.addPastel("Pastelito"+i);
            } catch (InterruptedException e) {
                return;
            }
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
