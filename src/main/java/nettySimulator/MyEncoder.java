package nettySimulator;

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

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {
        byte[] body =  parseJson.Object2Bytes(o);
        int dataLength = body.length;
        byteBuf.writeInt(dataLength);
        byteBuf.writeBytes(body);
    }
}
