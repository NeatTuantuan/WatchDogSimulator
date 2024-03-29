package entity;

import util.RadomUtil;

import java.util.Date;

/**
 * @ClassName Record
 * @Description TODO
 * @Auther tuantuan
 * @Date 2019/9/10 11:26
 * @Version 1.0
 * @Attention Copyright (C)，2004-2019，BDILab，XiDian University
 **/
public class Record extends Message {
    /**
     * 令牌
     */
    private String TOKEN = "770fed4ca2aabd20ae9a5dd774711de2";
    /**
     * 设备Guid
     */
    private String GUID = "DDD4031708-90382";
    /**
     * 开门时间
     */
    private long OPEN_TIME = new Date().getTime();
    /**
     * 开门方式（0：门禁卡，1:人像）
     */
    private int OPEN_TYPE = 0;
    /**
     * 门禁卡ID
     */
    private String CARD_ID = "190271";
    /**
     * 人卡是否一致（true:一致，false：不一致）
     */
    private Boolean CARD_MATCH_USER = false;
    /**
     * 开门时人像照片
     */
    private byte[] PHOTO;

//    public Record(byte[] PHOTO) {
//        this.PHOTO = PHOTO;
//    }

    public String getTOKEN() {
        return TOKEN;
    }

    public String getGUID() {
        return GUID;
    }

    public long getOPEN_TIME() {
        return OPEN_TIME;
    }

    public int getOPEN_TYPE() {
        return OPEN_TYPE;
    }

    public String getCARD_ID() {
        return CARD_ID;
    }

    public Boolean getCARD_MATCH_USER() {
        return CARD_MATCH_USER;
    }

    public byte[] getPHOTO() {
        return PHOTO;
    }

    public void setTOKEN(String TOKEN) {
        this.TOKEN = TOKEN;
    }

    public void setGUID(String GUID) {
        this.GUID = GUID;
    }

    public void setOPEN_TIME(long OPEN_TIME) {
        this.OPEN_TIME = OPEN_TIME;
    }

    public void setOPEN_TYPE(int OPEN_TYPE) {
        this.OPEN_TYPE = OPEN_TYPE;
    }

    public void setCARD_ID(String CARD_ID) {
        this.CARD_ID = CARD_ID;
    }

    public void setCARD_MATCH_USER(Boolean CARD_MATCH_USER) {
        this.CARD_MATCH_USER = CARD_MATCH_USER;
    }

    public void setPHOTO(byte[] PHOTO) {
        this.PHOTO = PHOTO;
    }


}
