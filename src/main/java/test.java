import util.ImageUtil;

/**
 * @ClassName test
 * @Description TODO
 * @Auther tuantuan
 * @Date 2019/9/11 19:28
 * @Version 1.0
 * @Attention Copyright (C)，2004-2019，BDILab，XiDian University
 **/
public class test {
    public static void main(String[] args){
        ImageUtil imageUtil = new ImageUtil();
        System.out.println(imageUtil.getImageString());
        imageUtil.base64StringToImage(imageUtil.getImageString());
    }
}
