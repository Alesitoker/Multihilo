package ejercicioPlatos;

import java.util.LinkedList;

public class PilaDePlatos {
    LinkedList<Plato> platos = new LinkedList<>();

    public PilaDePlatos(LinkedList<Plato> platos) {
        this.platos = platos;
    }

    public PilaDePlatos() {
    }

    public synchronized Plato removePlato() {
        Plato plato;
        while (platos.size() == 0) {
            try {
                wait();
                System.out.println("No puedo");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        plato = platos.getLast();
        platos.removeLast();
        System.out.printf("El plato %d esta %s\n", plato.getNumero(), plato.getEstado());
//        notifyAll();
        return plato;
    }

    public synchronized void addPlato(Plato plato) {
        platos.addLast(plato);
        System.out.printf("El plato %d esta %s\n", plato.getNumero(), plato.getEstado());
        notifyAll();
    }



}
