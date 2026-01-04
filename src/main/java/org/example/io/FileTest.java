package org.example.io;

import java.io.File;
import java.io.IOException;

/**
 * D:\999.green\javaEngineer\1、Java零基础入门\第6-7周 常用工具类（下）\4. Java输入输出流
 * 此类中需要的文件都在桌面上
 * （原）根目录imooc，下有两个目录io和set，io下有文件score.txt
 */
public class FileTest {
    public static void main(String[] args) {
        //File类的四种创建方式
        // 1. File(String pathname) 最常用
        File file = new File("C:\\Users\\zhuxingyu\\Desktop\\imooc\\io\\score.txt");
        System.out.println("file是否是文件：" + file.isFile());
        System.out.println("file是否是目录：" + file.isDirectory());
        // 2. File(String parent, String child) 前面写死到配置中
        File file2 = new File("C:\\Users\\zhuxingyu\\Desktop\\imooc", "io\\score.txt");
        System.out.println("file2是否是文件：" + file2.isFile());
        System.out.println("file2是否是目录：" + file2.isDirectory());
        // 3. File(File parent, String child) 这个应该很少用
        File parentFile = new File("C:\\Users\\zhuxingyu\\Desktop\\imooc");
        File file3 = new File(parentFile, "io\\score.txt");
        System.out.println("file3是否是文件：" + file3.isFile());
        System.out.println("file3是否是目录：" + file3.isDirectory());
        // 3. File(URI uri) 借助外网，这种方法也无法判断是否是文件或者是目录
        File file4 = new File(parentFile, "https://s11.ax1x.com/2022/11/02/xH4Mr9.jpg");//笑脸图片
        System.out.println("file4是否是文件：" + file4.isFile());
        System.out.println("file4是否是目录：" + file4.isDirectory());
        // 当不存在时不会报错也不会报空指针，只是无法判断是文件还是目录
        File file6 = new File("C:\\Users\\zhuxingyu\\Desktop\\imooc\\a");
        System.out.println("file6是否是文件：" + file6.isFile());
        System.out.println("file6是否是目录：" + file6.isDirectory());

        System.out.println("==================");
        //创建目录或者文件
        File file5 = new File("C:\\Users\\zhuxingyu\\Desktop\\imooc\\set\\hashSet.txt");
        System.out.println("file5是否是文件：" + file5.isFile());
        System.out.println("file5是否是目录：" + file5.isDirectory());
        if (!file5.exists()) {//注意方法后面有一个s
            //创建目录，只能创建一层
            boolean c = file5.mkdir();//把默认的set目录删掉后，发现并不能创建两层目录，但是也没有报错
            System.out.println("多级目录创建成功了吗：" + c);
            System.out.println("file5是否是文件：" + file5.isFile());
            System.out.println("file5是否是目录：" + file5.isDirectory());
            //创建多级目录，一层多层都可以，存在不存在都可以，先删掉set目录
            boolean a = file5.mkdirs();
            System.out.println("多级目录创建成功了吗：" + a);
            System.out.println("file5是否是文件：" + file5.isFile());
            System.out.println("file5是否是目录：" + file5.isDirectory());
            //创建文件
            try {
                //只要调用过mkdir()或者mkdirs()成功后，file5.isDirectory()就会变成true，createNewFile()就无法成功
                boolean b = file5.createNewFile();//前面的路径一定得对
                System.out.println("文件创建成功了吗：" + b);
            } catch (IOException e) { //创建文件会报IO异常
                throw new RuntimeException(e);
            }
        }

        //创建文件的最佳实践
        //现在要在C:\Users\zhuxingyu\Desktop\imooc下面创建zxy\test目录，并且创建test.txt文件，怎么做最快
        File file7 = new File("C:\\Users\\zhuxingyu\\Desktop\\imooc\\zxy\\test\\test.txt");//直接写出要创建的文件的路径
        if (!file7.exists()) {//首先判断文件存不存在
            File parentFile1 = file7.getParentFile();//文件不存在判断上级目录存不存在
            if (!parentFile1.exists()) {//如果不存在批量创建目录
                boolean a = parentFile1.mkdirs();
            }
            try {//创建文件
                boolean b = file7.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {//这个看情况而定，文件存在了是否要删掉新增
            boolean delete = file7.delete();
        }

        //相对路径和绝对路径 ./ ../ (unix) --> .\\ ..\\ (windows) 就不举例了
        //主要用于测试相对路径和绝对路径的相关方法，等后续用到时进行最佳实践补充
        //在此类的相关路径下操作，操作完成后删掉
//        File file8 = new File("..\\baseTest\\temp\\temp.txt");
        File file8 = new File("temp\\temp.txt"); //注意：这边的相对路径相对的是项目的根路径
//        File file8 = new File("temp"); //注意：目录同理
        //先创建目录temp
        if (!file8.exists()) {//首先判断文件存不存在
            File parentFile1 = file8.getParentFile();//文件不存在判断上级目录存不存在
            if (!parentFile1.exists()) {//如果不存在批量创建目录
                boolean a = parentFile1.mkdirs();
            }
            try {//创建文件
                boolean b = file8.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //是否为绝对路径 false
            System.out.println(file8.isAbsolute());
            //相对路径为：temp\temp.txt
            System.out.println(file8.getPath());
            //绝对路径为（和根路径相关）：C:\Users\zhuxingyu\IdeaProjects\baseTest\temp\temp.txt
            System.out.println(file8.getAbsolutePath());
            //文件名为：temp.txt
            System.out.println(file8.getName());
        } else {//这个看情况而定，文件存在了是否要删掉新增
            boolean delete = file7.delete();
        }

    }
}
