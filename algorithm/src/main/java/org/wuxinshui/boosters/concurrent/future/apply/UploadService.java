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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.context.support.XmlWebApplicationContext;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by wuxinshui on 2017/2/28.
 */
//模拟文件上传
public class UploadService {
	@Autowired
	private  ThreadPoolTaskExecutor threadPoolTaskExecutor;

	private UploadDao dao=new UploadDao();

	public String  persist(String filePath) throws ExecutionException, InterruptedException {
		//保存文件信息到数据库
		String result=dao.persistToDB(filePath);
		//保存文件到磁盘
		for (int i=0;i<5;i++){
			Callable<Object> callable=new FileHandlerCallable(filePath);
			Future<Object> future=threadPoolTaskExecutor.submit(callable);
			Object object=future.get();
			System.out.println(i+"--===="+object.toString());
		}
		return result;
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		UploadService service=new UploadService();
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext(new String[]{"spring-config.xml"});
		service.threadPoolTaskExecutor=applicationContext.getBean(ThreadPoolTaskExecutor.class);
		String filePath="C:\\Pictures\\FutureTask.png";
		System.out.println("文件上传："+service.persist(filePath));
	}
}
