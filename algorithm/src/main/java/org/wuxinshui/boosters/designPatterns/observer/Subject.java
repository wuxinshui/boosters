package org.wuxinshui.boosters.designPatterns.observer;

/**
 * 观察者模式
 */
public interface Subject {
    void notice();

    void register(Observer observer);

    void delete(Observer observer);
}
