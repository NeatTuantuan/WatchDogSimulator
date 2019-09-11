package simulator;

import entity.Status;
import util.ParseJson;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @ClassName Transmission
 * @Description TODO
 * @Auther tuantuan
 * @Date 2019/9/10 17:41
 * @Version 1.0
 * @Attention Copyright (C)，2004-2019，BDILab，XiDian University
 **/

public class Transmission {
    public static void main(String[] args){
        ParseJson parseJson = new ParseJson();
        try {
            Socket socket = new Socket("127.0.0.1",8080);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            System.out.println("开始发送");

            //发送消息
            while(true){
                printWriter.println(parseJson.Object2Json(new Status()));
                printWriter.flush();
                Thread.sleep(2000);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
