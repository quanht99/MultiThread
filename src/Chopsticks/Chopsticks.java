package Chopsticks;

import java.util.concurrent.Semaphore;

public class Chopsticks {
    public Semaphore mutex = new Semaphore(1);

    public void takeChopstick() throws InterruptedException {
        while(!isfree()){

        }
        mutex.acquire();
    }

    public void putChopsticks(){
        mutex.release();
    }

    boolean isfree(){
        return this.mutex.availablePermits() > 0;
    }
}
