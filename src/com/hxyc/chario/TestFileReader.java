package com.hxyc.chario;

import java.io.*;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * @ClassName TestFileReader
 * @Description TODO
 * @Author admin
 * @Date 2020/1/11 16:11
 **/
public class TestFileReader {
    public static void main(String[] args) throws IOException {
       // demo1();

       // demo2();

       // demo3();
        //demo4();
        //demo5();
        //demo6();
       // demo7();

       // demo8();
        //demo9();
       // demo10();
       //demo11();
       demo12();

    }

    /**
     * 递归：方法自己调用自己
     * 递归的弊端：自己调用自己太多易造成栈内存溢出
     * 递归的好处：不用知道循环次数
     *
     * 构造方法是否可以递归调用？构造方法不能使用递归调用
     *
     * 递归调用是否必须要有返回值？不一定（可以有，也可以没有）
     *
     */
    private static void demo12(){
        System.out.println(fun(5));
    }

    private static int fun(int num){
        if(num ==1){
            return 1;
        }else{
            return num * fun(num-1);
        }
    }

    /**
     * 当我们下载一个试用版软件,没有购买正版的时候,每执行一次就会提醒我们还有多少次使用机会用学过的IO流知识,模拟试用版软件,
     * 试用10次机会,执行一次就提示一次您还有几次机会,如果次数到了提示请购买正版
     *
     * 分析：
     * 1、创建带缓冲的输入流对象，因为要使用readLine方法，可以保证数据的原样性
     * 2、将读到的字符串转换为int数
     * 3、对int数进行判断，如果大于0，就将其--写回去，如果不大于0，就提示请购买正版
     * 4、在if判断中要将--的结果打印，并将结果通过输出流写到文件上
     * @throws IOException
     */
    private static void demo11() throws IOException {
        //1、创建带缓冲的输入流对象，因为要使用readLine方法，可以保证数据的原样性
        BufferedReader br = new BufferedReader(new FileReader("config.txt"));
        //FileWriter fw = new FileWriter("config.txt");//这句会把config.txt文件中的内容清空故而不能写在这里
        //2、将读到的字符串转换为int数
        String line = br.readLine();
        br.close();
        int times = Integer.parseInt(line);

        //3、对int数进行判断，如果大于0，就将其--写回去，如果不大于0，就提示请购买正版
        if(times>0){
            //4、在if判断中要将--的结果打印，并将结果通过输出流写到文件上
            System.out.println("你还有"+ times-- +"次机会");
            FileWriter fw = new FileWriter("config.txt");

            fw.write(times+"");
            fw.close();
        }else{
            System.out.println("你的试用次数已到，请购买正版");
        }

    }

    /**
     * 获取一个文本上每个字符出现的次数,将结果写在times.txt上
     *
     * 分析：
     * 1、创建带缓冲的输入流对象
     * 2、创建双列集合对象 treemap
     * 3、将读到的字符存储在双列集合中，存储的时候要做判断，如果不包含这个健，就将这个健和1存储，如果包含这个健，就将该健和值加一存储
     * 4、关闭输入流
     * 5、创建输出流对象
     * 6、遍历集合将集合中的内容写到times.txt上
     * 7、关闭输出流
     *
     * @throws IOException
     */
    private static void demo10() throws IOException {
        //1、创建带缓冲的输入流对象
        BufferedReader br = new BufferedReader(new FileReader("zzz.txt"));
        //2、创建双列集合对象 treemap
        TreeMap<Character, Integer> tm = new TreeMap<>();
        //3、将读到的字符存储在双列集合中，存储的时候要做判断，如果不包含这个健，就将这个健和1存储，如果包含这个健，就将该健和值加一存储
        int ch;

        while((ch = br.read()) != -1){
            char c = (char)ch;
            tm.put(c, !tm.containsKey(c) ? 1 : tm.get(c) +1);
        }
        //4、关闭输入流
        br.close();

        //5、创建输出流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("times.txt"));
        //6、遍历集合将集合中的内容写到times.txt上
        for (Character key : tm.keySet()){
            switch (key){
                case '\t':
                    bw.write("\\t" + " = "+tm.get(key));
                    break;
                case '\n':
                    bw.write("\\n" + " = "+tm.get(key));
                    break;
                case '\r':
                    bw.write("\\r" + " = "+tm.get(key));
                    break;
                default:
                    bw.write(key + " = "+tm.get(key));
                    break;
            }
            bw.newLine();
        }
        //7、关闭输出流
        bw.close();
    }

    /**
     * LineNumberReader
     * 获取及设置行号
     * @throws IOException
     */
    private static void demo9() throws IOException {
        LineNumberReader lnr = new LineNumberReader(new FileReader("zzz.txt"));

        String line;

        lnr.setLineNumber(100);
        while((line = lnr.readLine())!= null){
            System.out.println( lnr.getLineNumber() +":"+line);
        }

        lnr.close();
    }

    /**
     * 将一个文本文档上的文本反转,第一行和倒数第一行交换,第二行和倒数第二行交换
     *
     * 分析：
     * 1、创建输入输出流对象
     * 2、创建集合对象
     * 3、将读到的数据存储在集合中
     * 4、倒着遍历集合将数据写到文件上
     * 5、关流
     *
     * 注意事项：
     * 流对象尽量晚开早关
     * @throws IOException
     */
    private static void demo8() throws IOException {
        //1、创建输入输出流对象
        BufferedReader br = new BufferedReader(new FileReader("zzz.txt"));

       // 2、创建集合对象
        ArrayList<String> list = new ArrayList<>();
        String line;
        while((line =br.readLine())!= null){
            list.add(line);

        }
        br.close();
        //
        BufferedWriter bw = new BufferedWriter(new FileWriter("revzzz.txt"));
        //4、倒着遍历集合将数据写到文件上
        for (int i = list.size()-1; i >= 0; i--) {
            bw.write(list.get(i));
            bw.newLine();  //写出回车换行符

        }
        //5、关流

        bw.close();
    }

    /**
     * readLine()和newLine()方法
     * BufferedReader的readLine()方法可以读取一行字符(不包含换行符号)
     * BufferedWriter的newLine()可以输出一个跨平台的换行符号"\r\n"
     *
     * newLine()与\r\n的区别
     * newLine() 是跨平台的方法
     * \r\n 只支持的是windows系统
     * @throws IOException
     */
    private static void demo7() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("xxx.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("zzz.txt"));

        String line;
        while((line =br.readLine())!= null){
            bw.write(line);
            bw.newLine();  //写出回车换行符
            //bw.write("\r\n");
        }

        br.close();
        bw.close();
    }

    /**
     *带缓冲的字符流
     *BufferedReader的read()方法读取字符时会一次读取若干字符到缓冲区, 然后逐个返回给程序, 降低读取文件的次数, 提高效率
     *BufferedWriter的write()方法写出字符时会先写到缓冲区, 缓冲区写满时才会写到文件, 降低写文件的次数, 提高效率
     * @throws IOException
     */
    private static void demo6() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("xxx.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("zzz.txt"));

        int b;
        while((b =br.read())!=-1){
            bw.write(b);
        }

        br.close();
        bw.close();
    }

    /**
     * 自定义字符数组的拷贝
     * @throws IOException
     */
    private static void demo5() throws IOException {
        FileReader fr = new FileReader("xxx.txt");
        FileWriter fw = new FileWriter("zzz.txt");

        int b;
        char[] arr = new char[1024*8];						//创建字符数组
        while((b =fr.read(arr))!=-1){
            fw.write(arr,0,b);
        }

        fr.close();
        fw.close();
    }
    /**
     * 字符流是否可以拷贝非纯文本的文件
     * 不可以拷贝非纯文本的文件
     * 因为在读的时候会将字节转换为字符,在转换过程中,可能找不到对应的字符,就会用?代替,写出的时候会将字符转换成字节写出去
     * 如果是?,直接写出,这样写出之后的文件就乱了,看不了了
     * @throws IOException
     */
    private static void demo4() throws IOException {
        FileReader fr = new FileReader("美景.jpg");
        FileWriter fw = new FileWriter("copy3.jpg");

        int b;
        while((b =fr.read())!=-1){
            fw.write(b);
        }

        fr.close();
        fw.close();
    }

    /**
     *  字符流的拷贝
     * @throws IOException
     */
    private static void demo3() throws IOException {
        FileReader fr = new FileReader("xxx.txt");
        FileWriter fw = new FileWriter("zzz.txt");

        int b;
        while((b =fr.read())!=-1){
            fw.write(b);
        }

        fr.close();
        fw.close();  //Writer类中有一个2k的小缓冲区，如果不关流，就会把内容写到缓冲区里，关流会将缓冲区内的内容刷新，再关闭
    }

    /**
     * 字符流的输出流
     * @throws IOException
     */
    private static void demo2() throws IOException {
        FileWriter fw = new FileWriter("yyy.txt");
        fw.write("华西集采");
        fw.close();
    }

    /**
     * 字符流的输入流
     * @throws IOException
     */
    private static void demo1() throws IOException {
        FileReader fr = new FileReader("xxx.txt");

        int b;
        while((b =fr.read())!=-1){    //通过项目默认的码表一次读取一个字符
            System.out.print((char)b);
        }

        fr.close();
    }
}
