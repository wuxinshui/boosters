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
//代理模式实现延迟加载。延迟加载的核心思想：如果当前没有使用这个组件，
// 则不需要正真初始化它，使用一个代理对象替代它的原有的位置，只要在真正需要使用的时候，才对它进行加载。
//主题接口
public interface IDBQuery {
	String request();
}
