package chapter14.synch;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/12/1 16:03
 * @description 14-7、8，sunchronized关键字和Reentrant显示锁两种方式实现同步访问
 **/
public class SynchTest {
    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 1000;
    public static final int DELAY = 10;

    public static void main(String[] args){

        SynchBank bank = new SynchBank(NACCOUNTS,INITIAL_BALANCE);
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
