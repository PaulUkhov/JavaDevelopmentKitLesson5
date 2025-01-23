package org.example;
//1. Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
//        2. Вилки лежат на столе между каждой парой ближайших философов.
//3. Каждый философ может либо есть, либо размышлять.
//        4. Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
//        5. Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)

//Описать в виде кода такую ситуацию. Каждый философ должен поесть три раза

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int numberOfPhilosophers = 5;

        // Создаем вилки
        List<Fork> forks = new ArrayList<>();
        for (int i = 0; i < numberOfPhilosophers; i++) {
            forks.add(new Fork());
        }
//|f|f|f|f|f
        // Создаем философов
        List<Philosopher> philosophers = new ArrayList<>();
        for (int i = 0; i < numberOfPhilosophers; i++) {
            Fork leftFork = forks.get(i);
            Fork rightFork = forks.get((i + 1) % numberOfPhilosophers);

            // Последний философ берет вилки в обратном порядке, чтобы избежать дедлока
            if (i == numberOfPhilosophers - 1) {
                philosophers.add(new Philosopher(rightFork, leftFork));
            } else {
                philosophers.add(new Philosopher(leftFork, rightFork));
            }
        }

        // Запускаем философов
        for (Philosopher philosopher : philosophers) {
            philosopher.start();
        }
    }
}
