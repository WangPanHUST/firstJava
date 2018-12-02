package chapter6.anonymousInnerClass;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/10/7 14:39
 * @description 6-8，匿名内部类的使用，只创建这个类的一个对象
 **/
public class AnonymousInnerClassTest {

    public static void main(String[] args){

        TalkingClock clock = new TalkingClock();
        clock.start(1000,true);

        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }
}

class TalkingClock{

    public void start(int interval,boolean beep){

        //匿名内部类，在构造器参数后直接跟大括号加具体方法实现
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("The time is: " + new Date());
                if(beep){
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        };  //匿名内部类之后也要加；

        Timer t = new Timer(interval,listener);
        t.start();
    }
}
