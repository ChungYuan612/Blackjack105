package me.cyperion.Blackjack105;

import javax.swing.*;
import java.awt.*;

//UI設定，在這裡搞好UI
public abstract class BlackjackUI extends JFrame {
    protected JButton btnstart = new JButton("發牌");
    protected JButton btnadd = new JButton("補牌");
    protected JButton btnok = new JButton("補牌確定");
    protected Toolkit toolkit;
    protected Icon icon;
    protected JLabel lbl[];
    protected String[] d = new String[53]; // 牌面解碼
    protected int[] a = new int[52]; // 牌面編碼
    protected int j; // 紙牌序號

    protected JLabel lbl1=new JLabel("Stake:");
    protected JLabel lbl2=new JLabel();//Stake display 本金
    protected JLabel lbl3=new JLabel("Bets:");
    protected JLabel lbl4=new JLabel();//Bets display 賭注
    protected JLabel lbl5=new JLabel("Result:");
    protected JLabel lbl6=new JLabel();//Result display
    protected JLabel lbl7=new JLabel("Rate:");
    protected JLabel lbl8=new JLabel();//Rate display
    protected JLabel lbl9=new JLabel("Player Points:");
    protected JLabel lbl10=new JLabel(" 0.0 ");
    protected JLabel lbl11=new JLabel("Dealer Points");
    protected JLabel lbl12=new JLabel(" 0.0 ");

    //Layout -> ChatGPT :)
    public BlackjackUI() {
        this.setLocation(100,50); //位置
        this.setSize(600,400);    //大小w,h
        this.setTitle(" \"Ten and Half,\" the dealer will win if the scores are the same."); //標題
        BorderLayout lay=new BorderLayout();
        this.setLayout(lay);
        JPanel pan1=new JPanel();
        this.add(pan1,BorderLayout.CENTER);
        GridLayout lay1=new GridLayout(2,1);//(r,c)控制項間沒有間距
        pan1.setLayout(lay1);
        lbl=new JLabel[10];
        for (int i=0;i<=9;i++) {
            lbl[i]=new JLabel();
            //lbl[i].addMouseListener(this);//這樣元件就有事件處理能力
            pan1.add(lbl[i]);
        }
        lbl2.setText("100");
        lbl4.setText("10");
        JPanel pan2=new JPanel();
        this.add(pan2,BorderLayout.SOUTH);
        GridLayout lay2=new GridLayout(3,1);//(r,c)控制項間沒有間距
        pan2.setLayout(lay2);
        JPanel pan3=new JPanel();
        JPanel pan4=new JPanel();
        JPanel pan5=new JPanel();
        pan2.add(pan3);
        pan2.add(pan4);
        pan2.add(pan5);
        GridLayout lay3=new GridLayout(1,6);//(r,c)控制項間沒有間距
        pan3.setLayout(lay3);
        pan3.add(lbl1);
        pan3.add(lbl2);
        pan3.add(lbl3);
        pan3.add(lbl4);
        pan3.add(lbl5);
        pan3.add(lbl6);
        pan3.add(lbl7);
        pan3.add(lbl8);
        FlowLayout lay4=new FlowLayout(FlowLayout.LEFT);//(r,c)控制項間沒有間距
        pan4.setLayout(lay4);
        pan4.add(lbl9);
        pan4.add(lbl10);
        FlowLayout lay5=new FlowLayout(FlowLayout.LEFT);//(r,c)控制項間沒有間距
        pan5.setLayout(lay5);
        pan5.add(lbl11);
        pan5.add(lbl12);
        pan5.add(btnstart);
        pan5.add(btnadd);
        pan5.add(btnok);
        toolkit=Toolkit.getDefaultToolkit();
        btnadd.setEnabled(false);//先關閉
        btnok.setEnabled(false);//先關閉

        //load image file
        for(int i=0;i<=52;i++)
            //d[i]="g"+String.valueOf(i)+".jpg";
            d[i]="src/lib/g"+i+".jpg";

    }

    //發牌
    public abstract void btnstart();

    //補牌
    public abstract void btnadd();

    //補牌確定
    public abstract void btnok();

}