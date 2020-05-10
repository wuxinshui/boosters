package org.wuxinshui.boosters.wsdl;

import org.reficio.ws.builder.SoapBuilder;
import org.reficio.ws.builder.SoapOperation;
import org.reficio.ws.builder.core.Wsdl;

import javax.xml.namespace.QName;
import java.util.List;

/**
 * Created by FujiRen on 2016/4/13.
 */
public class SoapMessage {
    public static String getSoapMessage(String wsdlUrl,String operationName) {
        Wsdl wsdl = Wsdl.parse(wsdlUrl);
        List<QName> bindings = wsdl.getBindings();
        QName serviceBinding = bindings.get(0);
        String serviceBindingName = serviceBinding.getLocalPart();

        SoapBuilder builder = wsdl.binding().localPart(serviceBindingName).find();
        SoapOperation operation = builder.operation().name(operationName).find();
        //soap报文
        String soapRequestMessage = builder.buildInputMessage(operation);
        return soapRequestMessage;
    }


}
