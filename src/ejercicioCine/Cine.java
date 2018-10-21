package ejercicioCine;

import java.util.Arrays;

public class Cine {
    private int salas[] = new int[6];
    private int sizeSala;
    private Object vigilantes[] = new Object[6];

    public Cine(int sizeSala) {
        this.sizeSala = sizeSala;
        iniciarVigilantes();
    }

    private void iniciarVigilantes() {
        for (int i = 0; i < vigilantes.length; i++) {
            vigilantes[i] = new Object();
        }
    }

    public void comprarEntrada(int sala, int numEntrada) {
        if (sala >= 0 && sala <= 6) {
            synchronized (vigilantes[sala-1]) {
                if ((salas[sala-1]+numEntrada) <= sizeSala) {
                    salas[sala-1] += numEntrada;
                }
            }
        }
    }

    public void devolverEntrada(int sala, int numEntrada) {
        if (sala >= 0 && sala <= 6) {
            synchronized (vigilantes[sala-1]) {
                if (salas[sala-1] > 0 && salas[sala-1] >= numEntrada) {
                    salas[sala-1] -= numEntrada;
                }
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(salas);
    }
}
