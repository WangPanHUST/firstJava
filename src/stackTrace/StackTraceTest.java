package stackTrace;

import java.util.Scanner;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/10/19 19:57
 * @description displays a trace feature of a recursive method call
 **/
public class StackTraceTest {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter n:");
        int n = in.nextInt();
        factorial(n);
    }

    public static int factorial(int n){
        System.out.println("factorial(" + n + "):");
        Throwable t = new Throwable();
        StackTraceElement[] frames = t.getStackTrace();
        for(StackTraceElement s : frames){
            System.out.println(s);
        }
        int r;
        if(n <= 1){
            r = 1;
        }else{
            r = n * factorial(n - 1);
        }
        System.out.println("return" + r);
        return r;
    }
}
