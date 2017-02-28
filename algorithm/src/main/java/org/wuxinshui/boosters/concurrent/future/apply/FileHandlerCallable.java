package org.wuxinshui.boosters.concurrent.future.apply;

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

import java.util.concurrent.Callable;

/**
 * Created by wuxinshui on 2017/2/28.
 */
//保存文件到磁盘
public class FileHandlerCallable implements Callable<Object> {
	private String filePath;

	public FileHandlerCallable(String filePath) {
		this.filePath = filePath;
	}

	//具体的存储逻辑
	@Override
	public Object call() throws Exception {
		System.out.println("正在存贮文件到本地。。。"+filePath);
		Thread.sleep(1000);
		System.out.println("文件存储成功--OK");
		return "文件存储OK";
	}
}
