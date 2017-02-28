package org.wuxinshui.boosters.concurrent.future.simpleImpl;

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
 * Created by wuxinshui on 2017/2/24.
 */
//Future的简单实现。
// 系统启动，调用client发出请求
public class Main {
	public static void main(String[] args) {
		Client client = new Client();
		//这里会立即返回，因为得到的是FutureData,而不是RealData
		Data data = client.request("name");
		System.out.println("发送请求完毕。。。");
		try {
			//模拟其他业务逻辑处理
			//处理过程中，RealData被创建，充分利用了等待的时间。
			System.out.println("Main 正在调用其他业务逻辑。。。");
			Thread.sleep(1000);
			System.out.println("Main 其他业务处理完成。。。");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//使用真实的数据
		System.out.println("数据= " + data.getResult());
	}
}
