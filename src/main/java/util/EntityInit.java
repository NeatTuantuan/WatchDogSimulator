package util;

import entity.*;

/**
 * @ClassName EntityInit
 * @Description TODO
 * @Auther tuantuan
 * @Date 2019/9/19 17:31
 * @Version 1.0
 * @Attention Copyright (C)，2004-2019，BDILab，XiDian University
 **/
public class EntityInit {
    HeartBeat heartBeat;
    PhotoUpload photoUpload;
    Record record;

    private int HeartBeatStatus = 0;

    private int entityType = -1;

    RadomUtil radomUtil = new RadomUtil();
    ImageUtil imageUtil = new ImageUtil();

    /**
     * 设置门禁状态
     * @param heartBeatStatus
     */
    public void setHeartBeatStatus(int heartBeatStatus) {
        HeartBeatStatus = heartBeatStatus;
    }

    public void setEntityType(int entityType) {
        this.entityType = entityType;
    }

    public EntityInit(){
    }
    /**
     * 设置创建信息类型，0为刷卡进门，1为拍照进门
     * @param entityType
     */
    public EntityInit(int entityType){
        this.entityType = entityType;
    }

    public Message getEnity(){
        if(this.entityType == 0){
            return recordInit();
        }
        return photoUploadInit();
    }



    public Message heartBeatInit(){
        heartBeat = new HeartBeat();
        heartBeat.setGATE_STATUS(HeartBeatStatus);
        return heartBeat;
    }

    public Message photoUploadInit(){
        photoUpload = new PhotoUpload();
        photoUpload.setUSER_TYPE(radomUtil.nextInt(2));
        photoUpload.setPHOTO_IMG(imageUtil.getImageBinary());
        return photoUpload;
    }

    public Message recordInit(){
        record = new Record();
        int openType = radomUtil.nextInt(2);
        if (openType == 1){
            System.out.println(openType);
            record.setOPEN_TYPE(1);
            record.setCARD_ID(null);
            record.setCARD_MATCH_USER(null);
            record.setPHOTO(new String("/usr/local/picture").getBytes());
        }else {
            System.out.println(openType);
            record.setCARD_ID(radomUtil.getIdCardRadom());
            record.setCARD_MATCH_USER(true);
            record.setPHOTO(new String("/usr/local/picture").getBytes());
        }
        return record;

    }
}
