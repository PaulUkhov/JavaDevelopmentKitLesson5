package org.example;

public class PhilosopherThread extends Thread {
    Philosopher philosopher;

    public PhilosopherThread(Philosopher philosopher) {
        this.philosopher = philosopher;
    }

    public void philosophicalStream() {
        Thread threadPhil = new Thread(() -> {

            for (int i = 0; i < 5; i++) {
                try {
                    philosopher.pickUpForks();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Филосов поел");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "PhilosopherThread");

        threadPhil.start();

        try {
            threadPhil.join();

        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}




