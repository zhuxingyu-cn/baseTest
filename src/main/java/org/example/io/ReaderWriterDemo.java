package org.example.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * <b>描述：</b><p>字符字节转换流样例
 *
 * <p><b>创建时间：</b><p>2026-01-10 21:22
 *
 * @author 朱兴宇
 * @version 1.0.0
 */
public class ReaderWriterDemo {

    /*
        Reader 抽象类，字符输入流
            InputStreamReader：是从字节流到字符流的桥，它读取字节，并使用指定的charset将其解码为字符。
              构造方法：
                InputStreamReader(InputStream in) 默认字符集
                InputStreamReader(InputStream in, Charset cs)
                InputStreamReader(InputStream in, CharsetDecoder dec)
                InputStreamReader(InputStream in, String charsetName) 使用字符串指定
              方法：
                read()
                read(char[] cbuf, int offset, int length)
                ready()
                getEncoding()
                close()
        Writer 抽象类，字符输出流
            InputStreamWriter
              构造方法：
                OutputStreamWriter(OutputStream out) 默认字符集
                OutputStreamWriter(OutputStream out, Charset cs)
                OutputStreamWriter(OutputStream out, CharsetEncoder enc)
                OutputStreamWriter(OutputStream out, String charsetName)  使用字符串指定
              方法：
                write(int c)
                write(char[] cbuf, int off, int len)
                write(String str, int off, int len)
                getEncoding()
                flush()
                close()
    */

    /**
     * 测试方法
     *
     * @param args 默认参数
     */
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("imooc.txt");
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            int n;
            //单字符读取
//            while ((n = isr.read()) != -1) {
//                System.out.print("" + (char) n);
//            }

            //通过字符数组进行读取
            char[] buf = new char[1024];
//            while ((n = isr.read(buf)) != -1) {
//                System.out.print(new String(buf, 0, n));
//            }

            //读写操作
            FileOutputStream fos = new FileOutputStream("imooc2.txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
            while ((n = isr.read(buf)) != -1) {
                osw.write(buf, 0, n);
            }
            isr.close();
            osw.close();
            fis.close();
            fos.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
