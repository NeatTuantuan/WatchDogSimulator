import entity.Record;
import org.omg.PortableInterceptor.INACTIVE;
import util.EntityInit;
import util.ImageUtil;
import util.ParseJson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Stack;

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
//        String s = "-2147483649";
//        char[] temp = s.toCharArray();
//        int symbol =1;
//
//        if (temp[0] == 43){
//            System.out.println(count(1,temp,symbol));
//        }else if (temp[0] == 45){
//            symbol = -1;
//            System.out.println(-count(1,temp,symbol));
//        }

        System.out.println("".length());

    }

    public static int count(int i, char[] temp,int symbol){
        int result = 0;

        for (; i < temp.length ; i++){
            if ((int)temp[i] >= 48 && (int)temp[i] <= 57){
                result  = result*10 + (temp[i]-'0');
            }else {
                return 0;
            }
            if ((symbol == 1 && result > Integer.MAX_VALUE) || (symbol == -1 && result < Integer.MIN_VALUE)) {
                return 0;
            }
        }

        return result;
    }


}
