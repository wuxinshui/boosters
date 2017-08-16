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
        String key = EnumAbstract.WorkDaysName.SUNDAY.name();
        //保存枚举实例对应的name到数据库
        System.out.println("保存枚举实例对应的name到数据库： " + key);
    }

    //模拟从数据库获取
    public static void testSelect() {
        //模拟从数据库获取
        EnumAbstract.WorkDaysName workDays = EnumAbstract.WorkDaysName.valueOf("SUNDAY");
        System.out.println("模拟从数据库获取对应的枚举实例： " + workDays);
        System.out.println("模拟从数据库获取对应的枚举实例的类型： " + workDays.getClass());
        System.out.println("页面直接展示：" + workDays + " 的name：" + workDays.getName());
    }
}
