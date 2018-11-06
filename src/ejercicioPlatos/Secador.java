package ejercicioPlatos;

import java.util.concurrent.TimeUnit;

public class Secador implements Runnable {
    PilaDePlatos pilaPlatosFregados;
    PilaDePlatos pilaPlatosSecos;

    public Secador(PilaDePlatos pilaPlatosFregados, PilaDePlatos pilaPlatosSecos) {
        this.pilaPlatosFregados = pilaPlatosFregados;
        this.pilaPlatosSecos = pilaPlatosSecos;
    }

    @Override
    public void run() {
        Plato plato;
        for (int i = 0; i < 50; i++) {
            plato = pilaPlatosFregados.removePlato(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(14);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            plato.setEstado(Estado.SECO);
            pilaPlatosSecos.addPlato(plato, Thread.currentThread().getName());
        }
    }
}
