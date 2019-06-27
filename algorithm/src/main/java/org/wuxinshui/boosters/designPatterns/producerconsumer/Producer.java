package org.wuxinshui.boosters.designPatterns.producerconsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * 生产者
 */
public class Producer implements Runnable {
    private BlockingQueue<PcData> queue;

    @Override
    public void run() {
        Random random = new Random();

        PcData pc = new PcData(random.nextInt());
        if (queue.add(pc)) {
            System.out.println("producer add .success..." + pc);
        }
    }

    public Producer(BlockingQueue<PcData> queue) {
        this.queue = queue;
    }
}
