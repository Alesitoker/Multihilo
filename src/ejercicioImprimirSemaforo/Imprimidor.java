package ejercicioImprimirSemaforo;


public class Imprimidor implements Runnable {
    ColaImpresion colaImpresion;

    public Imprimidor(ColaImpresion colaImpresion) {
        this.colaImpresion = colaImpresion;
    }

    @Override
    public void run() {
        colaImpresion.imprimir();
    }
}
