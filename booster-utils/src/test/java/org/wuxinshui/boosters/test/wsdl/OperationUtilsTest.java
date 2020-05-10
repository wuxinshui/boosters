package org.wuxinshui.boosters.test.wsdl;

import org.junit.Test;
import org.wuxinshui.boosters.wsdl.OperatonUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by FujiRen on 2016/5/3.
 */
public class OperationUtilsTest {

    @Test
    public void test1() {
        String wsdlUrl = "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl";
        //        String wsdlUrl = "http://172.16.250.233:8080/QFTWS/services?wsdl";
        List<String> operations = OperatonUtils.getOperationByUrl(wsdlUrl);
        for (String operation : operations) {
            System.out.println(operation);
        }
    }
    @Test
    public void test2() {
        String wsdlUrl = "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl";
        long s1=System.currentTimeMillis();
        System.out.println(OperatonUtils.getBindingOperations(wsdlUrl));
        long e1=System.currentTimeMillis();
        System.out.println("getBindingOperations "+(e1-s1));//1707ms
        long s2=System.currentTimeMillis();
        System.out.println(OperatonUtils.getOperationByUrl(wsdlUrl));
        long e2=System.currentTimeMillis();
        System.out.println("getOperationByUrl "+(e2-s2));//199ms
        System.out.println(Arrays.equals(OperatonUtils.getBindingOperations(wsdlUrl).toArray(), OperatonUtils.getOperationByUrl(wsdlUrl).toArray()));
    }

    @Test
    public void test03(){
        String wsdlUrl = "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl";
//        String wsdlUrl = "http://172.16.250.233:8080/QFTWS/services?wsdl";
        long s1=System.currentTimeMillis();
        System.out.println(OperatonUtils.getAllBindingOperation(wsdlUrl));
        long e1=System.currentTimeMillis();
        System.out.println("getAllBindingOperation "+(e1-s1));//480ms
        long s2=System.currentTimeMillis();
        System.out.println(OperatonUtils.getOperationByUrl(wsdlUrl));
        long e2=System.currentTimeMillis();
        System.out.println("getOperationByUrl "+(e2-s2));//281ms
        System.out.println(Arrays.equals(OperatonUtils.getAllBindingOperation(wsdlUrl).toArray(), OperatonUtils.getOperationByUrl(wsdlUrl).toArray()));
    }
}
