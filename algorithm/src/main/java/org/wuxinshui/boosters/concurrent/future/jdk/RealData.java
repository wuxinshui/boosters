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

import java.util.concurrent.Callable;

/**
 * Created by wuxinshui on 2017/2/27.
 */
public class RealData implements Callable<String> {
	private String para;

	public RealData(String para) {
		this.para = para;
	}

	//call中写具体的业务逻辑
	@Override
	public String call() throws Exception {
		//模拟真实业务逻辑，执行很慢
		StringBuffer buffer=new StringBuffer();
		System.out.println("RealData 正在构造真实数据。。。");
		for (int i=0;i<10;i++){
			buffer.append(para);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("RealData 真实数据构造完成。。。");
		return buffer.toString();
	}
}
