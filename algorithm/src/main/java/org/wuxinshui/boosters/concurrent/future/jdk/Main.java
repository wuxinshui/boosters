package org.wuxinshui.boosters.concurrent.future.jdk;

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

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by wuxinshui on 2017/2/27.
 */
public class Main {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		//构造FutureTask
		FutureTask<String> future=new FutureTask<String>(new RealData("name"));
		ExecutorService executor= Executors.newFixedThreadPool(1);
		//执行FutureTask,相当于client.request()发送请求
		//开启线程进行RealData的call()执行
		executor.submit(future);
		System.out.println("发送请求完毕");

		try {
			System.out.println("Main 正在调用其他业务逻辑。。。");
			Thread.sleep(2000);
			System.out.println("Main 其他业务处理完成。。。");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//使用真实的数据
		//相当于data.getResult()，取得call()方法的返回值
		//如果call()方法没有执行完成，则依然会等待
		System.out.println("数据= " + future.get());
	}
}
