package com.shopping.demo;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author :tianfeng
 * @Date : 2020/12/21 16:50
 * @Description:
 */
public class CsairJiaMiTest {

    public static final String KEY_SHA = "SHA";

    public static void main(String args[]) {
        try {
            SimpleDateFormat sd=new SimpleDateFormat("yyyyMMdd");
            // 产生秘钥，根据ID:南航分配，日期20170828，私钥：_南航分配的私钥，组合而成
            String key = "XXXXXX_"+sd.format((new Date()))+"_XXXXX";
            String keyword = encrypt(key);// 加密后得到echotoken节点的值传给服务器
            System.out.println("this is my ECHOTOKEN:"+keyword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String inputStr) {
        BigInteger sha = null;
        // System.out.println("=======加密前的数据:"+inputStr);
        byte[] inputData = inputStr.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA);
            messageDigest.update(inputData);
            sha = new BigInteger(messageDigest.digest());
            // System.out.println("SHA加密后:" + sha.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sha.toString();
    }

}
