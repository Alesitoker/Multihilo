package ejercicioCine;

public class Taquilla3 implements Runnable {
    Cine cine;

    public Taquilla3(Cine cine) {
        this.cine = cine;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            if (i == 4) {
                cine.comprarEntrada(6, 1);
                cine.comprarEntrada(3, 2);
            } else {
                cine.comprarEntrada(4, 7);
                cine.devolverEntrada(2, 2);
            }
        }
    }
}
