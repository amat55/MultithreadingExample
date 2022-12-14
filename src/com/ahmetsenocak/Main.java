package com.ahmetsenocak;

public class Main {

    public static void main(String[] args) {
        producerAndConsumer pc = new producerAndConsumer();

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                pc.producer();
            }
        });
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                pc.consumer();
            }
        });

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
