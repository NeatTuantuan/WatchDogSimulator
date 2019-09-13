package nettySimulator;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @ClassName nettySimulator.MyDecoder
 * @Description TODO
 * @Auther tuantuan
 * @Date 2019/9/11 10:06
 * @Version 1.0
 * @Attention Copyright (C)，2004-2019，BDILab，XiDian University
 **/
public class MyDecoder extends ByteToMessageDecoder {
    /**
     * 自定义解码器
     * @param channelHandlerContext
     * @param byteBuf
     * @param list
     * @throws Exception
     */
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (byteBuf.readableBytes() < 4) {
            return;
        }
        byteBuf.markReaderIndex();//标记当前readIndex位置
        int dataLength = byteBuf.readInt();       // 读取传送过来的消息的长度。ByteBuf 的readInt()方法会让他的readIndex增加4
        if (dataLength < 0) { // 我们读到的消息体长度为0，这是不应该出现的情况，这里出现这情况，关闭连接。
            channelHandlerContext.close();
        }

        if (byteBuf.readableBytes() < dataLength) { //读到的消息体长度如果小于我们传送过来的消息长度，则resetReaderIndex. 这个配合markReaderIndex使用的。把readIndex重置到mark的地方
            byteBuf.resetReaderIndex();
            return;
        }

        byte[] body = new byte[dataLength+4];  //  嗯，这时候，我们读到的长度，满足我们的要求了，把传送过来的数据，取出来吧~~
        byteBuf.readBytes(body);  //

//        byte[] temp = new byte[4];
//        byteBuf.readBytes(temp,0,4);
//        int i = temp[3] & 0xFF |
//                (temp[2] & 0xFF) << 8 |
//                (temp[1] & 0xFF) << 16 |
//                (temp[0] & 0xFF) << 24;
//
//        System.out.println(i);

        Object o = new String(body);  //将byte数据转化为我们需要的对象。伪代码，用什么序列化，自行选择
        list.add(o);
    }
}
