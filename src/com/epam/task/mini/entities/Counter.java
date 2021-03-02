package com.epam.task.mini.entities;

public class Counter {

    private Integer counter = 0;

    public Integer getCounter() {
        return counter;
    }

    public synchronized void increaseCounter() {
        counter++;
    }
}
