package com.hxyc.stream;

import java.io.*;

/**
 * @ClassName TestImageEncryptionAndDecrypt
 * @Description TODO  图片加密
 * 将写出的字节异或上一个数，这个数就是密钥，解密的时候再次异或就可以了
 * @Author admin
 * @Date 2020/1/10 11:25
 **/
public class TestImageEncryptionAndDecrypt {
    public static void main(String[] args) throws IOException {
        //demo1();
        demo2();

    }

    /**
     * 图片加密
     * @throws IOException
     */
    private static void demo1() throws IOException {
        //创建流对象
        FileInputStream fis = new FileInputStream("美景.jpg");
        FileOutputStream fos = new FileOutputStream("copy.jpg");
        //创建缓冲区对象，对输入流进行包装让其变得更加强大
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        int b;

        while((b=bis.read())!= -1){
            bos.write(b ^ 123); // 这里的图片加密方式：异或处理
        }
        bis.close();
        bos.close();
    }
    /**
     * 图片解密
     * 一个数与另一个数异或二次等于它本身
     * @throws IOException
     */
    private static void demo2() throws IOException {
        //创建流对象
        FileInputStream fis = new FileInputStream("copy.jpg");
        FileOutputStream fos = new FileOutputStream("copy2.jpg");
        //创建缓冲区对象，对输入流进行包装让其变得更加强大
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        int b;

        while((b=bis.read())!= -1){
            bos.write(b ^ 123); // 这里的图片解密：异或处理
        }
        bis.close();
        bos.close();
    }

}
