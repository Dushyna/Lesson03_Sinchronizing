package ait.elevator.task;

import ait.elevator.model.Elevator;

public class Truck implements Runnable{
    private static final Object monitor = new Object();
    private  int nRace;
    private int capacity;
    private Elevator elevator;

    public Truck(int nRace, int capacity, Elevator elevator) {
        this.nRace = nRace;
        this.capacity = capacity;
        this.elevator = elevator;
    }

    @Override
    public void run() {
        for (int i = 0; i <nRace ; i++) {
            synchronized (monitor) {
                elevator.add(capacity);
            }
        }
    }

}
