package org.wuxinshui.boosters.designPatterns.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
    //    缓冲区
    private static final BlockingQueue<PcData> queue = new LinkedBlockingDeque();

    public static void main(String[] args) {
        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);

        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);
        Consumer consumer3 = new Consumer(queue);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(producer1);
        executorService.submit(producer2);
        executorService.submit(producer3);
        executorService.submit(consumer1);
        executorService.submit(consumer2);
        executorService.submit(consumer3);
    }
}
