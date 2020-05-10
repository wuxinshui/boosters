package org.wuxinshui.boosters.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionHandler {

    //public static void main(String[] args) {
    //    List<Integer> list=Stream.of(1,2,3,4,5,6,7,8,9,10).collect(Collectors.toList());
    //    System.out.println(split(list,3));
    //}

    public static <T> List<List<T>> split(List<T> sourceList, int count) {

        if (sourceList == null || count < 1) {
            return null;
        }
        List<List<T>> ret = new ArrayList<>();
        int size = sourceList.size();
        if (size <= count) { //数据量不足count指定的大小
            ret.add(sourceList);
        } else {
            int pre = size / count;
            int last = size % count;
            //前面pre个集合，每个大小都是count个元素
            for (int i = 0; i < pre; i++) {
                List<T> itemList = new ArrayList<>(count);
                for (int j = 0; j < count; j++) {
                    itemList.add(sourceList.get(i * count + j));
                }
                ret.add(itemList);
            }
            //last的进行处理
            if (last > 0) {
                List<T> itemList = new ArrayList<>(count);
                for (int i = 0; i < last; i++) {
                    itemList.add(sourceList.get(pre * count + i));
                }
                ret.add(itemList);
            }
        }
        return ret;

    }
}
