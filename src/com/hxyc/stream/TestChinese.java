package com.hxyc.stream;

import java.io.*;

/**
 * @ClassName TestChinese
 * @Description TODO
 * @Author admin
 * @Date 2020/1/8 22:26
 **/
public class TestChinese {

    public static void main(String[] args) throws IOException {
        //demo1();
        demo2();

    }

    /**
     * 字节流写出中文的问题
     * 字节流直接操作的字节,所以写出中文必须将字符串转换成字节数组
     * 写出回车换行 write("\r\n".getBytes());
     * @throws IOException
     */
    private static void demo2() throws IOException {
        FileOutputStream fos = new FileOutputStream("zzz.txt");
        fos.write("我读书少，你不要骗我".getBytes());
        fos.write("\r\n".getBytes());
        fos.close();
    }

    /**
     * 字节流读取中文的问题
     * 字节流在读中文的时候有可能会读到半个中文,造成乱码
     * @throws IOException
     */
    private static void demo1() throws IOException {
        //创建流对象
        FileInputStream fis = new FileInputStream("xy.txt");

        byte[] arr = new byte[2] ;
        int len;
        while((len = fis.read(arr))!= -1){
            System.out.println(new String(arr,0,len));
        }
        fis.close();
    }
}
