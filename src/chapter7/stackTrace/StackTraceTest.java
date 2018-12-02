package chapter7.stackTrace;

import java.util.Scanner;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/10/19 19:57
 * @description 7-1，分析递归调用的栈轨迹 7-2
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
/*
输出：
Enter n:
3
factorial(3):
chapter7.stackTrace.StackTraceTest.factorial(StackTraceTest.java:21)
chapter7.stackTrace.StackTraceTest.main(StackTraceTest.java:16)
factorial(2):
chapter7.stackTrace.StackTraceTest.factorial(StackTraceTest.java:21)
chapter7.stackTrace.StackTraceTest.factorial(StackTraceTest.java:30)
chapter7.stackTrace.StackTraceTest.main(StackTraceTest.java:16)
factorial(1):
chapter7.stackTrace.StackTraceTest.factorial(StackTraceTest.java:21)
chapter7.stackTrace.StackTraceTest.factorial(StackTraceTest.java:30)
chapter7.stackTrace.StackTraceTest.factorial(StackTraceTest.java:30)
chapter7.stackTrace.StackTraceTest.main(StackTraceTest.java:16)
return1
return2
return6
 */