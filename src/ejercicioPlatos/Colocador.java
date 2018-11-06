package ejercicioPlatos;

import java.util.concurrent.TimeUnit;

public class Colocador implements Runnable {
    PilaDePlatos pilaPlatosSecos;
    PilaDePlatos alacena;

    public Colocador(PilaDePlatos pilaPlatosSecos, PilaDePlatos alacena) {
        this.pilaPlatosSecos = pilaPlatosSecos;
        this.alacena = alacena;
    }

    @Override
    public void run() {
        Plato plato;
        for (int i = 0; i < 50; i++) {
            plato = pilaPlatosSecos.removePlato(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            plato.setEstado(Estado.GUARGADO);
            alacena.addPlato(plato, Thread.currentThread().getName());
        }
    }
}
