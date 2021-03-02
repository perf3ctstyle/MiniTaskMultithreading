package com.epam.task.mini;

import com.epam.task.mini.entities.Counter;
import com.epam.task.mini.printers.CounterPrinter;
import com.epam.task.mini.runnables.IncrementRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {

    private final static int NUMBER_OF_THREADS = 10;

    public static void main(String[] args) throws InterruptedException {

        /*Counter counter = new Counter();
        List<Thread> threads = new ArrayList<>();

        IntStream.range(0, NUMBER_OF_THREADS).forEach(number -> {
            Thread thread = new Thread(new IncrementRunnable(counter));
            thread.start();
            threads.add(thread);
        });

        for (Thread thread : threads) {
            thread.join();
        }*/

        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        Counter counter = new Counter();
        List<IncrementRunnable> incrementRunnableList = new ArrayList<>();

        IntStream.range(0, NUMBER_OF_THREADS).forEach(number -> {
            IncrementRunnable incrementRunnable = new IncrementRunnable(counter);
            incrementRunnableList.add(incrementRunnable);
        });

        incrementRunnableList.stream().forEach(incrementRunnable -> {
            executorService.execute(incrementRunnable);
        });

        CounterPrinter counterPrinter = new CounterPrinter(counter);
        counterPrinter.print();

        executorService.shutdown();
    }
}
