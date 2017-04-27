package org.wuxinshui.boosters.http;


import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.http.HttpEntity;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import static org.wuxinshui.boosters.json.JSONUtils.JSONFormatter;

/**
 * @Description:
 * @Author:Wuxinshui
 * @Date:2017/4/27 11:23
 */
public class HttpUtils {

	public static String responseJSON(String url, int method, String jsonData) {
		return JSONFormatter(executeCall(url, method, jsonData));
	}

	public static String executeCall(String url, int method, String jsonData) {
		String response = "";
		try {
			// http client
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpEntity httpEntity = null;
			HttpResponse httpResponse = null;
			// Checking http request method type
			if (method == 0) {
				HttpPost httpPost = new HttpPost(url);
				// adding post params
				if (jsonData != null && jsonData.length() > 0) {
					StringEntity encodedEntity = new StringEntity(jsonData, "UTF-8");
					encodedEntity.setContentType("application/json");
					httpPost.setEntity(encodedEntity);
				}
				httpResponse = httpClient.execute(httpPost);

			} else if (method == 1) {
				HttpGet httpGet = new HttpGet(url);
				httpResponse = httpClient.execute(httpGet);
			}
			//codigo pruebna
			response = new Scanner(httpResponse.getEntity().getContent(), "UTF-8").useDelimiter("\\A").next();
		/*httpEntity = httpResponse.getEntity();
		response = EntityUtils.toString(httpEntity,"utf-8");*/
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

	public static void sendPost(String url, String jsonData) {
		try {
			//创建连接
			URL connUrl = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) connUrl
					.openConnection();
			// 发送POST请求必须设置如下两行
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestProperty("Content-Type",
					"application/json");

			connection.connect();

			//POST请求
			DataOutputStream out = new DataOutputStream(
					connection.getOutputStream());
			out.writeBytes(jsonData);
			out.flush();
			out.close();

			//读取响应
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String lines;
			StringBuffer sb = new StringBuffer("");
			while ((lines = reader.readLine()) != null) {
				lines = new String(lines.getBytes(), "utf-8");
				sb.append(lines);
			}
			System.out.println(sb);
			reader.close();
			// 断开连接
			connection.disconnect();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
