package chapter5.methods;

import java.lang.reflect.Method;
import java.util.Comparator;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/11/29 10:17
 * @description 5-17，方法指针，使用反射调用任意方法
 **/
public class MethodTableTest {

    public static void main(String[] args)throws Exception{
        //通过反射获得方法指针，Method对象
        Method square = MethodTableTest.class.getMethod("square",double.class);
        Method sqrt = Math.class.getMethod("sqrt", double.class);

        printTable(1,10,10,square);
        printTable(1,10,10,sqrt);

    }

    public static double square(double x){
        return x * x;
    }

    public static void printTable(double from, double to, int n, Method f){
        //打印所用的方法
        System.out.println(f);
        double dx = (to - from ) / (n-1);

        for (double x = from;x <= to;x += dx){
            try{
                double y = (Double)f.invoke(null,x);
                System.out.printf("%10.4f |%10.4f%n",x,y);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
/*
输出：
public static double chapter5.methods.MethodTableTest.square(double)
    1.0000 |    1.0000
    2.0000 |    4.0000
    3.0000 |    9.0000
    4.0000 |   16.0000
    5.0000 |   25.0000
    6.0000 |   36.0000
    7.0000 |   49.0000
    8.0000 |   64.0000
    9.0000 |   81.0000
   10.0000 |  100.0000
public static double java.lang.Math.sqrt(double)
    1.0000 |    1.0000
    2.0000 |    1.4142
    3.0000 |    1.7321
    4.0000 |    2.0000
    5.0000 |    2.2361
    6.0000 |    2.4495
    7.0000 |    2.6458
    8.0000 |    2.8284
    9.0000 |    3.0000
   10.0000 |    3.1623

 */
