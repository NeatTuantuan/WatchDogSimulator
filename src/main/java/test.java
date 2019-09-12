import entity.Record;
import util.ImageUtil;
import util.ParseJson;

import java.util.Random;

/**
 * @ClassName test
 * @Description TODO
 * @Auther tuantuan
 * @Date 2019/9/11 19:28
 * @Version 1.0
 * @Attention Copyright (C)，2004-2019，BDILab，XiDian University
 **/
public class test extends Random{
    public static void main(String[] args){
        ParseJson parseJson = new ParseJson();
        ImageUtil imageUtil = new ImageUtil();
        System.out.println(parseJson.Object2Json(new Record(imageUtil.getImageBinary())));
    }
}
