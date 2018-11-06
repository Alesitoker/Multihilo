package ejercicioPlatos;

import java.util.concurrent.TimeUnit;

public class Fregador implements Runnable {
    PilaDePlatos pilaPlatosSucios;
    PilaDePlatos pilaPlatosFregados;

    public Fregador(PilaDePlatos pilaPlatosSucios, PilaDePlatos pilaPlatosFregados) {
        this.pilaPlatosSucios = pilaPlatosSucios;
        this.pilaPlatosFregados = pilaPlatosFregados;
    }

    @Override
    public void run() {
        Plato plato;
        while (pilaPlatosSucios.getSize() > 0) {
            plato = pilaPlatosSucios.removePlato(Thread.currentThread().getName());
            plato.setEstado(Estado.FREGADO);
            pilaPlatosFregados.addPlato(plato, Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
