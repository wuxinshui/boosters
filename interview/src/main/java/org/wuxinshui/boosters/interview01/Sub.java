package org.wuxinshui.boosters.interview01;

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
public class Sub extends Base {
//	private final String baseName = "Sub";
	private  String baseName = "Sub";

	@Override
	public void callName() {
		System.out.println(baseName);
	}

	//1.构造方法初始化顺序；
	// 2.重写
	public static void main(String[] args) {
		Base sub=new Sub();//输出null
	}
}
