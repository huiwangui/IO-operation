package com.hxyc.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName TestTryFinally
 * @Description TODO
 * @Author admin
 * @Date 2020/1/9 22:19
 **/
public class TestTryFinally {
    public static void main(String[] args) throws IOException {
        //demo1();
        demo2();
    }

    /**
     * 1.7版本 流的标准处理异常代码
     * 原理
     * 在try()中创建的流对象必须实现了AutoCloseable这个接口,如果实现了,在try后面的{}(读写代码)执行后就会自动调用,流对象的close方法将流关掉
     * @throws IOException
     */
    private static void demo2() throws IOException {
        try(
            //()小括号里写的是流对象；实现了AutoCloseable这个接口
            FileInputStream fis = new FileInputStream("xxx.txt");
            FileOutputStream fos = new FileOutputStream("yyy.txt");
        ){
            int b;
            while((b = fis.read()) != -1) {
                fos.write(b);
            }
        }
    }

    /**
     * 1.6版本及其以前 流的标准处理异常代码
     * @throws IOException
     */
    private static void demo1() throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("xxx.txt");
            fos = new FileOutputStream("yyy.txt");
            int b;
            while((b = fis.read()) != -1) {
                fos.write(b);
            }
        } finally {
            try {
                if(fis != null)
                    fis.close();
            }finally {                   // try finally嵌套的目的是能关一个尽量关一个
                if(fos != null)
                    fos.close();
            }
        }
    }
}
