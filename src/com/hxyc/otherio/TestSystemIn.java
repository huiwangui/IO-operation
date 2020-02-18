package com.hxyc.otherio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @ClassName TestSystemIn
 * @Description TODO
 * 两种方式实现键盘录入：
 * A:BufferedReader的readLine方法。
 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 * B:Scanner
 * @Author admin
 * @Date 2020/1/15 10:12
 **/
public class TestSystemIn {
    public static void main(String[] args) throws IOException {
        //demo1();
        demo2();
    }
    /**
     * 实现键盘录入第二种方式(推荐使用该方式)：
     * B:Scanner
     * @throws IOException
     */
    private static void demo2() throws IOException {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        System.out.println(line);
    }
    /**
     * 实现键盘录入第一种方式：
     * A:BufferedReader的readLine方法。
     * @throws IOException
     */
    private static void demo1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        System.out.println(line);
    }

}
