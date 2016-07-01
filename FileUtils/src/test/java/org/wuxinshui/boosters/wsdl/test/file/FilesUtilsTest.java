package org.wuxinshui.boosters.wsdl.test.file;

import org.wuxinshui.boosters.wsdl.file.FilesUtils;
import org.junit.Test;

import static org.wuxinshui.boosters.wsdl.file.FilesUtils.readFile;

/**
 * Created by FujiRen on 2016/4/13.
 */
public class FilesUtilsTest {
    @Test
    public void test() {
        String filePath = "F:\\WORK\\";
        String fileName = "test.json";
        String textContent = "aaaaaa";
        FilesUtils.writeToLocal(filePath, fileName, textContent);
    }

    @Test
    public void testReadFile() {
        String path ="";
        System.out.println(readFile(path));
    }
}
