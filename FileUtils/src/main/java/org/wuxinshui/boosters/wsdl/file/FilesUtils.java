package org.wuxinshui.boosters.wsdl.file;

import java.io.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 文件操作工具类
 */
public class FilesUtils {

    /**
     * @param filePath    文件全路径，包括文件名
     * @param textContent 文本内容
     */
    public static void writeToLocal(String filePath, String fileName, String textContent) {
        File directory = new File(filePath);
        try {
            //目录不存在，创建所有的目录
            if (!directory.exists()) {
                directory.mkdirs();
            }
            File file = new File(directory, fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
            out.write(textContent.getBytes("UTF-8"));
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String ReadFile(String Path) {
        BufferedReader reader = null;
        String laststr = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(Path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                laststr += tempString;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return laststr;
    }

    public static String readFileByStream(InputStream inputStream) {
        StringBuilder resultStr = new StringBuilder();
        BufferedReader reader = null;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String temp = null;
            while ((temp = reader.readLine()) != null) {
                resultStr.append(temp);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return resultStr.toString();
    }

    /**
     * @param filePath
     * @param textContent
     */
    public static void writeToLocal(String filePath, String textContent) {
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(textContent.toCharArray());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取指定文件
     * 返回字符串
     *
     * @param filePath
     * @return
     */
    public static String readFile(String filePath) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

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

    public static Set<Map.Entry<Object, Object>> loadLocalProperty(String pathName){
        FilesUtils filesUtils=new FilesUtils();
        return filesUtils.loadPropertyFile(pathName);
    }



    /**
     * 加载本地属性文件，获取属性值
     *
     * @param pathName
     * @return
     */
    private Set<Map.Entry<Object, Object>> loadPropertyFile(String pathName) {
        Set<Map.Entry<Object, Object>> set = new HashSet<>();
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(pathName);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            Properties properties = new Properties();
            properties.load(inputStreamReader);
            set = properties.entrySet();
        } catch (IOException e) {
            System.out.println("load local property file failed");
            e.printStackTrace();
        }
        return set;
    }

}
