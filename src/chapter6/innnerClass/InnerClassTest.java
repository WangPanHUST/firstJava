package chapter6.innnerClass;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/10/6 15:52
 * @description 6-7，内部类的使用
 **/
public class InnerClassTest {

    public static void main(String[] args){

        TalkingClock talk = new TalkingClock(1000,true);
        talk.start();

        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }

}

class TalkingClock{

    private int interval;
    private boolean beep;

    public TalkingClock(int interval,boolean beep){
        this.interval = interval;
        this.beep = beep;
    }

    public void start(){

        ActionListener action = new TimePrinter();

        //chapter6.lambda can replace
//        ActionListener action = event -> {
//            System.out.println("The time is:" + new Date());
//            if(beep){
//                Toolkit.getDefaultToolkit().beep();
//            }
//        };
        Timer t = new Timer(interval,action);
        t.start();

    }

    public class TimePrinter implements ActionListener{

        public void actionPerformed(ActionEvent event){
            System.out.println("The time is:" + new Date());
            //beep是TalkingBlock的数据域，内部类也可以访问
            if(beep){
                Toolkit.getDefaultToolkit().beep();
            }
        }

    }
}





















