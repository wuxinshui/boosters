package org.wuxinshui.boosters.skill01;

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
 * Created by wuxinshui on 2017/2/22.
 */
//三元表达式，判断null情况下的优化
public class TernaryExpressionNull {
	private   String s1;
	private   String s2;

	private static TernaryExpressionNull ten=new TernaryExpressionNull();

	public TernaryExpressionNull() {
	}

	public TernaryExpressionNull(String s1, String s2) {
		this.s1 = s1;
		this.s2 = s2;
	}

	public static void main(String[] args) {
		long normal1=System.currentTimeMillis();
		for (int i=0;i<Integer.MAX_VALUE;i++){
			normal();
		}
		long normal2=System.currentTimeMillis();
		System.out.println("normal cost time is :"+(normal2-normal1));//normal cost time is :4
		long best1=System.currentTimeMillis();
		for (int i=0;i<Integer.MAX_VALUE;i++){
			best();
		}
		long best2=System.currentTimeMillis();
		System.out.println("best cost time is :"+(best2-best1));//best cost time is :2
	}

	//一般做法
	public static boolean normal(){
		return ten.s1==null?ten.s2==null:ten.s1.equals(ten.s2);
	}

	//优化做法
	public static boolean best(){
		return ten.s1==ten.s2|| ten.s1!=null&&ten.s1.equals(ten.s2);
	}

}
