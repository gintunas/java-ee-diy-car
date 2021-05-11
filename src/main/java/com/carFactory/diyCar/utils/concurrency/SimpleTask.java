package com.carFactory.diyCar.utils.concurrency;

public class SimpleTask implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Doing work: " + i);
        }
    }
}
