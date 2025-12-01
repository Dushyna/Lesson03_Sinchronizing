package ait.elevator.task;

import ait.elevator.model.Elevator;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Truck implements Runnable{
    private static Lock mutex = new ReentrantLock();
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
            mutex.lock();
            try {
                elevator.add(capacity);

            }finally {
                mutex.unlock();
            }

        }
    }

}
