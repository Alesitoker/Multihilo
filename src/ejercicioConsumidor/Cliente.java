package ejercicioConsumidor;

import java.util.concurrent.TimeUnit;

public class Cliente implements Runnable{
    Bandeja bandeja;

    public Cliente(Bandeja bandeja) {
        this.bandeja = bandeja;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                bandeja.mangarPastel();
            } catch (InterruptedException e) {
                return;
            }
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
