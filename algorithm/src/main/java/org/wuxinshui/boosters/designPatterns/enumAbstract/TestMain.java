package org.wuxinshui.boosters.designPatterns.enumAbstract;

/**
 * <p>TestMain</p>
 *
 * @author wuxinshui
 */
public class TestMain {
    public static void main(String[] args) {
        EnumAbstract enumAbstract = new EnumAbstract();
        enumAbstract.print(2);

        testSave();
        testSelect();
    }

    //模拟保存枚举到数据库
    public static void testSave() {
        String key = EnumAbstract.WorkDays.SUNDAY.name();
        //保存枚举实例对应的name到数据库
        System.out.println("保存枚举实例对应的name到数据库 " + key);
    }

    //模拟从数据库获取
    public static void testSelect() {
        EnumAbstract.WorkDays workDays = EnumAbstract.WorkDays.valueOf("SUNDAY");
        //模拟从数据库获取
        System.out.println("模拟从数据库获取对应的枚举实例 " + workDays);
        //class org.wuxinshui.boosters.designPatterns.enumAbstract.EnumAbstract$WorkDays$7 7表示
        System.out.println("模拟从数据库获取对应的枚举实例的类型 " + workDays.getClass());
        System.out.println("模拟从数据库获取对应的枚举实例，$WorkDays$7中的7表示"+workDays+ "的key："+ workDays.getKey());
    }
}
