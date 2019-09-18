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
    private int GUID = 9527;
    /**
     * 时间
     */
    private long TIME = new Date().getTime();
    /**
     *门禁状态：0-关闭；1-开启
     */
    private int GATE_STATUS;
}
