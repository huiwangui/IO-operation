package com.hxyc.otherio;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

/**
 * @ClassName TestSequenceInputStream
 * @Description TODO
 * 什么是序列流
 * 序列流可以把多个字节输入流整合成一个, 从序列流中读取数据时, 将从被整合的第一个流开始读, 读完一个之后继续读第二个, 以此类推.
 * @Author admin
 * @Date 2020/1/13 20:05
 **/
public class TestSequenceInputStream {
    public static void main(String[] args) throws IOException {
        //demo1();
        demo2();
    }

    /**
     * 序列流整合多个字节输入流
     * @throws IOException
     */
    private static void demo2() throws IOException {
        FileInputStream fis1 = new FileInputStream("a.txt");
        FileInputStream fis2 = new FileInputStream("b.txt");
        FileInputStream fis3 = new FileInputStream("c.txt");

        Vector<FileInputStream> v = new Vector<>();   //创建集合对象
        v.add(fis1);
        v.add(fis2);
        v.add(fis3);

        Enumeration<FileInputStream> en = v.elements();
        SequenceInputStream sis = new SequenceInputStream(en);
        FileOutputStream fos = new FileOutputStream("d.txt");

        int b;
        while((b = sis.read()) != -1){
            fos.write(b);
        }

        sis.close();
        fos.close();
    }
    /**
     * 序列流整合二个字节输入流
     * @throws IOException
     */
    private static void demo1() throws IOException {
        FileInputStream fis1 = new FileInputStream("a.txt");
        FileInputStream fis2 = new FileInputStream("b.txt");
        SequenceInputStream sis = new SequenceInputStream(fis1, fis2);
        FileOutputStream fos = new FileOutputStream("c.txt");

        int b;
        while((b = sis.read()) != -1){
            fos.write(b);
        }

        sis.close();
        fos.close();
    }
}
