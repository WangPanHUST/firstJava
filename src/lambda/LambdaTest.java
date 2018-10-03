package lambda;

import java.util.Arrays;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/10/3 13:23
 * @description demonstrates the use of lambda expressions
 **/
public class LambdaTest {

    public static void main(String[] args){

        String[] continents = new String[] {"Asia","Europe","North America","South America","Oceania","Africa","Antarctic"};
        //使用Arrays.toString()来打印数组类型
        System.out.println(Arrays.toString(continents));

        System.out.println("Sorted in dictionary order:");
        Arrays.sort(continents);
        System.out.println(Arrays.toString(continents));

        System.out.println("Sorted by length:");
        Arrays.sort(continents,(first,second) -> first.length() - second.length());
        System.out.println(Arrays.toString(continents));

        Timer t = new Timer(1000, event -> System.out.println("The time is :" + new Date()));
        t.start();

        JOptionPane.showMessageDialog(null,"Quit rogram?");
        System.exit(0);
    }
}
