package com.hxyc.stream;

import java.io.*;

/**
 * @ClassName TestBuffer
 * @Description TODO
 * @Author admin
 * A:缓冲思想
 * 字节流一次读写一个数组的速度明显比一次读写一个字节的速度快很多，
 * 这是加入了数组这样的缓冲区效果，java本身在设计的时候，
 * 也考虑到了这样的设计思想(装饰设计模式后面讲解)，所以提供了字节缓冲区流
 * B.BufferedInputStream
 * BufferedInputStream内置了一个缓冲区(数组)
 * 从BufferedInputStream中读取一个字节时
 * BufferedInputStream会一次性从文件中读取8192个, 存在缓冲区中, 返回给程序一个
 * 程序再次读取时, 就不用找文件了, 直接从缓冲区中获取
 * 直到缓冲区中所有的都被使用过, 才重新从文件中读取8192个
 * C.BufferedOutputStream
 * BufferedOutputStream也内置了一个缓冲区(数组)
 * 程序向流中写出字节时, 不会直接写到文件, 先写到缓冲区中
 * D.小数组的读写和带Buffered的读取哪个更快?
 * 定义小数组如果是8192个字节大小和Buffered比较的话
 * 定义小数组会略胜一筹,因为读和写操作的是同一个数组
 * 而Buffered操作的是两个数组
 * flush和close方法的区别：
 * flush()方法
 * 用来刷新缓冲区的,刷新后可以再次写出
 * close()方法
 * 用来关闭流释放资源的的,如果是带缓冲区的流对象的close()方法,不但会关闭流,还会再关闭流之前刷新缓冲区,关闭后不能再写出
 *
 * @Date 2020/1/8 21:41
 **/
public class TestBuffer {

    public static void main(String[] args) throws IOException {
        //创建流对象
        FileInputStream fis = new FileInputStream("xxx.txt");
        FileOutputStream fos = new FileOutputStream("yyy.txt");
        //创建缓冲区对象，对输入流进行包装让其变得更加强大
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        int b;

        while((b=bis.read())!= -1){
            bos.write(b);
        }
        bis.close();
        bos.close();
    }
}
