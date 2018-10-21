package sincronizar.a;

public class Incrementador implements Runnable{
    private Valor valor;

    public Incrementador(Valor valor) {
        this.valor = valor;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            valor.incrementar();
        }
    }
}
