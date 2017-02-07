package org.wuxinshui.boosters.designPatterns.prototype.e1;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/10
 * Time: 15:36
 * To change this template use File | Settings | File Templates.
 */
public class WorkExperience  implements Cloneable{
    private String workDate;
    private String company;

    public Object clone() {
//        WorkExperience obj=(WorkExperience) super.clone();
        WorkExperience obj=new WorkExperience();
        obj.workDate=this.workDate;
        obj.company=this.company;
        return obj;
    }
}
