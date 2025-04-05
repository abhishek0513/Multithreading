package org.example;

import javax.sound.sampled.Port;
import java.awt.*;

class sharedResource{
    private int data;
    private Boolean hasData = false;
    public synchronized void produce(int value){
        while (hasData){
            try{
                wait();
            }
            catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        hasData = true;
        System.out.println("Produced : " + value);
        notify();
    }
    public synchronized int consume(){
        while(!hasData){
            try{
                wait();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        hasData = false;
        notify();
        System.out.println("Consumed : " + data);
        return data;
    }
}


class Producer implements Runnable{
    private final sharedResource resource;
    public Producer(sharedResource Resource){
        this.resource = Resource;
    }

    @Override
    public void run(){
        for(int i = 0; i< 10; i++){
            resource.produce(i);
        }
    }
}
class Consumer implements Runnable{
    private final sharedResource resource;
    public Consumer(sharedResource Resource){
        this.resource = Resource;
    }

    @Override
    public void run(){
        for(int i = 0; i< 10; i++){
            int value = resource.consume();
        }
    }
}


public class ThreadCommunication {
    public static void main(String[] args) {
        sharedResource resource = new sharedResource();
        Thread producerThread = new Thread(new Producer(resource));
        Thread consumerThread = new Thread(new Consumer(resource));

        producerThread.start();
        consumerThread.start();
    }
}
