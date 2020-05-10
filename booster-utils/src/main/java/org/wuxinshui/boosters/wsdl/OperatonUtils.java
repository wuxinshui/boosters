package org.wuxinshui.boosters.wsdl;

import com.ibm.wsdl.BindingImpl;
import com.ibm.wsdl.PortTypeImpl;
import com.ibm.wsdl.xml.WSDLReaderImpl;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.reficio.ws.builder.SoapBuilder;
import org.reficio.ws.builder.SoapOperation;
import org.reficio.ws.builder.core.Wsdl;

import javax.wsdl.BindingOperation;
import javax.wsdl.Definition;
import javax.wsdl.Operation;
import javax.wsdl.WSDLException;
import javax.wsdl.xml.WSDLReader;
import javax.xml.namespace.QName;
import java.io.File;
import java.util.*;

/**
 * Created by FujiRen on 2016/5/3.
 */
public class OperatonUtils {

    /**
     * 根据wsdlUrl获取operation列表
     *
     * @param wsdlUrl
     * @return
     */
    public static List<String> getOperationByUrl(String wsdlUrl) {
        List<String> resultList = new ArrayList<>();
        List<Operation> operationList = getPortTypeOperations(wsdlUrl);
        for (Operation operation : operationList) {
            resultList.add(operation.getName());
        }
        return resultList;
    }

    /**
     * 根据wsdl文件获取operation列表
     *
     * @param wsdlFile
     * @return
     */
    public static List<String> getOperationByFile(String wsdlFile) {
        List<String> operaList = new ArrayList<>();
        try {
            File file = new File(wsdlFile);
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(file);
            // 获取根节点
            Element elementRoot = document.getRootElement();
            //xpath查询body节点
            Node portTypeNode = elementRoot.selectSingleNode("./*[starts-with(name(),'portType')]");
            List<Node> nodeList = portTypeNode.selectNodes("./*[starts-with(name(),'operation')]");
            for (Node node : nodeList) {
                Element element = (Element) node;
                operaList.add(element.attribute(0).getStringValue());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return operaList;
    }

    /**
     * 参考SoapMessageBuilder.SoapMessageBuilder(URL wsdlUrl)方法
     * 获取portType中的所有operation
     *
     * @param wsdlUrl
     * @return
     */
    private static List<Operation> getPortTypeOperations(String wsdlUrl) {
        List<Operation> operationList = new ArrayList();
        try {
            WSDLReader reader = new WSDLReaderImpl();
            reader.setFeature("javax.wsdl.verbose", false);
            Definition definition = reader.readWSDL(wsdlUrl.toString());
            Map<String, PortTypeImpl> defMap = definition.getAllPortTypes();
            Collection<PortTypeImpl> collection = defMap.values();
            for (PortTypeImpl portType : collection) {
                operationList.addAll(portType.getOperations());
            }
        } catch (WSDLException e) {
            System.out.println("get wsdl operation fail.");
            e.printStackTrace();
        }
        return operationList;
    }

    /**
     * 参考SoapMessageBuilder.SoapMessageBuilder(URL wsdlUrl)方法
     * 获取binding节点的所有operation
     *
     * @param wsdlUrl
     * @return
     */
    public static List<String> getAllBindingOperation(String wsdlUrl) {
        List<BindingOperation> operationList = new ArrayList();
        List<String> nameList = new ArrayList();
        try {
            WSDLReader reader = new WSDLReaderImpl();
            reader.setFeature("javax.wsdl.verbose", false);
            Definition definition = reader.readWSDL(wsdlUrl.toString());
            Map<String, BindingImpl> defMap = definition.getAllBindings();
            Collection<BindingImpl> collection = defMap.values();
            for (BindingImpl binding : collection) {
                operationList.addAll(binding.getBindingOperations());
            }
            for (BindingOperation operation:operationList) {
                nameList.add(operation.getName());
            }
        } catch (WSDLException e) {
            System.out.println("get wsdl operation fail.");
            e.printStackTrace();
        }
        return nameList;
    }

    /**
     * 获取binding节点的所有operation
     *
     * @param wsdlUrl
     * @return
     */
    public static List<String> getBindingOperations(String wsdlUrl) {
        List<String> operationList = new ArrayList();
        List<SoapOperation> soapOperationList = new ArrayList();
        //实例化Wsdl
        Wsdl parser = Wsdl.parse(wsdlUrl);
        //获取所有的Binding
        List<QName> bindQnames = parser.getBindings();
        //获取素有的SoapOperation
        for (QName qName : bindQnames) {
            SoapBuilder soapBuilder = parser.binding().localPart(qName.getLocalPart()).find();
            soapOperationList.addAll(soapBuilder.getOperations());
        }
        //获取素有的SoapOperation name
        for (SoapOperation soapOperation : soapOperationList) {
            operationList.add(soapOperation.getOperationName());
        }
        return operationList;
    }
}
