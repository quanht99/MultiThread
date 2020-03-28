package Philosopher;

import Chopsticks.Chopsticks;

public class Philosopher extends Thread {
    public int philNumber;
    public String status;
    public Chopsticks left;
    public Chopsticks right;

    public Philosopher(int num, Chopsticks left, Chopsticks right){
        this.philNumber = num;
        this.left = left;
        this.right = right;
        this.status = "Wait left chopsticks";
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void eating() throws InterruptedException {
        this.setStatus("Eating");
        sleep(2000);
    }

    public void run(){
        while (true){
            try {
                left.takeChopstick();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.setStatus("Taken left chopsticks");
            try {
                right.takeChopstick();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.setStatus("Taken right chopsticks");
            try {
                this.eating();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            left.putChopsticks();
            right.putChopsticks();
            this.setStatus("Thinking");
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
