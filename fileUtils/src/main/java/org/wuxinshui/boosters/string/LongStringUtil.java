package org.wuxinshui.boosters.string;

/**
 * @Author: yoyo
 * @Description:
 * @Date: Created in 2019/8/23 11:34
 */
public class LongStringUtil {
    public static Long getUid(CharSequence sequence) {
        try {
            Integer hashCode = Math.abs(sequence.hashCode());
            Integer length = sequence.length();
            StringBuilder builder = new StringBuilder();
            builder.append(hashCode);
            builder.append(length);
            Long sum = sequence.codePoints().parallel().asLongStream().sum();
            builder.append(sum);
            return Long.valueOf(builder.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
        return Long.valueOf(sequence.hashCode());
    }


    public static void main(String[] args) {
        String str="Java中生产者与消费者问题的演变";

        System.out.println(getUid(str));
    }


}
