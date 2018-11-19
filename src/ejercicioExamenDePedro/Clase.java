package ejercicioExamenDePedro;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Clase {
    private final int MAX_PC = 5;
    private Semaphore pedro = new Semaphore(MAX_PC);
    private boolean disponible[] = new boolean[MAX_PC];
    private ReentrantLock cerrojo = new ReentrantLock();
    private Random rnd = new Random();

    public Clase() {
        for (int i = 0; i < disponible.length; i++) {
            disponible[i] = true;
        }
    }

    public void realizarExamen(String name) {
        int pc;
        try {
            pedro.acquire();

            pc = getPC();
            System.out.printf("%s comienza el examen en el ordenador %d\n", name, pc);
            TimeUnit.SECONDS.sleep(rnd.nextInt(5)+1);
            System.out.printf("%s termina de hacer el examen en el ordenador %d\n", name, pc);
            disponible[pc] = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            pedro.release();
        }
    }

    private int getPC() {
        int pc = -1;
        cerrojo.lock();
        for (int i = 0; i < disponible.length; i++) {
            if (disponible[i]) {
                pc = i;
                disponible[i] = false;
                break;
            }
        }
        cerrojo.unlock();
        return pc;
    }
}
