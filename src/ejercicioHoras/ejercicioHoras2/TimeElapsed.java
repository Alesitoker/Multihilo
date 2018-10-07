package ejercicioHoras.ejercicioHoras2;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class TimeElapsed implements Runnable {
    @Override
    public void run() {
        LocalTime hour = LocalTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");

        while (!Thread.currentThread().isInterrupted()){
            System.out.println(hour.format(formato));
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("Amarillo");
                return;
            }
            hour = hour.plusSeconds(2);
        }
    }
}
