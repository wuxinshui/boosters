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

/**
 * Created by wuxinshui on 2017/2/7.
 */
//线程安全的懒汉模式-实现延迟加载
public class SyncLazySingleton {
	private SyncLazySingleton() {
		System.out.println("SyncLazySingleton is create");
	}

	//instance初始值赋予null，确保系统启动时没有额外的负载
	private static SyncLazySingleton instance = null;

	//使用同步关键字，防止多个实例被创建（多线程环境），synchronized保证线程安全
	public static synchronized SyncLazySingleton getInstance() {
		if (instance == null) {
			instance = new SyncLazySingleton();
		}
		return instance;
	}

	//synchronized保证线程安全，降低了系统性能
	public static void main(String[] args) {
		new Thread(){
			public void run(){
				long bg = System.currentTimeMillis();
				for (int i = 0; i < 1000000; i++) {
//					HungrySingleton.getInstance();
					 SyncLazySingleton.getInstance();
				}
				System.out.println("spend:" + (System.currentTimeMillis() - bg)+"ms");
			}
		}.start();
	}
}
