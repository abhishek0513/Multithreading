package org.example;

import javax.swing.*;
import java.lang.management.LockInfo;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReenterantLockExample {
    private Lock lock = new ReentrantLock();
    public void outerMethod(){
     lock.lock();
     try{
         System.out.println("Inside outerMethod");
         innerMethod();
     }
     finally {
         lock.unlock();
     }
    }
    public void innerMethod(){
        lock.lock();
        try {
            System.out.println("inside innerMethod");
        }
        finally {
            lock.unlock();
           
        }
    }
    public static void main(String[] args) {
        ReenterantLockExample reenterantLockExample = new ReenterantLockExample();
        reenterantLockExample.outerMethod();
    }
}
