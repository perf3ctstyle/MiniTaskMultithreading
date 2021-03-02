package com.epam.task.mini.printers;

import com.epam.task.mini.entities.Counter;

public class CounterPrinter {

    private final Counter counter;

    public CounterPrinter(Counter counter) {
        this.counter = counter;
    }

    public void print() {
        int counterValue = counter.getCounter();
        System.out.println(counterValue);
    }
}
