package org.wuxinshui.boosters.designPatterns.singleton;

/**
 * Copyright [2017$] [Wuxinshui]
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wuxinshui on 2017/2/7.
 */
//安全的懒汉模式-使用内部类实现单例 ，实现延迟加载
public class StaticSingleton {
    //添加计数器
    public static final AtomicInteger counter = new AtomicInteger();
    private static StaticSingleton test = new StaticSingleton();

    private StaticSingleton() {
        counter.incrementAndGet();
        System.out.println("The " + (counter.get()) + " StaticSingleton instance is created");
    }

    //JVM加载 StaticSingleton时不会初始化内部类SingletonHolder
    //当方法getInstance()被调用时，才会加载getInstance()
    private static class SingletonHolder {
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        System.out.println("获取静态实例。。。");
        return SingletonHolder.instance;
    }

    public static void main(String[] args) {
        StaticSingleton instance = StaticSingleton.getInstance();
        System.out.println(instance);
    }
}
