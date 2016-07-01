package org.wuxinshui.boosters.wsdl.test.parse.wsdl;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.wuxinshui.boosters.wsdl.parse.wsdl.OperatonUtils.getAllBindingOperation;
import static org.wuxinshui.boosters.wsdl.parse.wsdl.OperatonUtils.getBindingOperations;
import static org.wuxinshui.boosters.wsdl.parse.wsdl.OperatonUtils.getOperationByUrl;

/**
 * Created by FujiRen on 2016/5/3.
 */
public class OperationUtilsTest {

    @Test
    public void test1() {
        String wsdlUrl = "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl";
        //        String wsdlUrl = "http://172.16.250.233:8080/QFTWS/services?wsdl";
        List<String> operations = getOperationByUrl(wsdlUrl);
        for (String operation : operations) {
            System.out.println(operation);
        }
    }
    @Test
    public void test2() {
        String wsdlUrl = "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl";
        long s1=System.currentTimeMillis();
        System.out.println(getBindingOperations(wsdlUrl));
        long e1=System.currentTimeMillis();
        System.out.println("getBindingOperations "+(e1-s1));//1707ms
        long s2=System.currentTimeMillis();
        System.out.println(getOperationByUrl(wsdlUrl));
        long e2=System.currentTimeMillis();
        System.out.println("getOperationByUrl "+(e2-s2));//199ms
        System.out.println(Arrays.equals(getBindingOperations(wsdlUrl).toArray(),getOperationByUrl(wsdlUrl).toArray()));
    }

    @Test
    public void test03(){
        String wsdlUrl = "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl";
//        String wsdlUrl = "http://172.16.250.233:8080/QFTWS/services?wsdl";
        long s1=System.currentTimeMillis();
        System.out.println(getAllBindingOperation(wsdlUrl));
        long e1=System.currentTimeMillis();
        System.out.println("getAllBindingOperation "+(e1-s1));//480ms
        long s2=System.currentTimeMillis();
        System.out.println(getOperationByUrl(wsdlUrl));
        long e2=System.currentTimeMillis();
        System.out.println("getOperationByUrl "+(e2-s2));//281ms
        System.out.println(Arrays.equals(getAllBindingOperation(wsdlUrl).toArray(),getOperationByUrl(wsdlUrl).toArray()));
    }
}
