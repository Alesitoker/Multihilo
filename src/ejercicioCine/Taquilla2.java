package ejercicioCine;

public class Taquilla2 implements Runnable {
    Cine cine;

    public Taquilla2(Cine cine) {
        this.cine = cine;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            if (i == 2) {
                cine.comprarEntrada(5, 14);
            } else {
                cine.comprarEntrada(2, 7);
                cine.devolverEntrada(5, 2);
            }
        }
    }
}
