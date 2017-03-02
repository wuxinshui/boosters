package org.wuxinshui.boosters.concurrent.masterWorker;

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

import java.util.Map;
import java.util.Queue;

/**
 * Created by wuxinshui on 2017/3/1.
 */
public class Worker implements Runnable{
	//子任务队列，用于取得任务
	protected Queue<Object> workQueue;

	//子任务结果集
	protected Map<String,Object> resultMap;

	public void setWorkQueue(Queue<Object> workQueue) {
		this.workQueue = workQueue;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	//子任务的处理逻辑，在子类中实现具体逻辑
	public Object handle(Object input){
		return input;
	}

	@Override
	public void run() {
		while (true){
			Object input=workQueue.poll();
			if (input==null) break;;
			Object re=handle(input);

			resultMap.put(Integer.toString(input.hashCode()),re);
		}
	}
}
