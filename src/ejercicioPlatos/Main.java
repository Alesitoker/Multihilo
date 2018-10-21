package ejercicioPlatos;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        PilaDePlatos platosSucios, platosFregados = new PilaDePlatos(), platosSecos = new PilaDePlatos(), alacena = new PilaDePlatos();
        Thread fregador;
        Thread secador = new Thread(new Secador(platosFregados, platosSecos));
        Thread colocador = new Thread(new Colocador(platosSecos, alacena));
        LinkedList<Plato> platos = new LinkedList<Plato>();

        for (int i = 0; i < 50; i++) {
            platos.addLast(new Plato(i, Estado.SUCIO));
        }

        platosSucios = new PilaDePlatos(platos);
        fregador = new Thread(new Fregador(platosSucios, platosFregados));

        fregador.start();
        secador.start();
        colocador.start();

        try {
            fregador.join();
            secador.join();
            colocador.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
