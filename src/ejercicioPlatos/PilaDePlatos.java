package ejercicioPlatos;

import java.util.LinkedList;

public class PilaDePlatos {
    LinkedList<Plato> platos = new LinkedList<>();

    public PilaDePlatos(LinkedList<Plato> platos) {
        this.platos = platos;
    }

    public PilaDePlatos() {
    }

    public synchronized Plato removePlato(String nameThread) {
        Plato plato;
        while (platos.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        plato = platos.getLast();
        platos.removeLast();
        System.out.printf("%s coge el plato %d que esta %s\n", nameThread,plato.getNumero(), plato.getEstado());
        return plato;
    }

    public synchronized void addPlato(Plato plato, String nameThread) {
        platos.addLast(plato);
        System.out.printf("%s guarda el plato %d que esta %s\n", nameThread,plato.getNumero(), plato.getEstado());
        notifyAll();
    }

    public synchronized int getSize() {
        return platos.size();
    }



}
