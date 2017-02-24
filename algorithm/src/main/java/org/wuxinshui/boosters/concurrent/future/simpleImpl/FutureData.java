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
//Future数据，构造很快，但是是一个虚拟的数据，需要装配RealData
//FutureData是Future模式的核心，是RealData的真实代理，封装了等待RealData的过程。
public class FutureData implements Data {
	protected RealData realData=null;//FutureData是RealData的包装
	protected boolean isReady=false;

	public synchronized void setRealData(RealData realData){
		if (isReady){
			return;
		}
		this.realData=realData;
		isReady=true;
		notifyAll();//RealData已被注入，通知getResult()
	}


	@Override
	public synchronized String getResult() {
		//等待RealData构造完成
		while (!isReady){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return realData.result;//由RealData实现
	}
}
