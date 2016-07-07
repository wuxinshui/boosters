package org.wuxinshui.boosters.xml;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.util.Iterator;

/**
 * JSON字符串转为SOAP 报文
 */
public class JSON2SOAP {

    private static String jsonMessage = null;
    private static String rootNodePrefix = null;
    private static String typeNodePrefix = null;

    /**
     * @param srcMessage   json字符串
     * @param soapFileName 本地soap报文
     * @param rootPrefix   soap中根节点的前缀
     * @param typePrefix   type节点的前缀
     * @return
     */
    public static String transToSOAP(String srcMessage, String soapFileName,
                                     String rootPrefix, String typePrefix) {
        String resultString = null;
        jsonMessage = srcMessage;
        rootNodePrefix = rootPrefix;
        typeNodePrefix = typePrefix;
        JSON2SOAP j2s = new JSON2SOAP();
        String soapMessage = j2s.loadSOAPFile(soapFileName);

        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new ByteArrayInputStream(
                    soapMessage.getBytes("UTF-8")));
            // 获取根节点
            Element elementRoot = document.getRootElement();
            Iterator<Element> rootItera = elementRoot.elementIterator();
            setValue(rootItera);
            resultString = document.asXML();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return resultString;
    }

    /**
     * 遍历子元素设值
     *
     * @param iterator
     */
    private static void setValue(Iterator<Element> iterator) {
        while (iterator.hasNext()) {
            Element childEle = iterator.next();
            // 属性
            Iterator<Attribute> attrItera = childEle.attributeIterator();
            if (attrItera.hasNext()) {
                setAttr(attrItera);
            }
            Iterator<Element> childItera = childEle.elementIterator();
            if (!childItera.hasNext()) {
                String value = getJsonValue(childEle.getUniquePath());
                childEle.setText(value);
            } else {
                setValue(childItera);
            }
        }
    }

    /**
     * 遍历属性设值
     *
     * @param attrItera
     */

    private static void setAttr(Iterator<Attribute> attrItera) {
        while (attrItera.hasNext()) {
            Attribute attribute = attrItera.next();
            String attrName = attribute.getName();
            String path = attribute.getPath().split("@")[0];
            JSONObject jsonObject = JSONObject.parseObject(getJsonValue(path));
            Object valueObj = null == jsonObject.get("@" + attrName) ? ""
                    : jsonObject.get("@" + attrName);
            attribute.setValue(valueObj.toString());
        }
    }

    /**
     * XPATH获取JSON字符串中的值
     *
     * @param path
     * @return
     */

    private static String getJsonValue(String path) {
        // 过滤path中的元素前缀
        path = path.replace(rootNodePrefix, "");
        path = path.replace(typeNodePrefix, "");
        if (path.contains("[")&&path.endsWith("]")){
            path=getJSONXpath(path);
        }
        Object object = JSONPath.read(jsonMessage, path);
        return null == object ? "" : object.toString();
    }

    /**
     * 加载资源文件
     *
     * @param fileName
     * @return
     */
    private String loadSOAPFile(String fileName) {

        InputStream inputStream = this.getClass().getResourceAsStream(fileName);
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                inputStream))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                sb.append(sCurrentLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }


    /**
     * 获取正确的数组下标
     *
     * @param string
     * @return
     */
    public static String getJSONXpath(String string) {
        int begin = string.indexOf("[");
        int end = string.indexOf("]");
        String indexStr = string.substring(begin + 1, end);
        string = string.substring(0, begin) + "[" + (Integer.parseInt(indexStr) - 1) + "]";
        return string;
    }

}
