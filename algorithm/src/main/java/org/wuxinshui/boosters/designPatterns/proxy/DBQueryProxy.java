package org.wuxinshui.boosters.designPatterns.proxy;

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
 * Created by wuxinshui on 2017/2/21.
 */
//代理类
public class DBQueryProxy implements IDBQuery {

	private DBQuery query=null;

	@Override
	public String request() {
		//在真正需要的时候，才创建真实对象，创建过程，可能很慢
		if (query==null){
			query=new DBQuery();
		}
		//多线程环境下，这里返回一个虚假类，类似Future模式
		return query.request();
	}
}
