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

import org.wuxinshui.boosters.concurrent.masterWorker.apply.CubePlusWorker;

import java.util.Map;
import java.util.Set;

/**
 * Created by wuxinshui on 2017/3/1.
 */
public class Main {
	public static void main(String[] args) {
		bestCode();
	}

	private static void bestCode() {
		long s = System.nanoTime();
		Master master=new Master(new CubePlusWorker(),10);
		for(int i=1;i<=100;i++){
			master.submit(i);
		}
		master.execute();
		Map<String,Object> resultMap=master.getResultMap();
		int result=0;
		while (resultMap.size()>0 || !master.isComeplete()){
			Set<String> keys=resultMap.keySet();
			String key=null;
			for (String k:keys){
				key=k;
				break;
			}
			Integer i=null;
			if (key!=null){
				i= (Integer) resultMap.get(key);
			}
			//最终结果
			if (i!=null){
				result+=i;
			}
			//移除已被计算过的
			if (key!=null){
				resultMap.remove(key);
			}
		}
		System.out.println("The SUM is : " + result);
		System.out.println("Cost time :" + (System.nanoTime() - s) + "ns");
	}

	private static void myselfCode() {
		long s = System.nanoTime();
		CubePlusWorker cube = new CubePlusWorker();
		Master master = new Master(cube, 10);
		//分解为100个子任务
		for (int i = 1; i <= 100; i++) {
			master.submit(i);
		}
		//执行子任务
		master.execute();
		Integer result = 0;
		System.out.println("每个子任务的执行结果是：");
		for (Map.Entry<String, Object> entry : master.getResultMap().entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
			result += Integer.valueOf(entry.getValue().toString());
		}
		System.out.println("开始汇总计算结果：");
		if (result != 0 && master.isComeplete()) {
			System.out.println("The SUM is : " + result);
		}
		System.out.println("Cost time :" + (System.nanoTime() - s) + "ns");
	}


	private static void FrameworkTest() {
		Worker worker = new Worker();
		Master master = new Master(worker, 6);
		master.submit("aaaaa1");
		master.submit("aaaaa2");
		master.submit("aaaaa3");
		master.execute();

		Integer result = 0;
		System.out.println("执行的结果是：");
		for (Map.Entry<String, Object> entry : master.getResultMap().entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
			result += Integer.valueOf(entry.getValue().toString());
		}
		if (result != 0 && master.isComeplete()) {
			System.out.println("The SUM is : " + result);
		}
	}


}
