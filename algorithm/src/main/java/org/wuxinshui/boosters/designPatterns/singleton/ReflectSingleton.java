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

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by wuxinshui on 2017/2/14.
 */
//利用反射破坏单例模式
public class ReflectSingleton {
	public static void main(String[] args) throws Exception {
		StaticSingleton singleton = StaticSingleton.getInstance();

		Constructor constructor=singleton.getClass().getDeclaredConstructor();

		//值为 true 则指示反射的对象在使用时应该取消 Java 语言访问检查。
		// 值为 false 则指示反射的对象应该实施 Java 语言访问检查。
		constructor.setAccessible(true);

		StaticSingleton singleton2= (StaticSingleton) constructor.newInstance();
		StaticSingleton singleton3= (StaticSingleton) constructor.newInstance();

		System.out.println("singleton2==singleton3 ："+(singleton2==singleton3));
	}
}
