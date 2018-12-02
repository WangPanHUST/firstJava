package chapter6.lambda;

import java.util.Arrays;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/10/3 13:23
 * @description 6-6，lambda表达式的使用
 **/
public class LambdaTest {

    public static void main(String[] args){

        String[] continents = new String[] {"Asia","Europe","North America","South America","Oceania","Africa","Antarctic"};
        //使用Arrays.toString()来打印数组类型
        System.out.println(Arrays.toString(continents));    //[Asia, Europe, North America, South America, Oceania, Africa, Antarctic]

        System.out.println("Sorted in dictionary order:");
        Arrays.sort(continents);
        System.out.println(Arrays.toString(continents));    //[Africa, Antarctic, Asia, Europe, North America, Oceania, South America]

        System.out.println("Sorted by length:");
        //sort函数的第二个参数要求是Comparator，这里用lambda表达式实现了比较器
        Arrays.sort(continents,(first,second) -> first.length() - second.length());
        System.out.println(Arrays.toString(continents));    //[Asia, Africa, Europe, Oceania, Antarctic, North America, South America]


        Timer t = new Timer(1000, event -> System.out.println("The time is :" + new Date()));
        t.start();

        JOptionPane.showMessageDialog(null,"Quit rogram?");
        System.exit(0);
    }
}
