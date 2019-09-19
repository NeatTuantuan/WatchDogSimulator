package HttpSimulator;

import entity.*;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpVersion;
import util.EntityInit;
import util.ParseJson;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @ClassName TimeServerHandler
 * @Description TODO
 * @Auther tuantuan
 * @Date 2019/9/18 19:17
 * @Version 1.0
 * @Attention Copyright (C)，2004-2019，BDILab，XiDian University
 **/
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    EntityInit entityInit = new EntityInit();
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        while(true){
            DefaultFullHttpRequest request = RequestBuilder("http://127.0.0.1:8080","127.0.0.1",entityInit.heartBeatInit());
            ctx.writeAndFlush(request);
            Thread.sleep(2000);
        }
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * 构造HTTP请求
     * @param url
     * @param host
     * @param message
     * @return
     * @throws URISyntaxException
     */
    public DefaultFullHttpRequest RequestBuilder(String url, String host, Message message) throws URISyntaxException {
        ParseJson parseJson = new ParseJson();
        URI uri = new URI(url);
        DefaultFullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, uri.toASCIIString(), Unpooled.wrappedBuffer(parseJson.Object2Bytes(message)));

        // 构建http请求
        request.headers().set(HttpHeaders.Names.HOST, host);
        request.headers().set(HttpHeaders.Names.CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
        request.headers().set(HttpHeaders.Names.CONTENT_LENGTH, request.content().readableBytes());//可以在httpRequest.headers中设置各种需要的信息。
        if (message instanceof Status){
            request.headers().set("messageType","Status");
        }else if (message instanceof Record){
            request.headers().set("messageType","Record");
        }else if (message instanceof PhotoUpload){
            request.headers().set("messageType","PhotoUpload");
        }else {
            request.headers().set("messageType","HeartBeat");
        }

        request.headers().set("businessType","testServerStatus");
        return request;

    }
}
