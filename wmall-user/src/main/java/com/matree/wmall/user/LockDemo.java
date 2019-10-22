package com.matree.wmall.user;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class LockDemo {

    volatile int i = 0;
    // 利用Unsafe 直接操作内存
    static Unsafe unsafe ;
    private static long iOffset;

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);
            // 利用unsafe 通过属性的偏移量（定位到内存地址）
            iOffset = unsafe.objectFieldOffset(LockDemo.class.getDeclaredField("i"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void add() {
        int current;
        int n;
        do {
            current = unsafe.getIntVolatile(this, iOffset);
            n = current + 1;
        } while (!unsafe.compareAndSwapInt(this, iOffset, current, n));
    }

    public static void main(String[] args) throws InterruptedException {
        LockDemo lockDemo = new LockDemo();
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    lockDemo.add();
                }
            }).start();
        }
        Thread.sleep(2000L);
        System.out.println(lockDemo.i);
    }
}
