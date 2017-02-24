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
//返回Data对象，立即返回FutureData,并开启ClientThread线程装配RealData
public class Client {
	public Data request(final String requestStr){
		final FutureData future=new FutureData();
		//RealData构建过程很慢，所以在单独的线程中进行
		new Thread(){
			@Override
			public void run() {
				RealData realData=new RealData(requestStr);
				future.setRealData(realData);
			}
		}.start();
		return future;//future会被立即返回
	}
}
