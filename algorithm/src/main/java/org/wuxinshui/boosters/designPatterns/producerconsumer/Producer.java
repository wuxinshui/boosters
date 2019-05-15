package org.wuxinshui.boosters.designPatterns.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Producer implements Runnable {
    private BlockingQueue<PcData> queue;

    @Override
    public void run() {
        PcData pc=new PcData(1);
        queue.add(pc);
    }

    public Producer(BlockingQueue<PcData> queue) {
        this.queue = queue;
    }
}
