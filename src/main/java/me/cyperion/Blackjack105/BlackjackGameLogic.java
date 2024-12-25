package me.cyperion.Blackjack105;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//邏輯設定，在這裡處理遊戲邏輯(主要是按按鈕而已)
public class BlackjackGameLogic extends BlackjackUI implements ActionListener {

    public BlackjackGameLogic() {
        super();
        btnstart.addActionListener(this);
        btnadd.addActionListener(this);
        btnok.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnstart)
            btnstart();
        else
        if(e.getSource()==btnadd)
            btnadd();
        else
            btnok();
    }

    @Override
    public void btnstart() {
        int i,t,k;
        //設定排面初值
        for(i=0;i<=51;i++)
            a[i]=i;
        //洗牌
        for (i=0 ;i<=51;i++)
        {
            k=(int)(Math.floor(Math.random()*52));
            t=a[i];a[i]=a[k];a[k]=t;
        }
        //顯示玩家牌面
        icon=new ImageIcon(d[a[0]]);
        lbl[0].setIcon(icon);
        //顯示莊家牌面，此時還蓋著
        icon=new ImageIcon(d[52]);
        lbl[5].setIcon(icon);
        p1=p[a[0]];
        j=1;//發牌序號
        btnstart.setEnabled(false);
        btnadd.setEnabled(true);
        btnok.setEnabled(true);
        //清除上次牌面
        for ( i=1;i<=4;i++){
            icon=new ImageIcon("");
            lbl[i].setIcon(icon);
        }
        for ( i=6;i<=9;i++){
            icon=new ImageIcon("");
            lbl[i].setIcon(icon);
        }
        lbl6.setText("");
        lbl8.setText("");
        lbl10.setText("");
        lbl12.setText("");
    }
    @Override
    public void btnadd() {
        j++;//發牌序號
        String type="";
        boolean gameover=false;
        //顯示牌面
        icon=new ImageIcon(d[a[j]]);
        lbl[j-1].setIcon(icon);
        p1 = p1 + p[a[j]];// 玩家點數累計
        lbl10.setText(Float.toString(p1));
        rate = 0 ;
        if (p1 > 10.5) 	  {
            type = " Player Lose";
            rate = -1;
            gameover = true ;
        }
        else if (p1 == 10.5) 	    {
            rate = 2;
            type = " Ten and Half!!";
            gameover = true;
        }
        else if (j == 5) 	  {
            rate = 2;
            type = " 玩家五小";
            gameover = true;
        }
        if (gameover) 	  {
            money = Integer.parseInt(lbl2.getText());
            money = money + money1 * rate;
            lbl2.setText(Integer.toString(money));
            lbl6.setText( type);
            lbl8.setText(Integer.toString(rate));
            btnstart.setEnabled( true); // 發牌
            btnadd.setEnabled( false); // 補牌
            btnok.setEnabled(false); // 補牌確定
        }
    }

    @Override
    public void btnok() {
        String type=" Dealer Win";
        rate = -1;
        // 打開莊家的牌
        icon=new ImageIcon(d[a[1]]);
        lbl[5].setIcon(icon);
        p2 = p[a[1]]; // 莊家累計點數
        lbl12.setText(Float.toString(p2));
        int k = 1;
        p1 = p1 - p[a[0]]; //p1 目前是玩家補牌的累計點數
        // 莊家補牌的條件為
        //1 、點數和小於玩家補牌的累計點數
        //2 、莊家點數和小於 6
        //3 、莊家全部張數小於 4
        while (((p2 < p1) || (p2 < 6)) && k <= 4)
        {
            j++ ;
            k++; // 莊家紙牌數目
            p2 = p2 + p[a[j]];
            icon=new ImageIcon(d[a[j]]);
            lbl[k+4].setIcon(icon);
        }
        p1 = p1 + p[a[0]];
        if (p2 >10.5)    	{
            rate = 1 ;
            type = " Dealer Lose" ;
        }
        else
        if (k==5)    	{
            rate = -1 ;
            type = "莊家五小";
        }
        else
        if (p1 > p2)    		{
            rate = 1 ;
            type = " Player Win" ;
        }
        // 計算本金餘額
        money = Integer.parseInt(lbl2.getText());
        money = money + money1 * rate;
        lbl2.setText(Integer.toString(money));
        lbl6.setText( type);
        lbl8.setText(Integer.toString(rate));
        lbl10.setText(Float.toString(p1));
        lbl12.setText(Float.toString(p2));
        btnstart.setEnabled( true); // 發牌
        btnadd.setEnabled( false); // 補牌
        btnok.setEnabled(false); // 補牌確定
    }

}