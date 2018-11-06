package ejercicioPlatos;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        PilaDePlatos pilaPlatosSucios, pilaPlatosFregados = new PilaDePlatos(), pilaPlatosSecos = new PilaDePlatos(), alacena = new PilaDePlatos();
        Thread fregador;
        Thread secador = new Thread(new Secador(pilaPlatosFregados, pilaPlatosSecos), "Secador");
        Thread colocador = new Thread(new Colocador(pilaPlatosSecos, alacena), "Colocador");
        LinkedList<Plato> platos = new LinkedList<>();

        for (int i = 0; i < 50; i++) {
            platos.addLast(new Plato(i, Estado.SUCIO));
        }

        pilaPlatosSucios = new PilaDePlatos(platos);
        fregador = new Thread(new Fregador(pilaPlatosSucios, pilaPlatosFregados), "Fregador");

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
