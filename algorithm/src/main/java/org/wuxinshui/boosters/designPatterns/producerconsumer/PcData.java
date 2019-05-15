package org.wuxinshui.boosters.designPatterns.producerconsumer;

/**
 * 缓冲区中的任务或者数据结构
 */
public class PcData {
    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public PcData(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "i=:" + i;
    }
}
