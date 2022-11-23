package org.example;

import java.util.Timer;

public class ScheduleTestMain {

    public static void main(String[] args)
    {
        Timer timer = new Timer();
        //wait 2 seconds (2000 mili-secs) and then start
        timer.schedule(new MyTask("Task1"), 2000);

        for(int i = 0; i < 100; i++){
            //wait 1 seconds and then again every 5 seconds.
            timer.schedule(new MyTask("Task " + i), 1000, 5000);
        }
    }
}