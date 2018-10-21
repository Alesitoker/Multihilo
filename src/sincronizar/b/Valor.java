package sincronizar.b;

public class Valor {
    private int numero = 0;

    public synchronized void incrementar() {
        numero++;
    }

    public int getNumero() {
        return numero;
    }
}
