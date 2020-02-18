package com.hxyc.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName TestFileOutputStream
 * @Description TODO
 * @Author admin
 * @Date 2020/1/6 22:09
 **/
public class TestFileOutputStream {
    public static void main(String[] args) throws IOException {
        //demo1();
        FileOutputStream fos = new FileOutputStream("yyy.txt",true);//如果想续写就在第二个参数传入true
        fos.write(97);
        fos.write(98);
        fos.write(99);
        fos.close();

    }

    private static void demo1() throws IOException {
        //创建字节输出流对象，如果没有yyy.txt这个文件就自动创建一个，这里只有一个参数表示有这个文件就会先把文件清空
        FileOutputStream fos = new FileOutputStream("yyy.txt");
        fos.write(97);						//虽然写出的是一个int数,但是在写出的时候会将前面的24个0去掉,所以写出的一个byte
        fos.write(98);
        fos.write(99);
        fos.close();
    }

}
