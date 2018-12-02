package chapter14.unsynch;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/11/17 16:05
 * @description 14-5、6，未使用同步机制的转账（transfer方法），输出中会出现totalBalance不是100000的情况，程序需要手动停止
 **/
public class UnsynchTest {

    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 1000;
    public static final int DELAY = 10;

    public static void main(String[] args){

        Bank bank = new Bank(NACCOUNTS,INITIAL_BALANCE);
        for (int i = 0;i < 100;i++){
            int fromAccount = i;
            Runnable r = () -> {
                try{
                    while (true){
                        int toAccount = (int)(bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount,toAccount,amount);
                        Thread.sleep((int)(DELAY * Math.random()));
                    }
                }catch (InterruptedException e){

                }
            };
            Thread t = new Thread(r);
            t.start();
            System.out.println("rrrrrrrr:" + r);
        }
    }

}

