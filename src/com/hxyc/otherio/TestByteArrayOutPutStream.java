package com.hxyc.otherio;

import java.io.*;

/**
 * @ClassName TestByteArrayOutPutStream
 * @Description TODO
 * 什么是内存输出流
 * 该输出流可以向内存中写数据, 把内存当作一个缓冲区, 写出之后可以一次性获取出所有数据
 * @Author admin
 * @Date 2020/1/13 21:46
 **/
public class TestByteArrayOutPutStream {
    public static void main(String[] args) throws IOException {
        //demo1();
        //demo2();
        demo3();


    }

    /**
     * 定义一个文件输入流,调用read(byte[] b)方法,将a.txt文件中的内容打印出来(byte数组大小限制为5)
     *
     * 分析：
     * 1、read(byte[] b)是字节输入流的方法，创建FileInputStream,关联a.txt
     * 2、创建内存输出流，将读到的数据写到内存输出流中
     * 3、创建字节数组，长度为5
     * 4、将内存输出流的数据全部转换为字符串打印
     * 5、关闭输入流
     */
    private static void demo3() throws IOException {
       // 1、read(byte[] b)是字节输入流的方法，创建FileInputStream,关联a.txt
        FileInputStream fis = new FileInputStream("a.txt");

        // 2、创建内存输出流，将读到的数据写到内存输出流中
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // 3、创建字节数组，长度为5
        byte[] arr = new byte[5];
        int len;

        while((len = fis.read(arr)) != -1){
            baos.write(arr,0,len);
        }
        // 4、将内存输出流的数据全部转换为字符串打印
        System.out.println(baos);
        // 5、关闭输入流
        fis.close();

    }

    /**
     * ByteArrayOutputStream 解决读取中文乱码问题
     * @throws IOException
     */
    private static void demo2() throws IOException {
        //创建输入流对象
        FileInputStream fis = new FileInputStream("e.txt");

        ByteArrayOutputStream baos = new ByteArrayOutputStream(); //在内存中创建了可以增长的字节数组


        int b;

        while((b=fis.read())!= -1){
          baos.write(b);                    //将读取到的数据逐个写到内存中
        }

        byte[] arr = baos.toByteArray();  //将缓冲区的数据全部获取出来，并赋值给arr数组
        System.out.println(new String(arr));

        fis.close();
    }

    /**
     * FileInputStream读取中文的时候出现了乱码
     *
     * 解决方案：
     * 1、字符流读取
     * 2、ByteArrayOutputStream
     * @throws IOException
     */
    private static void demo1() throws IOException {
        //创建输入流对象
        FileInputStream fis = new FileInputStream("e.txt");
        byte[] arr = new byte[3];

        int b;

        while((b=fis.read(arr))!= -1){

            System.out.println(new String(arr,0,b));
        }
        fis.close();
    }
}
