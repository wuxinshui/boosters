package org.wuxinshui.boosters.concurrent.mutilThread;

/**
 * <p>MutilThreadEnv</p>
 *
 * @author wuxinshui
 *         <p>
 *         多线程环境并发模拟
 */
public class MutilThreadEnv {


    public static void main(String[] args) {
        MutilThreadEnv mutilThreadEnv = new MutilThreadEnv();
        Task1 task1 = mutilThreadEnv.new Task1();
        Task2 task2 = mutilThreadEnv.new Task2();


        task1.run();
    }


    private class Task1 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 50; i++) {
                System.out.println("Runnable1 : " + i);
            }
        }
    }

    private class Task2 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 50; i++) {
                System.out.println("Runnable2 : " + i);
            }
        }
    }
}
