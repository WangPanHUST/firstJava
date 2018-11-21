package sync;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/11/18 18:26
 * @description
 **/
public class SynchBank {

    private double[] accounts;
    private Lock bankLock;
    private Condition sufficientFunds;

    public SynchBank(int n,double initialBlance){
        accounts = new double[n];
        Arrays.fill(accounts,initialBlance);
        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();
    }
      //使用Reentrant显式锁和Condition条件来实现
//    public void transfer(int from,int to,double amount)throws  InterruptedException{
//        bankLock.lock();
//        try{
//            while(accounts[from] < amount){
//                sufficientFunds.await();
//            }
//            System.out.print(Thread.currentThread());
//            accounts[from] -= amount;
//            //f 浮点数，%10.2，10表示输出总的长度，2表示小数点后面的位数，格式为十进制浮点数，d 整数，格式为十进制整数，s 输出字符串
//            System.out.printf("%10.2f from %d to %d",amount,from,to);
//            accounts[to] += amount;
//            System.out.printf("Total Balance:%10.2f%n",getTotalBalance());
//            sufficientFunds.signalAll();
//        }finally{
//            bankLock.unlock();
//        }
//    }
//
//    public double getTotalBalance(){
//        bankLock.lock();
//        try{
//            double sum = 0;
//            for(double d : accounts){
//                sum += d;
//            }
//            return sum;
//        }finally {
//            bankLock.unlock();
//        }
//    }
    //使用synchronized关键字实现
    public synchronized void transfer(int from,int to,double amount)throws InterruptedException{
        while(accounts[from] < amount){
            wait();
        }
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        //f 浮点数，%10.2，10表示输出总的长度，2表示小数点后面的位数，格式为十进制浮点数，d 整数，格式为十进制整数，s 输出字符串
        System.out.printf("%10.2f from %d to %d",amount,from,to);
        accounts[to] += amount;
        System.out.printf("Total Balance:%10.2f%n",getTotalBalance());
        notifyAll();
    }

    public synchronized double getTotalBalance(){
        double sum = 0;
        for(double d : accounts){
            sum += d;
        }
        return sum;
    }

    public int size(){
        return accounts.length;
    }
}
























