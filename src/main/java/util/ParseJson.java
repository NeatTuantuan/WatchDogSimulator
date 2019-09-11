package util;


import entity.Status;
import jdk.net.SocketFlow;
import net.sf.json.JSONObject;

/**
 * @ClassName ParseJson
 * @Description TODO
 * @Auther tuantuan
 * @Date 2019/9/10 17:48
 * @Version 1.0
 * @Attention Copyright (C)，2004-2019，BDILab，XiDian University
 **/
public class ParseJson {
    /**
     * 对象转换字符串
     * @param obj
     * @return
     */
    public String Object2Json(Object obj){
        JSONObject json;
        json = JSONObject.fromObject(obj);

        return json.toString();
    }

    /**
     * 对象json转字节数组
     * @param obj
     * @return
     */
    public byte[] Object2Bytes(Object obj){
        JSONObject json;
        json = JSONObject.fromObject(obj);

        return json.toString().getBytes();
    }
}
