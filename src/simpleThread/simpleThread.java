package simpleThread;

import Chopsticks.Chopsticks;
import Philosopher.Philosopher;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class simpleThread{
    static Chopsticks chopsticks[] = new Chopsticks[5];
    static Philosopher philosophers[] = new Philosopher[5];
    public static void printStatus(){
        for(int i=0; i<5; i++){
            System.out.println("Philosopher " + i + ": " + philosophers[i].status);
        }
    }
    public static void main(String args[]) throws InterruptedException {
        for(int i=0; i<5; i++){
            chopsticks[i] = new Chopsticks();
        }
        for(int i=0; i<5; i++){
            philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[(i+1)%5]);
            philosophers[i].start();
        }
        while (true){
            printStatus();
            System.out.println("\n");
            sleep(1000);
        }
    }
}
