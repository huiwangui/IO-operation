package com.hxyc.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName Copy
 * @Description TODO 拷贝图片
 * @Author admin
 * @Date 2020/1/7 21:09
 **/
public class Copy {
    public static void main(String[] args) throws IOException {
        //demo1();
        //demo2();
        demo3();

    }

    /**
     * 第一种拷贝
     * 要拷贝的文件要是比较大，这样来拷贝文件的话，效率就太低咯，缘由是一次读写一个字节
     * 在开发中不推荐，效率太低
     * @throws IOException
     */
    private static void demo1() throws IOException {
        //创建输入流对象
        FileInputStream fis = new FileInputStream("美景.jpg");

        //创建输出流对象
        FileOutputStream fos = new FileOutputStream("copy.jpg");

        int b;
        //在不断的读取每一个字节
        while((b=fis.read())!= -1){
            //将每一个字节写出
            fos.write(b);
        }
        fis.close();
        fos.close();
    }

    /**
     * 第二种拷贝
     * available()获取读的文件所有的字节个数
     * 这样写效率高，但在开发中不推荐，缘由是当文件太大时，有可能内存溢出
     * @throws IOException
     */
    private static void demo2() throws IOException {
        //创建输入流对象
        FileInputStream fis = new FileInputStream("美景.jpg");

        //创建输出流对象
        FileOutputStream fos = new FileOutputStream("copy.jpg");

        //创建与文件一样大小的字节数组
        byte[] arr = new byte[fis.available()] ;

        //将文件上的字节读取到内存中
        fis.read(arr);
        //将字节数组中的字节数据写到文件上
        fos.write(arr);
        fis.close();
        fos.close();
    }

    /**
     * 第三种拷贝
     * 开发中常用此拷贝
     * @throws IOException
     */
    private static void demo3() throws IOException {
        //创建输入流对象
        FileInputStream fis = new FileInputStream("美景.jpg");

        //创建输出流对象
        FileOutputStream fos = new FileOutputStream("copy.jpg");

        byte[] arr = new byte[1024*8] ;
        int len;
        while((len = fis.read(arr))!= -1){
            fos.write(arr,0,len);
        }

        fis.close();
        fos.close();
    }
}
