package ait.timer.task;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Timer implements Runnable{
private int clockPeriod = 3;

    public int getClockPeriod() {
        return clockPeriod;
    }

    public void setClockPeriod(int clockPeriod) {
        this.clockPeriod = clockPeriod;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Timer timer = (Timer) o;
        return clockPeriod == timer.clockPeriod;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(clockPeriod);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")));
            try {
                Thread.sleep(clockPeriod * 1000);
            } catch (InterruptedException e) {
            //    e.printStackTrace();
                System.out.println(Thread.currentThread().isInterrupted());
                System.out.println(Thread.interrupted());
                System.out.println(Thread.currentThread().getName() + " Timer say bye, bye!");
                break;
            }
        }
    }
}
