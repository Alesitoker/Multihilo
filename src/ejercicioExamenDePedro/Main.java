package ejercicioExamenDePedro;

public class Main {
    public static void main(String[] args) {
        int i;
        Clase clase = new Clase();
        Thread Alumnos[] = new Thread[12];

        for (i = 0; i < Alumnos.length; i++) {
            Alumnos[i] = new Thread(new Alumno("Alumno "+i, clase));
        }

        for (i = 0; i < Alumnos.length; i++) {
            Alumnos[i].start();
        }

    }
}
