package DigitalClock;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyWindow extends JFrame {
    private JLabel heading ;
    private JLabel clockLable;
    private Font font = new Font("",Font.BOLD,35);

// window setting
    MyWindow(){
        super.setTitle("My Clock"); // make title
        super.setSize(600,400);
        super.setLocation(300,50);
        this.creatGUI();
        this.startClock();
        super.setVisible(true);

    }
// creating GUI(Graphics user interface)
    public void creatGUI(){
        // gui
        heading = new JLabel("My Clock");
        clockLable = new JLabel("Clock");  // yaha obj banaya // iske bad clockLable ko update kar sakte
        heading.setFont(font);
        clockLable.setFont(font);

        this.setLayout(new GridLayout(2,1));
        this.add(heading);
        this.add(clockLable);

    }
// clock updating using multithread
    public void startClock(){

        Thread t = new Thread(){
            public void run(){
                try{
                    while (true){
                        Date d = new Date();
                        SimpleDateFormat sdf = new SimpleDateFormat("hh : mm : ss a"); // can change according to rule
                        String dateTime = sdf.format(d);
                        clockLable.setText(dateTime);
//                        Thread.sleep(1000);
                        Thread.currentThread().sleep(1000);
                    }
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }

}

