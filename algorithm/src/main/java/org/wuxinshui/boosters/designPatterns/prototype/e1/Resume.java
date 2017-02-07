package org.wuxinshui.boosters.designPatterns.prototype.e1;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/10
 * Time: 15:39
 * To change this template use File | Settings | File Templates.
 */
public class Resume implements Cloneable {
    private String name;
    private String age;
    private String sex;
    private WorkExperience work;

    public Resume(String name) {
        this.name = name;
        work = new WorkExperience();
    }

    public Resume(WorkExperience work) {
        this.work = (WorkExperience) work.clone();
    }

    public void SetPersonalInfo(String sex, String age) {

    }

    public void SetWorkExperience(String workDate, String company) {

    }

    public Object clone() {
        Resume obj = new Resume(this.work);
        return obj;
    }


}
