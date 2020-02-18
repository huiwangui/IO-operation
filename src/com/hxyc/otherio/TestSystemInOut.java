package com.hxyc.otherio;

import java.io.*;

/**
 * @ClassName TestSystemInOut
 * @Description TODO
 * 1.什么是标准输入输出流(掌握)
 * System.in是InputStream, 标准输入流, 默认可以从键盘输入读取字节数据
 * System.out是PrintStream, 标准输出流, 默认可以向Console中输出字符和字节数据
 * 2.修改标准输入输出流(了解)
 * 修改输入流: System.setIn(InputStream)
 * 修改输出流: System.setOut(PrintStream)
 * @Author admin
 * @Date 2020/1/14 21:13
 **/
public class TestSystemInOut {
    public static void main(String[] args) throws IOException {
        //demo1();
        demo2();
    }

    /**
     * 修改标准输入输出流拷贝图片
     * @throws IOException
     */
    private static void demo2() throws IOException {
        System.setIn(new FileInputStream("美景.jpg"));
        System.setOut(new PrintStream("copy1.jpg"));

        InputStream is = System.in;
        PrintStream ps = System.out;

        int b;
        byte[] arr = new byte[1024*8];
        while((b = is.read(arr)) != -1){
            ps.write(arr,0,b);
        }

        is.close();
        ps.close();
    }

    private static void demo1() throws IOException {
        System.setIn(new FileInputStream("a.txt"));   //改变标准输入流，默认指向键盘，改变后指向文件
        System.setOut(new PrintStream("b.txt"));    //改变标准输出流，默认指向控制台，改变后指向文件

        InputStream is = System.in;
        PrintStream ps = System.out;

        int b;
        while((b = is.read()) != -1){
            ps.write(b);
        }

        is.close();
        ps.close();
    }
}
