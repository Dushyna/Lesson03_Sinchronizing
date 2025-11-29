package ait.elevator.task;

import ait.elevator.model.Elevator;

public class Truck implements Runnable {
    private static final Object monitor1 = new Object();
    private static final Object monitor2 = new Object();
    private int nRace;
    private int capacity;
    private Elevator elevator1;
    private Elevator elevator2;

    public Truck(int nRace, int capacity, Elevator elevator1, Elevator elevator2) {
        this.nRace = nRace;
        this.capacity = capacity;
        this.elevator1 = elevator1;
        this.elevator2 = elevator2;
    }

    @Override
    public void run() {
        for (int i = 0; i < nRace; i++) {
            synchronized (monitor1) {
                elevator1.add(capacity / 2);
            }
            synchronized (monitor2) {
                elevator2.add(capacity / 2);
            }

        }
    }

}
