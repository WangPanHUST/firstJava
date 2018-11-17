package unsynch;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/11/17 16:04
 * @description
 **/
public class Bank {

    private final double[] accounts;
    private Lock bankLock = new ReentrantLock();//可重入锁

    /**
    * @Description: Constructs the bank class.
    * @Param: [n, initialBalance] n,the amount of accounts,initialBalance the initial balance of each account
    * @return:
    * @Author: WangPan wangpanhust@qq.com
    * @Date: 2018/11/17 16:19
    */
    public Bank(int n,double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts,initialBalance);
    }

    /**
    * @Description: Trancsfers money from one account to another.
    * @Param: [from, to, amount] from the account to trnansfer from,to the account to
     * tansfer to,amount the amount to transfer
    * @return: void
    * @Author: WangPan wangpanhust@qq.com
    * @Date: 2018/11/17 16:17
    */
//    public void transfer(int from,int to,double amount){
//        if(accounts[from] < amount){
//            return;
//        }
//        System.out.print(Thread.currentThread());
//        accounts[from] -= amount;
//        System.out.printf("%10.2f from %d to %d",amount,from,to);
//        accounts[to] += amount;
//        System.out.printf("Total Balance: %10.2f\n",getTotalBalance());
//    }

    public void transfer(int from,int to,double amount){
        bankLock.lock();
        try{
            if(accounts[from] < amount){
                return;
            }
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d",amount,from,to);
            accounts[to] += amount;
            System.out.printf("Total Balance: %10.2f\n",getTotalBalance());
        }
        finally {
            bankLock.unlock();
        }

    }

    /**
    * @Description: gets the sum of all account balances
    * @Param: []
    * @return: double
    * @Author: WangPan wangpanhust@qq.com
    * @Date: 2018/11/17 16:16
    */
    public double getTotalBalance(){
        double sum = 0;
        for(double b : accounts){
            sum += b;
        }
        return sum;
    }
    
    /** 
    * @Description: gets the number of accounts
    * @Param: [] 
    * @return: int 
    * @Author: WangPan wangpanhust@qq.com 
    * @Date: 2018/11/17 16:16
    */ 
    public int size(){
        return accounts.length;
    }
}
