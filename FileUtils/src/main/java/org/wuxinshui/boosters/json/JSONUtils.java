package org.wuxinshui.boosters.json;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FujiRen on 2016/5/5.
 */
public class JSONUtils {

    private static final String CONSTANT_DOT = ".";
    private static final String CONSTANT_DOT_STR = "_DOT_";
    private static final String CONSTANT_SUB = "-";
    private static final String CONSTANT_SUB_STR = "_SUB_";
    private static final String CONSTANT_COLON = ":";
    private static final String CONSTANT_BLANK = "";

    public static List<String> replaceComma(List<String> list) {
        List<String> result = new ArrayList<>();
        for (String str : list) {
            str = str.replace(CONSTANT_DOT, CONSTANT_BLANK);
            str = str.replace(CONSTANT_SUB, CONSTANT_BLANK);
            result.add(str);
        }
        return result;
    }

    /**
     * 特殊字符替换
     * 点替换为_DOT_,-替换为_SUB_
     *
     * @param jsonStr
     * @return
     */
    public static String replaceDotSub(String jsonStr) {
        jsonStr = jsonStr.replace(CONSTANT_DOT, CONSTANT_DOT_STR);
        jsonStr = jsonStr.replace(CONSTANT_SUB, CONSTANT_SUB_STR);
        return jsonStr;
    }

    /**
     * 特殊字符替换
     * _DOT_解析为点,_SUB_解析为减号
     *
     * @param jsonStr
     * @return
     */
    public static String parseDotSub(String jsonStr) {
        //格式化JSON，使JSON中的键值对换行
        jsonStr = JSONFormatter(jsonStr);
        //可以直接解析键值对，不会替换值中的字符
        String regexDot = "_DOT_(?=.*:)";
        String regexSub = "_SUB_(?=.*:)";
        jsonStr = jsonStr.replaceAll(regexDot, CONSTANT_DOT);
        jsonStr = jsonStr.replaceAll(regexSub, CONSTANT_SUB);
        return jsonStr;
    }

    /**
     * 特殊字符替换
     * 减号，数字中间的点(不包括字母和数字之间的点)
     * 解析为冒号
     *
     * @param jsonStr
     * @return
     */
    public static String parseToColon(String jsonStr) {
        //以数字结尾的前面带-的字符
        String regexSub = "-(?=\\d+)";
        jsonStr = jsonStr.replaceAll(regexSub, CONSTANT_COLON);
        //以数字开始后面带点的字符
        String regexDot = "(?<=\\d+)\\.";
        jsonStr = jsonStr.replaceAll(regexDot, CONSTANT_COLON);
        return jsonStr;
    }

    /**
     * 判断json字符串是不是JSON对象
     *
     * @param jsonStr
     * @return
     */
    public static boolean isJSONObject(String jsonStr) {
        if (StringUtils.isBlank(jsonStr)) {
            return false;
        }
        try {
            JSONObject.parseObject(jsonStr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 判断json字符串是不是JSON数组
     *
     * @param jsonStr
     * @return
     */
    public static boolean isJSONOArray(String jsonStr) {
        if (StringUtils.isBlank(jsonStr)) {
            return false;
        }
        try {
            JSONObject.parseArray(jsonStr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 格式化json
     *
     * @param uglyJSONString
     * @return
     */
    public static String JSONFormatter(String uglyJSONString) {
        Gson gson3 = new GsonBuilder().setPrettyPrinting().create();
        com.google.gson.JsonParser jp = new com.google.gson.JsonParser();
        JsonElement je = jp.parse(uglyJSONString);
        String prettyJsonStr2 = gson3.toJson(je);
        return prettyJsonStr2;
    }

    public static String getJSONXpath(String string) {
        int begin=string.indexOf("[");
        int end=string.indexOf("]");
        String indexStr=string.substring(begin+1,end);
        string=string.substring(0,begin)+"["+(Integer.parseInt(indexStr)-1)+"]";
        return string;
    }

}
