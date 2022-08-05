package com.ahmetsenocak;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class producerAndConsumer {
    Random random = new Random();

    BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

    public void producer() {
        while (true) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                Integer value = random.nextInt(100);
                queue.put(value);
                System.out.println("producer is producing: " + value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void consumer() {
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Integer value = queue.take();
                System.out.println("consumer consuming: " + value);
                System.out.println("Size of Queue: " + queue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
