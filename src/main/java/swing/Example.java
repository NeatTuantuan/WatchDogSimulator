package swing;

import HttpSimulator.*;
import util.EntityInit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static swing.Example.entityInit;

/**
 * @ClassName Example
 * @Description TODO
 * @Auther tuantuan
 * @Date 2019/9/24 10:25
 * @Version 1.0
 * @Attention Copyright (C)，2004-2019，BDILab，XiDian University
 **/
public class Example {

    static EntityInit entityInit = new EntityInit();

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
    	JFrame frame= new CreatButtonFrame();
        frame.setTitle("ButtonTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);});
        //gui运行后立刻发送心跳,新起一个线程

        HeartbeatClient heartbeatClient = new HeartbeatClient("192.168.0.229",8080,entityInit);
        new Thread(heartbeatClient).start();
    }
}

/**
 * 布局类
 */
class CreatButtonFrame extends JFrame{
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    /**
     * 创建按钮Frame
     */
    public CreatButtonFrame(){
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        //初始化按钮
        JButton openGateButton = new JButton("开门");
        JButton closeGateButton = new JButton("关门");
        JButton takePhotoButton = new JButton("抓拍");
        //添加按钮
        buttonPanel = new JPanel();
        buttonPanel.add(openGateButton);
        buttonPanel.add(closeGateButton);
        buttonPanel.add(takePhotoButton);
        add(buttonPanel);

        OpenGateAction openGateAction = new OpenGateAction();
        CloseGateAction closeGateAction = new CloseGateAction();
        TakePhotoButton takePhotoAction = new TakePhotoButton();
        //添加事件监听器
        openGateButton.addActionListener(openGateAction);
        closeGateButton.addActionListener(closeGateAction);
        takePhotoButton.addActionListener(takePhotoAction);
    }

    /**
     * 开门按钮监听器
     */
    class OpenGateAction implements ActionListener{
        EntityClient openGateClient = new EntityClient("192.168.0.229",8080,0);
        /**
         * 点击开门按钮时，新启一个线程发送开门记录,并将门禁状态设置为开启（1）
         * @param event
         */
        public void actionPerformed(ActionEvent event){
            new Thread(openGateClient).start();
            entityInit.setHeartBeatStatus(1);
            System.out.println("门已开");
        }
    }
    /**
     * 关门按钮监听器
     */
    class CloseGateAction implements ActionListener{
        /**
         * 设置门禁状态为关闭
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            entityInit.setHeartBeatStatus(0);
            entityInit.heartBeatInit();
        }
    }

    /**
     * 拍照按钮监听器
     */
    class TakePhotoButton implements ActionListener{
        EntityClient takePhotoClient = new EntityClient("192.168.0.229",8080,1);
        @Override
        public void actionPerformed(ActionEvent e) {
            new Thread(takePhotoClient).start();
            System.out.println("照片已抓拍");

        }
    }
}