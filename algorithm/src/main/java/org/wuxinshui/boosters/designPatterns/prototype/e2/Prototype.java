package org.wuxinshui.boosters.designPatterns.prototype.e2;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/10
 * Time: 16:13
 * To change this template use File | Settings | File Templates.
 * <p>
 * 浅复制：将一个对象复制后，基本数据类型的变量都会重新创建，而引用类型，指向的还是原对象所指向的。
 * 深复制：将一个对象复制后，不论是基本数据类型还有引用类型，都是重新创建的。简单来说，就是深复制进行了完全彻底的复制，而浅复制不彻底。
 */
public class Prototype implements Cloneable, Serializable {

    private String string;

    /*浅复制*/
    public Object clone() throws CloneNotSupportedException {
        Prototype obj = (Prototype) super.clone();
        return obj;
    }

    /*深复制*/
    public Object deepClone() throws IOException, ClassNotFoundException {
        //写入当前对象的二进制流
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(this);

        //读出二进制流产生新的对象
        ByteArrayInputStream bis = new ByteArrayInputStream(os.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);

        return ois.readObject();

    }
}
