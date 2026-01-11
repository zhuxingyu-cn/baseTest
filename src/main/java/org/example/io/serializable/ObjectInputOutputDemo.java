package org.example.io.serializable;

import java.io.*;

/**
 * <b>描述：</b><p>对象流示例
 *
 * <p><b>创建时间：</b><p>2026-01-11 22:13
 *
 * @author 朱兴宇
 * @version 1.0.0
 */
public class ObjectInputOutputDemo {
    public static void main(String[] args) {
        //清空imooc.txt
        try {
            Goods goods = new Goods("苹果", 10.0, "111");
            System.out.println(goods);
            FileOutputStream fos = new FileOutputStream("imooc.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(goods);
            oos.writeBoolean(Boolean.TRUE);
            System.out.println(Boolean.TRUE);
            oos.close();
            fos.close();
            FileInputStream fis = new FileInputStream("imooc.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Goods goods1 = (Goods) ois.readObject();
            System.out.println(goods1);
            boolean b = ois.readBoolean();
            System.out.println(b);
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
