package ait.elevator.task;

import ait.elevator.model.Elevator;

import java.util.concurrent.atomic.AtomicInteger;

public class ElevatorAppl {


    private static final int N_TRUCK=10000;
    private static final int N_RACES= 10;
    private static final int CAPACITY= 20;


    public static void main(String[] args) throws InterruptedException {
        Elevator elevator = new Elevator("V.I. Lenin");
        Truck[] trucks=new Truck[N_TRUCK];
        for (int i = 0; i < trucks.length; i++) {
            trucks[i]= new Truck(N_RACES,CAPACITY, elevator);

        }
        Thread[] threads = new Thread[trucks.length];
        for (int i = 0; i < threads.length; i++) {
            threads[i]= new Thread(trucks[i]);
            threads[i].start();

        }
        for(Thread thread :  threads){
            thread.join();
        }
        System.out.println("CurrentVolume  " + elevator.getCurrentVolume());

    }
}
