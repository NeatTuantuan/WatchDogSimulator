package entity;

import util.RadomUtil;

import java.util.Date;

/**
 * @ClassName Status
 * @Description TODO
 * @Auther tuantuan
 * @Date 2019/9/10 17:23
 * @Version 1.0
 * @Attention Copyright (C)，2004-2019，BDILab，XiDian University
 **/
public class Status extends Message {
    RadomUtil random = new RadomUtil();

    /**
     * 令牌
     */
    private String TOKEN = "770fed4ca2aabd20ae9a5dd774711de2";
    /**
     * 设备Guid
     */
    private int GUID = 9527;
    /**
     * 时间
     */
    private long TIME = new Date().getTime();
    /**
     *开关门状态（0：开门，1：关门）
     */
    private int DOOR_STATUS = random.nextInt(2);

    public String getTOKEN() {
        return TOKEN;
    }

    public int getGUID() {
        return GUID;
    }

    public long getTIME() {
        return TIME;
    }

    public int getDOOR_STATUS() {
        return DOOR_STATUS;
    }

    public void setTOKEN(String TOKEN) {
        this.TOKEN = TOKEN;
    }

    public void setGUID(int GUID) {
        this.GUID = GUID;
    }

    public void setTIME(long TIME) {
        this.TIME = TIME;
    }

    public void setDOOR_STATUS(int DOOR_STATUS) {
        this.DOOR_STATUS = DOOR_STATUS;
    }


}
