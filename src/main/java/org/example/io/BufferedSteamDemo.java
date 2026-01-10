package org.example.io;

import java.io.*;

/**
 * <b>描述：</b><p>缓冲输入输出流样例
 *
 * <p><b>创建时间：</b><p>2026-01-10 15:31
 *
 * @author 朱兴宇
 * @version 1.0.0
 */
public class BufferedSteamDemo {
    /*
        BufferedInputStream
            构造方法：
                BufferedInputStream(InputStream in) 由字节输入流作为参数
                BufferedInputStream(InputStream in, int size) 由字节输入流和缓冲区大小作为参数
            常用方法：
                read()
                read(byte[] b)
                read(byte[] b, int off, int len) 从给定的偏移开始，将字节输入流中的字节读入指定的字节数组
                close()
        BufferedOutputStream
            构造方法：
                BufferedOutputStream(OutputStream out) 由字节输出流作为参数
                BufferedOutputStream(OutputStream out, int size) 由字节输出流和缓冲区大小作为参数
            常用方法：
                write(int b)
                write(byte[] b)
                write(byte[] b, int off, int len)
                flush() 刷新缓冲输出流
                close() 也会强制刷新缓冲输出流
     */

    /**
     * 测试方法
     *
     * @param args 参数数组
     */
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("tupian.jpg");
             BufferedInputStream bis = new BufferedInputStream(fis);
             FileOutputStream fos = new FileOutputStream("tupian2.jpg");
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            int n;
            //这种方法使用不会丢失字节，但是存在性能问题，读取方式让缓冲失效，实际仍然是频繁的磁盘I/O操作
//            while ((n = bis.read()) != -1) {
//                bos.write(n);
//            }
            //可以利用缓冲区优势
            byte[] b = new byte[1024*8*4];
            while ((n = bis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
