package com.hxyc.otherio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @ClassName TestProperties
 * @Description TODO
 * Properties的概述
 * Properties 类表示了一个持久的属性集。
 * Properties 可保存在流中或从流中加载。
 * 属性列表中每个键及其对应值都是一个字符串。
 * @Author admin
 * @Date 2020/1/15 14:17
 **/
public class TestProperties {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("config.properties"));  //将文件上的键值对读取到集合中
        prop.setProperty("tel","12345678130");
        //第二个参数是对列表参数的描述，可以给值，也可以给null
        prop.store(new FileOutputStream("config.properties"),null);
        System.out.println(prop);
    }
}
