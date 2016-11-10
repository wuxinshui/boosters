package org.wuxinshui.boosters.designPatterns.prototype.e1;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/10
 * Time: 15:45
 * To change this template use File | Settings | File Templates.
 */
public class WorkResume {
    public static void main(String[] args) throws CloneNotSupportedException {
        Resume a=new Resume("张三");
        a.SetPersonalInfo("男","29");
        a.SetWorkExperience("1999-2008","张三公司");

        Resume b=(Resume) a.clone();
        b.SetWorkExperience("2005-2016","李四公司");
    }
}
