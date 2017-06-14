package org.wuxinshui.boosters.interview01.base.interabstract.base1;

/**
 * <p>ConstructorTest</p>
 *
 * @author wuxinshui
 */
public class ConstructorTest {

    public ConstructorTest() {
    }

    public ConstructorTest(String s1) {
        System.out.println(s1);
    }


    public void print3(String s1) {
        System.out.println(s1);
    }

    public String print3(String s1, String s2) {
        System.out.println(s1);
        return s1;
    }

    public String print3(String s2, int s1) {
        System.out.println(s1);
        return s2;
    }

    public String print3(int s2, String s1) {
        System.out.println(s1);
        return s1;
    }

    public int print3(int s1, int s2) {
        System.out.println(s1);
        return s1;
    }

}
