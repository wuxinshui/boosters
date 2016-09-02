package org.wuxinshui.boosters.algerithom.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by FujiRen on 2016/9/1.
 * 插入排序
 * <p>
 * 每步将一个待排序的对象，按其关键码大小，
 * 插入到前面已经排好序的一组对象的适当位置上，直到对象全部插入为止。
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] intArray = new int[]{13, 6, 3, 31, 9, 27, 5, 11};
        long begin = System.nanoTime();
        System.out.println(Arrays.toString(simpleInsertionSort(intArray)));
        long end = System.nanoTime();
        System.out.println((end - begin) / 1000F);

    }

    /**
     * 直接插入排序
     * <p>
     * 先将序列中第1个记录看成一个有序子序列，
     * 然后从第2个记录开始，逐个进行插入，
     * 直至整个序列有序，排序过程为n-1趟插入。
     * </p>
     *
     * @param numArray
     */
    public static Integer[] simpleInsertionSort(int[] numArray) {

        int length = numArray.length;
        List<Integer> sortedList = new ArrayList<>();
        sortedList.add(0, numArray[0]);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (numArray[i] < sortedList.get(j)) {
                    sortedList.add(j, numArray[i]);
                    break;
                } else if (numArray[i] >= sortedList.get(i - 1)) {
                    sortedList.add(i, numArray[i]);
                    break;
                }
            }
        }
        return sortedList.toArray(new Integer[numArray.length]);
    }

    /**
     * 希尔排序
     * <p>
     * 先取一个正整数d1<n，把所有相隔d1的记录放一组，
     * 组内进行直接插入排序；然后取d2<d1，重复上述分组和排序操作；
     * 直至di=1，即所有记录放进一个组中排序为止。
     * 一般取d1=n/2, di+1=di/2，如果结果为偶数，则加1。
     * </p>
     *
     * @param numArray
     */
    public static void shellSort(int[] numArray) {

    }
}
