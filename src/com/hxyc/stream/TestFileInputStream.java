package com.hxyc.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @ClassName FileInputStream
 * @Description TODO 测试字节的输入流到文件上读取数据
 * @Author admin
 * @Date 2020/1/6 21:35
 **/
public class TestFileInputStream {
    
    public static void main(String[] args) throws IOException {
        //创建流对象
        FileInputStream fis = new FileInputStream("xxx.txt");
        //从硬盘上读取一个字节
        int b;
        //这样写是因为文件的结束标记是-1
        while((b=fis.read())!= -1){
            System.out.println(b);
        }
        fis.close();
    }
}
