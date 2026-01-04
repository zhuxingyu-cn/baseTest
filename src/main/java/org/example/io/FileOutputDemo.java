package org.example.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * D:\999.green\javaEngineer\1、Java零基础入门\第6-7周 常用工具类（下）\4. Java输入输出流
 * 将字节写入到文件当中
 * 适合图片，word等字节数据
 */
public class FileOutputDemo {
    public static void main(String[] args) {
        try {
            //构造方法有5种
            /**
             * 常用
             * FileOutputStream(String name)覆盖写入
             * FileOutputStream(String name, boolean append)追加写入
             *
             * 较常用
             * FileOutputStream(File file)覆盖写入
             * FileOutputStream(File file, boolean append)追加写入
             *
             * 不常用
             * FileOutputStream(FileDescriptor fdObj)
             */

            /**
             * 基本方法和FileInputStream一样
             * write(int b)
             * close()
             * write(byte[] b)
             * write(byte[] b, int off, int len)
             */
            //写入一个字节
            FileOutputStream fos = new FileOutputStream("imooc.txt");//内容：Hello,imooc!，注意这个是相对路径
            fos.write(50);
            fos.write('b');
            FileInputStream fis = new FileInputStream("imooc.txt");//内容：Hello,imooc!，注意这个是相对路径
            int read = fis.read();
            System.out.println(read);
            System.out.println((char) fis.read());
            fis.close();//必须要关闭
            fos.close();//必须要关闭

            //根据数组去进行写入write(byte[] b)
//            FileOutputStream fos2 = new FileOutputStream("imooc.txt");//内容：Hello,imooc!，注意这个是相对路径
//            byte[] bytes = {'a', 'b', 'c', 'd', 'e', 'f'};
//            fos2.write(bytes);
//            fos2.close();//必须要关闭

            //根据数组和偏移量，限制长度去进行写入write(byte[] b, int off, int len)
            FileOutputStream fos3 = new FileOutputStream("imooc.txt");//内容：Hello,imooc!，注意这个是相对路径
            byte[] byte3 = {'a', 'b', 'c', 'd', 'e', 'f'};
            fos3.write(byte3, 0, 4);
            fos3.close();//必须要关闭

            //文件拷贝
            FileInputStream fis4 = new FileInputStream("tupian.jpg");
            FileOutputStream fos4 = new FileOutputStream("tupian_copy.jpg");
            byte[] byte4 = new byte[1024];
            int n;
            while ((n = fis4.read(byte4)) != -1) {//每次执行读的方法都会往后面读
                fos4.write(byte4, 0, n);//每次执行写的方法都会往后面写
            }
            fos4.close();
            fis4.close();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
