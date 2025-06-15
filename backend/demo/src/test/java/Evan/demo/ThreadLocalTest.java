package Evan.demo;

import org.junit.jupiter.api.Test;

public class ThreadLocalTest {

    private static final ThreadLocal<String> tl = new ThreadLocal<>();

    @Test
    public void testThreadLocalSetAndGet() {

        new Thread(() -> {
            tl.set("Orange");
            System.out.println(Thread.currentThread().getName() + " set: " + tl.get());


            for (int i = 0; i < 7; i++) {
                System.out.println(Thread.currentThread().getName() + " get: " + tl.get());
            }
        }, "ThreadOne").start();


        new Thread(() -> {
            tl.set("Apple");
            System.out.println(Thread.currentThread().getName() + " set: " + tl.get());

            for (int i = 0; i < 6; i++) {
                System.out.println(Thread.currentThread().getName() + " get: " + tl.get());
            }
        }, "ThreadTwo").start();
    }
}
