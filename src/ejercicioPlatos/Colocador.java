package ejercicioPlatos;

import java.util.concurrent.TimeUnit;

public class Colocador implements Runnable {
    PilaDePlatos platosSecos;
    PilaDePlatos alacena;

    public Colocador(PilaDePlatos platosSecos, PilaDePlatos alacena) {
        this.platosSecos = platosSecos;
        this.alacena = alacena;
    }

    @Override
    public void run() {
        Plato plato;
        for (int i = 0; i < 50; i++) {
            plato = platosSecos.removePlato();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            plato.setEstado(Estado.GUARGADO);
            alacena.addPlato(plato);
        }
    }
}
