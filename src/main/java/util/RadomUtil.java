package util;

import java.util.Random;

/**
 * @ClassName RadomUtil
 * @Description TODO
 * @Auther tuantuan
 * @Date 2019/9/12 19:06
 * @Version 1.0
 * @Attention Copyright (C)，2004-2019，BDILab，XiDian University
 **/
public class RadomUtil extends Random {
    public int nextInt(int bound){
        return super.nextInt(bound);
    }

    public String getIdCardRadom(){
        int IdList[] = {190271,190272,190273,190273,190274,190275,190276,190277,190278,190279,190280};
        return Integer.toString(IdList[super.nextInt(IdList.length)]);
    }
}
