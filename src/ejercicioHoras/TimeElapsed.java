package ejercicioHoras;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class TimeElapsed implements Runnable {
    @Override
    public void run() {
        LocalTime hour = LocalTime.now();
        int second = hour.plusSeconds(20).getSecond();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        System.out.println(hour.format(formato));
        do {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
            hour = hour.plusSeconds(2);
            System.out.println(hour.format(formato));
        } while(hour.getSecond() != second);
    }
}
