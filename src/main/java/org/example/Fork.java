package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Fork {
    private final Lock lock = new ReentrantLock();

    public void pickUp() throws InterruptedException {
        lock.lock(); // Захватываем вилку
    }

    public void putDown() {
        lock.unlock(); // Освобождаем вилку
    }
}
