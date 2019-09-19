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
    Status status;

    RadomUtil radomUtil = new RadomUtil();
    ImageUtil imageUtil = new ImageUtil();
    public Message heartBeatInit(){
            heartBeat = new HeartBeat();
            //设置门禁状态
//            heartBeat.setGATE_STATUS(0);
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
        int temp = radomUtil.nextInt(2);
        if (temp == 1){
            record.setCARD_ID(null);
            record.setCARD_MATCH_USER(null);
        }else {
            record.setCARD_ID(radomUtil.getIdCardRadom());
            record.setCARD_MATCH_USER(true);
        }
        return record;

    }

    public Message statusInit(){
        status = new Status();
        status.setDOOR_STATUS(radomUtil.nextInt(2));
        return status;
    }
}
