package ejercicioPlatos;

import java.util.concurrent.TimeUnit;

public class Secador implements Runnable {
    PilaDePlatos platosFregados;
    PilaDePlatos platosSecos;

    public Secador(PilaDePlatos platosFregados, PilaDePlatos platosSecos) {
        this.platosFregados = platosFregados;
        this.platosSecos = platosSecos;
    }

    @Override
    public void run() {
        Plato plato;
        for (int i = 0; i < 50; i++) {
            plato = platosFregados.removePlato();
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            plato.setEstado(Estado.SECO);
            platosSecos.addPlato(plato);
        }
    }
}
