package entity;

import java.util.Date;

/**
 * @ClassName HeartBeat
 * @Description TODO
 * @Auther tuantuan
 * @Date 2019/9/18 10:00
 * @Version 1.0
 * @Attention Copyright (C)，2004-2019，BDILab，XiDian University
 **/
public class HeartBeat extends Message {
    /**
     * 设备Guid
     */
    private String GUID = "DDD4031708-90382";
    /**
     * 时间
     */
    private long TIME = new Date().getTime();
    /**
     *门禁状态：0-关闭；1-开启,初始状态为关闭
     */
    private int GATE_STATUS = 0;

    public String getGUID() {
        return GUID;
    }

    public long getTIME() {
        return TIME;
    }

    public int getGATE_STATUS() {
        return GATE_STATUS;
    }

    public void setGUID(String GUID) {
        this.GUID = GUID;
    }

    public void setTIME(long TIME) {
        this.TIME = TIME;
    }

    public void setGATE_STATUS(int GATE_STATUS) {
        this.GATE_STATUS = GATE_STATUS;
    }

}
