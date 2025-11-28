package ait.timer;

import ait.timer.task.Timer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TimerAppl {
    public static void main(String[] args) throws IOException {
        Timer timer = new Timer();
        Thread thread = new Thread(timer);
        //thread.setDaemon(true);
        thread.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Enter clock period in seconds, or type 'q' to quit");
            String str = br.readLine();
            if ("q".equalsIgnoreCase(str)) {
                thread.interrupt();
                System.out.println("in main thread: " + thread.isInterrupted());
                break;
            } else {
                timer.setClockPeriod((Integer.parseInt(str)));
            }
        }
        System.out.println("main thread finished");
    }
}
