package ejercicioPhaser;

import java.util.concurrent.Phaser;

public class Main {
    public static void main(String[] args) {
        final int NUM_AMIGOS = 5;
        Phaser secuenciador = new Phaser(NUM_AMIGOS);
        Thread amigos[] = new Thread[NUM_AMIGOS];

        for (int i = 0; i < NUM_AMIGOS; i++) {
            amigos[i] = new Thread(new Amigo(secuenciador), "Amigo"+i);
            amigos[i].start();
        }
    }
}
