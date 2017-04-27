package org.wuxinshui.boosters.test.wsdl;


import org.junit.Test;
import org.wuxinshui.boosters.file.FilesUtils;
import org.wuxinshui.boosters.wsdl.SoapMessage;

/**
 * Created by FujiRen on 2016/4/13.
 */
public class SoapRequestTest {

    @Test
    public  void test() {
        String wsdlUrl = "http://172.30.30.167:8080/TWSACCT/services?wsdl";
        String operationName = "WSACTIVITYPW";
        String pathName = "F:\\WORK\\TWSACCT_REQUEST.json";

        System.out.println("generating soap messages....");
        String soapRequestMessage = SoapMessage.getSoapMessage(wsdlUrl,operationName);
        System.out.println("generating soap xml file....");
        FilesUtils.writeToLocal(pathName,pathName+".xml", soapRequestMessage);
        System.out.println("xml file finished.your soap xml file ["+pathName+".xml]");
        System.out.println("generating json file....");
//        String jsonStr = SoapUtils.parseToJson(soapRequestMessage,false);
        FilesUtils.writeToLocal(pathName,pathName, "");
        System.out.println("json file finished.your json file ["+pathName+"]");

    }

    @Test
    public void test1(){
        String wsdlUrl = "http://172.30.30.167:8080/TWSACCT/services?wsdl";
        String operationName = "WSACTIVITYPW";
        String soapRequestMessage = SoapMessage.getSoapMessage(wsdlUrl,operationName);

    }
}
