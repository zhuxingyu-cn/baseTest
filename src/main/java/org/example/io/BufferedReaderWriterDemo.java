package org.example.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * <b>描述：</b><p>缓冲字符流样例
 *
 * <p><b>创建时间：</b><p>2026-01-11 17:34
 *
 * @author 朱兴宇
 * @version 1.0.0
 */
public class BufferedReaderWriterDemo {

    /*
        BufferedReader
            构造方法：
                BufferedReader(Reader in)
                BufferedReader(Reader in, int sz)
            方法：
                read()
                read(char[] cbuf)
                read(char[] cbuf, int off, int len)
        BufferedWriter
            构造方法：
                BufferedWriter(Writer out)
                BufferedWriter(Writer out, int sz)
            方法：
                write(int c)
                write(char[] cbuf)
                write(String str)
                write(char[] cbuf, int off, int len)
     */

    /**
     * 主方法
     *
     * @param args 默认参数
     */
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("imooc.txt");
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            FileOutputStream fos = new FileOutputStream("imooc2.txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
            BufferedWriter bw = new BufferedWriter(osw);
            int n;
            char[] buf = new char[1024];
            while ((n = br.read(buf)) != -1) {
                bw.write(buf, 0, n);
            }
            br.close();
            isr.close();
            fis.close();
            bw.close();
            osw.close();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
