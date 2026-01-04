package org.example.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * D:\999.green\javaEngineer\1、Java零基础入门\第6-7周 常用工具类（下）\4. Java输入输出流
 * 从某个文件中获得输入字节
 * 适合图片，word等字节数据
 */
public class FileInputDemo {
    public static void main(String[] args) {
        try {
            //读取一个字节并打印
            //这只是一种构造方法，还有两种
            FileInputStream fis = new FileInputStream("imooc.txt");//内容：Hello,imooc!，注意这个是相对路径
            int read = fis.read();
            System.out.println((char) read);
            fis.close();//必须要关闭

            //两种读取文件所有字节的方式
            //第一种read() ：先读然后便利改变读取返回值
            FileInputStream fis2 = new FileInputStream("imooc.txt");//内容：Hello,imooc!
            int read2 = fis2.read();
            while (-1 != read2) {
                System.out.print((char) read2);
                read2 = fis2.read();
            }
            fis2.close();

            //第二种read() ：设定默认值然后便利读取
            System.out.println();
            FileInputStream fis3 = new FileInputStream("imooc.txt");//内容：Hello,imooc!
            int n = 0;
            while ((n = fis3.read()) != -1) {
                System.out.print((char) n);
            }
            fis3.close();

            //采用byte数组 read(byte[] b)
            System.out.println();
            FileInputStream fis4 = new FileInputStream("imooc.txt");//内容：Hello,imooc!
            byte[] bytes = new byte[11];//注意看什么是字节数组，正好和字节流对应上，一个字节对应一个字节，正好可以保存ascii码值
            int read4 = fis4.read(bytes);
            System.out.println(new String(bytes));//返回的值是实际被填充的字节数组字节数
            fis4.close();

            //采用byte数组 read(byte[] b, int off, int len)
            FileInputStream fis5 = new FileInputStream("imooc.txt");//内容：Hello,imooc!
            byte[] byte5 = new byte[10];//注意看什么是字节数组，正好和字节流对应上，一个字节对应一个字节，正好可以保存ascii码值
            int read5 = fis5.read(byte5, 0, byte5.length);//返回的值是实际被填充的字节数组字节数
            System.out.println(new String(byte5));
            fis5.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
