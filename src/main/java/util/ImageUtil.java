package util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * @ClassName ImageUtil
 * @Description TODO
 * @Auther tuantuan
 * @Date 2019/9/11 11:04
 * @Version 1.0
 * @Attention Copyright (C)，2004-2019，BDILab，XiDian University
 **/
public class ImageUtil {

    static BASE64Encoder encoder = new sun.misc.BASE64Encoder();
    static BASE64Decoder decoder = new sun.misc.BASE64Decoder();
    static PropertiesUtil propertiesUtil = new PropertiesUtil();

    /**
     * 图片转换为二进制流(byte数组)
     * @return
     */
    public byte[] getImageBinary() {
        File f = new File(propertiesUtil.getProperties("imagePath"));
        BufferedImage bi;
        try {
            bi = ImageIO.read(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "jpg", baos);  //经测试转换的图片是格式这里就什么格式，否则会失真
            byte[] bytes = baos.toByteArray();

//            return encoder.encodeBuffer(bytes).trim();
            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 图片转二进制流（字符串）
     * @return
     */
    public String getImageString() {
        File f = new File(propertiesUtil.getProperties("imagePath"));
        BufferedImage bi;
        try {
            bi = ImageIO.read(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "PNG", baos);
            byte[] bytes = baos.toByteArray();

            return encoder.encodeBuffer(bytes).trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 二进制流转图片(字符串)
     * @param base64String
     */
    public void base64StringToImage(String base64String) {
        try {
            byte[] bytes1 = decoder.decodeBuffer(base64String);

            ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);
            BufferedImage bi1 = ImageIO.read(bais);
            File w2 = new File(propertiesUtil.getProperties("imageFormatPath"));// 可以是jpg,png,gif格式
            ImageIO.write(bi1, "png", w2);// 不管输出什么格式图片，此处不需改动
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 二进制流转图片(byte数组)
     * @param bytes
     */
    public void byteToImage(byte[] bytes) {
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            BufferedImage bi1 = ImageIO.read(bais);
            File w2 = new File(propertiesUtil.getProperties("imageFormatPath"));
            ImageIO.write(bi1, "png", w2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
