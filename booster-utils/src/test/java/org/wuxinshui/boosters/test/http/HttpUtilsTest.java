package org.wuxinshui.boosters.test.http;

import org.wuxinshui.boosters.http.HttpUtils;

/**
 * @Description:
 * @Author:FujiRen
 * @Date:2017/4/27 11:44
 */
public class HttpUtilsTest {
	public static void main(String[] args) {
		String jsonData="{\"startDate\":\"2017-04-25\",\"endDate\":\"2017-04-25\",\"refferalTypes\":[],\"refferalIds\":[],\"funnelTypes\":[]}";
		String url="http://172.16.36.73:9090/dashboard/selectRefferalConvertRatio";
		System.out.println(HttpUtils.executeCall(url,0,jsonData));
		System.out.println(HttpUtils.responseJSON(url,0,jsonData));
	}
}
