package nettySimulator;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName nettySimulator.ServervHandler
 * @Description TODO
 * @Auther tuantuan
 * @Date 2019/9/11 9:38
 * @Version 1.0
 * @Attention Copyright (C)，2004-2019，BDILab，XiDian University
 **/
public class ServervHandler extends SimpleChannelInboundHandler<String> {
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
////        super.channelRead(ctx, msg);
//        System.out.println(msg.toString());
//        System.out.println("asdasdasda");
//        ctx.flush();
//    }

    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.println(s);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
