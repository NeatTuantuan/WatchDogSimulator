package HttpSimulator;

import entity.Message;
import entity.PhotoUpload;
import entity.Record;
import entity.Status;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;
import util.ImageUtil;
import util.ParseJson;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @ClassName Client
 * @Description TODO
 * @Auther tuantuan
 * @Date 2019/9/18 11:06
 * @Version 1.0
 * @Attention Copyright (C)，2004-2019，BDILab，XiDian University
 **/
public class Client {
    public void connect(String host, int port){
        ImageUtil imageUtil = new ImageUtil();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        io.netty.bootstrap.Bootstrap b = new io.netty.bootstrap.Bootstrap();
        b.group(workerGroup);
        b.channel(NioSocketChannel.class);
        b.option(ChannelOption.SO_KEEPALIVE,true);
        b.handler(new ChannelInitializer() {
            @Override
            protected void initChannel(Channel ch) throws Exception {
                ch.pipeline().addLast(new HttpRequestEncoder());
                ch.pipeline().addLast(new TimeServerHandler());
            }
        });

        ChannelFuture f = b.connect(host,port);
        try {
//            DefaultFullHttpRequest request = RequestBuilder("http://127.0.0.1:8080",host,new PhotoUpload(imageUtil.getImageBinary()));
//                // 发送http请求
//            f.channel().write(request);
//            f.channel().flush();
            f.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }

//    /**
//     * 构造HTTP请求
//     * @param url
//     * @param host
//     * @param message
//     * @return
//     * @throws URISyntaxException
//     */
//    public DefaultFullHttpRequest RequestBuilder(String url, String host, Message message) throws URISyntaxException {
//        ParseJson parseJson = new ParseJson();
//        URI uri = new URI(url);
////            String msg = "hello,world";
//        DefaultFullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, uri.toASCIIString(), Unpooled.wrappedBuffer(parseJson.Object2Bytes(message)));
//
//        // 构建http请求
//        request.headers().set(HttpHeaders.Names.HOST, host);
//        request.headers().set(HttpHeaders.Names.CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
//        request.headers().set(HttpHeaders.Names.CONTENT_LENGTH, request.content().readableBytes());//可以在httpRequest.headers中设置各种需要的信息。
//        if (message instanceof Status){
//            request.headers().set("messageType","Status");
//        }else if (message instanceof Record){
//            request.headers().set("messageType","Record");
//        }else if (message instanceof PhotoUpload){
//            request.headers().set("messageType","PhotoUpload");
//        }
//
////        request.headers().set("businessType","testServerStatus");
//        return request;
//
//    }


    public static void main(String[] args){
        Client client = new Client();
        client.connect("127.0.0.1",8080);
    }
}
