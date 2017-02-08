package org.wuxinshui.boosters.test.file;

import org.wuxinshui.boosters.file.FilesUtils;
import org.junit.Test;

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
        System.out.println(FilesUtils.readFile(path));
    }
}
