package ejercicioPlatos;

public class Plato {
    private int numero;
    private Estado estado;

    public Plato(int numero, Estado estado) {
        this.numero = numero;
        this.estado = estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public Estado getEstado() {
        return estado;
    }
}
