package ejercicioCine;

public class Taquilla1 implements Runnable {
    Cine cine;

    public Taquilla1(Cine cine) {
        this.cine = cine;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            if (i == 4) {
                cine.devolverEntrada(4, 3);
            } else {
                cine.comprarEntrada(1, 7);
            }
        }
    }
}
