package org.example;

public class ThreadSync extends Thread{
    private SyncCounter counter;
    public ThreadSync(SyncCounter counter){
        this.counter = counter;
    }
    @Override
    public void run(){
        for(int i = 0; i < 1000; i++){
            counter.increment();
        }
    }
}
