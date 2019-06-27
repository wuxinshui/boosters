package org.wuxinshui.boosters.designPatterns.producerconsumer;

import java.text.MessageFormat;
import java.util.concurrent.BlockingQueue;

/**
 * 消费者
 */
public class Consumer implements Runnable {
    private BlockingQueue<PcData> queue;

    @Override
    public void run() {
        PcData pc = null;
        try {
            pc = queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (null != pc) {
            System.out.println("consumer take success...." + pc);
            MessageFormat.format("()*()=()", pc.getI(), pc.getI(), pc.getI() * pc.getI());
        }
    }

    public Consumer(BlockingQueue<PcData> queue) {
        this.queue = queue;
    }
}
