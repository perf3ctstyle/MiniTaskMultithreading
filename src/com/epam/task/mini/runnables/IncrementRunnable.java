package com.epam.task.mini.runnables;

import com.epam.task.mini.entities.Counter;

import java.util.stream.IntStream;

public class IncrementRunnable implements Runnable {

    private final Counter counter;
    private final static int NUMBER_OF_INCREMENTS = 10;

    public IncrementRunnable(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        IntStream.range(0, NUMBER_OF_INCREMENTS).forEach(number -> {
            counter.increaseCounter();
        });
    }
}
