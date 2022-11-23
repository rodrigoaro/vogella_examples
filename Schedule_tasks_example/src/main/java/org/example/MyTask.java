package org.example;

import java.util.TimerTask;

public class MyTask extends TimerTask {
    private final String string;
    private int count = 0;

    public MyTask(String string) {
        this.string = string;
    }

    @Override
    public void run() {
        count++;
        System.out.println(string + " called " + count);
    }
}
