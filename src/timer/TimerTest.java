package timer;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
/** 
* @author WangPan wangpanhust@qq.com: 
* @version 2018年9月25日 上午11:25:49 
* 类说明 
*/
public class TimerTest {

	public static void main(String[] args) {
		//接口变量引用实现了该接口的类对象，ActionListener是一个接口
		ActionListener listener = new TimerPrinter();

		Timer t = new Timer(2000,listener);
		t.start();
		JOptionPane.showMessageDialog(null,"Quit program?");
		System.exit(0);
	}

}

class TimerPrinter implements ActionListener{

	//actionPerformed方法是接口ActionListener中的方法
	public void actionPerformed(ActionEvent event){
		System.out.println("At the tone, the time is " + new Date());
		//获得默认的工具箱，beep()发出铃响
		Toolkit.getDefaultToolkit().beep();
	}
}