package ejercicioPlatos;

import java.util.concurrent.TimeUnit;

public class Fregador implements Runnable {
    PilaDePlatos platosSucios;
    PilaDePlatos platosFregados;

    public Fregador(PilaDePlatos platosSucios, PilaDePlatos platosFregados) {
        this.platosSucios = platosSucios;
        this.platosFregados = platosFregados;
    }

    @Override
    public void run() {
        Plato plato;
        for (int i = 0; i < 50; i++) {
            plato = platosSucios.removePlato();
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            plato.setEstado(Estado.FREGADO);
            platosFregados.addPlato(plato);
        }
    }
}
