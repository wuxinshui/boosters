package org.wuxinshui.boosters.algerithom.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.wuxinshui.boosters.algerithom.sort.InsertionSort.dichotomyInsertionSort;
import static org.wuxinshui.boosters.algerithom.sort.InsertionSort.simpleInsertionSort01;

/**
 * Created by FujiRen on 2016/9/6.
 * 插入排序单元测试
 */
public class InsertionSortTest {
    @Test
    public void test01() {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
    }

    /**
     * 直接插入排序单元测试
     */
    @Test
    public void testSimpleInsertionSort01() {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        System.out.println("直接插入排序，排序前：" + Arrays.toString(a));
        simpleInsertionSort01(a);
        System.out.println("直接插入排序，排序后：" + Arrays.toString(a));
    }
    /**
     * 直接插入排序单元测试
     */
    @Test
    public void testDichotomyInsertionSort() {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        System.out.println("直接插入排序，排序前：" + Arrays.toString(a));
        dichotomyInsertionSort(a);
        System.out.println("直接插入排序，排序后：" + Arrays.toString(a));
    }



}
