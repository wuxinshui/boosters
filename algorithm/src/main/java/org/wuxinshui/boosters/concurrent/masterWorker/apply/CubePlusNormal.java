package org.wuxinshui.boosters.concurrent.masterWorker.apply;

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
 * Created by wuxinshui on 2017/3/2.
 */
//不使用Master-Worker模式，时间要比使用之后快
public class CubePlusNormal {
	public static void main(String[] args) {
		int result=0;
		long s=System.nanoTime();
		for (int i=1;i<100;i++){
			result+=i*i*i;
		}
		System.out.println(result);
		System.out.println("Cost time :"+(System.nanoTime()-s)+"ns");
	}
}
