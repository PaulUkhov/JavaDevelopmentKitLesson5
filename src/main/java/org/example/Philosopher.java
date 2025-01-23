package org.example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Philosopher extends Thread {
    private final Fork leftFork;
    private final Fork rightFork;

    public Philosopher(Fork leftFork, Fork rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        try {
            while (true) {
                think(); // Философ думает
                pickUpForks(); // Берет вилки
                eat(); // Ест
                putDownForks(); // Кладет вилки
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void think() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " размышляет.");
        Thread.sleep((long) (Math.random() * 2000)); // Симуляция размышлений
    }

  void pickUpForks() throws InterruptedException {
        leftFork.pickUp();
        System.out.println(Thread.currentThread().getName() + " взял левую вилку.");
        rightFork.pickUp();
        System.out.println(Thread.currentThread().getName() + " взял правую вилку.");
    }

    private void eat() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " ест.");
        Thread.sleep((long) (Math.random() * 1000)); // Симуляция еды
    }

    private void putDownForks() {
        leftFork.putDown();
        System.out.println(Thread.currentThread().getName() + " положил левую вилку.");
        rightFork.putDown();
        System.out.println(Thread.currentThread().getName() + " положил правую вилку.");
    }
}


