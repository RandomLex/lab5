package by.gsu.barzykin.lab5;

import java.util.HashMap;
import java.util.Map;

public class Start {

    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger("start", 10);

        Map<Integer, Thread> threadMap = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            threadMap.put(i, new Thread(() -> exchanger.send(exchanger), "thread-" + i));
        }

        for (Thread thread : threadMap.values()) {
            thread.start();
        }

        System.out.println("Thread 'main' has finished.");
    }
}
