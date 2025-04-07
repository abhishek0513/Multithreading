package org.example.ExecuterFramework;

public class Main {
    private int factorial(int n) throws InterruptedException {
        Thread.sleep(1000);
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) throws InterruptedException {
        Main m = new Main();
        Long startTime = System.currentTimeMillis();
        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            Thread thread = new Thread(
                    ()->{
                        int factorial = 0;
                        try {
                            factorial = m.factorial(10);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("Factorial of " + finalI + " is : " + factorial);
                    }
            ) ;
            thread.start();
        }
        System.out.println("Total Time : " + (System.currentTimeMillis() - startTime));
    }
}
