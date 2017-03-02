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

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by wuxinshui on 2017/3/1.
 */
//Master-Worker模式是一种使用多线程进行数据处理的结构。
//多个Worker进程协作处理用户请求，Master进程负责维护Worker进程，并整合最终处理结果
public class Master{
	//任务队列
	protected Queue<Object> taskQueue=new ConcurrentLinkedQueue<>();
	//子任务结果集
	protected Map<String ,Object>  resultMap=new HashMap<>();
	//worker进程队列
	protected Map<String ,Thread> threadMap=new HashMap<>();

	//判断所有的子任务是否都结束
	public boolean isComeplete(){
		for (Map.Entry<String,Thread> entry:threadMap.entrySet()){
			if (entry.getValue().getState()!= Thread.State.TERMINATED){
				return false;
			}
		}
		return true;
	}

	public Master(Worker worker,int countWorker){
		worker.setWorkQueue(taskQueue);
		worker.setResultMap(resultMap);
		for (int i=0;i<countWorker;i++){
			threadMap.put(Integer.toString(i),new Thread(worker,Integer.toString(i)));
		}
	}

	//提交一个子任务
	public void submit(Object o){
		taskQueue.add(o);
	}

	//返回子任务结果集
	public Map<String ,Object> getResultMap(){
		return resultMap;
	}

	//开始运行所有的worker进程
	public void execute(){
		for (Map.Entry<String,Thread> entry:threadMap.entrySet()){
			entry.getValue().start();
		}
	}
}
