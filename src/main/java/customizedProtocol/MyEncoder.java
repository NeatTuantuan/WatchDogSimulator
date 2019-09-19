package customizedProtocol;

import entity.PhotoUpload;
import entity.Status;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import util.ParseJson;

/**
 * @ClassName MyEncoder
 * @Description TODO
 * @Auther tuantuan
 * @Date 2019/9/11 19:54
 * @Version 1.0
 * @Attention Copyright (C)，2004-2019，BDILab，XiDian University
 **/
public class MyEncoder extends MessageToByteEncoder {

    ParseJson parseJson = new ParseJson();
    byte[] body = null;
    int dataType = -1;
    int dataLength = -1;

    /**
     * 自定义编码器，第一个字段存放数据长度，第二个字段存放数据类型，第三个字段存放数据
     * @param channelHandlerContext
     * @param o
     * @param byteBuf
     * @throws Exception
     */
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {
        System.out.println(o instanceof Status);
        if (o instanceof Status) {
            body = parseJson.Object2Bytes(o);
            dataType = 1;
            dataLength = body.length;
            writeToBuf(byteBuf,dataLength,dataType,body);
        }else if (o instanceof PhotoUpload){
            body = parseJson.Object2Bytes(o);
            dataType = 2;
            dataLength = body.length;
            writeToBuf(byteBuf,dataLength,dataType,body);
        }else {
            body = parseJson.Object2Bytes(o);
            dataType = 0;
            dataLength = body.length;
            writeToBuf(byteBuf,dataLength,dataType,body);
        }
    }

    protected void writeToBuf(ByteBuf byteBuf, int dataLength, int dataType, byte[] body){
        byteBuf.writeInt(dataLength);
        byteBuf.writeInt(dataType);
        byteBuf.writeBytes(body);
    }
}
