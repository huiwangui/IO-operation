package com.hxyc.otherio;

import com.hxyc.bean.Person;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.*;

/**
 * @ClassName TestObjectOutputStream
 * @Description TODO
 *
 * 什么是对象操作流
 * 该流可以将一个对象写出, 或者读取一个对象到程序中. 也就是执行了序列化和反序列化的操作.
 * @Author admin
 * @Date 2020/1/14 15:10
 **/
public class TestObjectOutputStream {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
            //demo1();
            demo2();
    }
    /**
     * 对象输入流：反序列化
     */
    private static void demo2() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("e.txt"));
        Person p1 = (Person) ois.readObject();
        Person p2 = (Person) ois.readObject();

        System.out.println(p1);
        System.out.println(p2);
        ois.close();
    }

    /**
     * 序列化：将对象写到文件上
     */
    private static void demo1() throws IOException {
        Person p1 = new Person("张三", 23);
        Person p2 = new Person("李四", 24);

        //无论是字节输出流,还是字符输出流都不能直接写出对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("e.txt"));//创建对象输出流
        oos.writeObject(p1);
        oos.writeObject(p2);
        oos.close();
    }
}
