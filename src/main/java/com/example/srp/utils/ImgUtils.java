package com.example.srp.utils;

import org.junit.Test;

import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

public class ImgUtils {

    public static final String SAVEURL = "img/";

    public static byte[] imgToBytes(String filename) {
        FileImageInputStream imageIs = null;
        ByteArrayOutputStream byteArrayOs = null;
        String saveUrl = SAVEURL + filename;
        try {
            imageIs = new FileImageInputStream(new File(saveUrl));
            byteArrayOs = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int readcnt = 0;
            while((readcnt = imageIs.read(buffer)) != -1) {
                byteArrayOs.write(buffer, 0, readcnt);
            }
            return byteArrayOs.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(imageIs != null) {
                try {
                    imageIs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(byteArrayOs != null) {
                try {
                    byteArrayOs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static String saveImg(byte[] bytes) {
        String date = TimeUtils.DateToString(new Date(System.currentTimeMillis()));
        String fileName = UUID.randomUUID()+".jpeg";
        String savePath = "/" + date +  "/" + fileName;
        String dir = SAVEURL + '/' + date;
        String saveUrl = SAVEURL + '/' + savePath;
        File file = new File(dir);
        if(!file.exists()){
            file.mkdirs();
        }
        bytesToImg(bytes, saveUrl);
        return savePath;
    }

    public static Boolean bytesToImg(byte[] bytes, String saveUrl){
        FileImageOutputStream imageOs = null;
        try {
            imageOs = new FileImageOutputStream(new File(saveUrl));
            imageOs.write(bytes);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(imageOs != null) {
                try {
                    imageOs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }


    public static byte[]  getBytesByStream(InputStream inputStream){
        byte[] bytes = new byte[1024];

        int b;
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        try {
//            while((b = inputStream.read(bytes)) != -1){
//
//                byteArrayOutputStream.write(bytes,0,b);
//            }
//            return byteArrayOutputStream.toByteArray();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return null;
    }

//    @Test
//    public void testImgToBytes() {
//        byte[] bytes = imgToBytes("1.PNG");
//        String ret = new String(bytes);
//        System.out.println(bytes.length);
//        System.out.println(ret.length());
//
//        System.out.println(bytesToImg(bytes, "2.PNG"));
//    }
}
