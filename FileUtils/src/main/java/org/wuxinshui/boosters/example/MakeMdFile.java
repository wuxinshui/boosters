package org.wuxinshui.boosters.example;

import java.util.Map;
import java.util.Set;

import static org.wuxinshui.boosters.file.FilesUtils.loadLocalProperty;
import static org.wuxinshui.boosters.file.FilesUtils.writeToLocal;

/**
 * Created by FujiRen on 2016/8/17.
 */
public class MakeMdFile {
//    private static final String filePath = "readme.properties";
    private static final String filePath = "readme2.properties";
    private static final String makedFilePath = "D:\\GitBook\\";


    public static void main(String[] args) {
        makeFile();
    }


    public static void makeFile() {
        Set<Map.Entry<Object, Object>> mdFielNames = loadLocalProperty(filePath);
        for (Map.Entry<Object,Object> entry:mdFielNames) {
            String fileName=entry.getKey().toString();
            String path=makedFilePath+fileName;
            writeToLocal(path,"#"+fileName);
        }
    }
}
