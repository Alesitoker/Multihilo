package ejercicioExamenDePedro;

public class Alumno implements Runnable {
    String name;
    Clase clase;

    public Alumno(String name, Clase clase) {
        this.name = name;
        this.clase = clase;
    }

    @Override
    public void run() {
        clase.realizarExamen(name);
    }
}
