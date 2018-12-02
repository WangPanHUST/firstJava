package chapter14.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.function.DoublePredicate;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/11/26 11:15
 * @description 14-12，fork-join框架
 **/
public class ForkJoinTest {
    public static void main(String[] args){
        final int SIZE = 1000000;
        double[] numbers = new double[SIZE];
        for (int i = 0;i < SIZE;i++){
            numbers[i] = Math.random();
        }
        Counter counter = new Counter(numbers,0,numbers.length,x -> x > 0.5);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(counter);
        System.out.println(counter.join());
    }
}

class Counter extends RecursiveTask<Integer> {

    public static final int THRESHOLD = 1000;
    public double[] values;
    public int from;
    public int to;
    //DoublePredicate是接口变量，DoublePredicate只有一个抽象方法，boolean test（double value），故可用lambda表达式代替
    private DoublePredicate filter;

    public Counter(double[] values,int from,int to,DoublePredicate filter){
        this.values = values;
        this.from = from;
        this.to = to;
        this.filter = filter;
    }


    @Override
    protected Integer compute() {
        if(to - from < THRESHOLD){
            int count = 0;
            for(int i = from;i < to;i++){
                if(filter.test(values[i])){
                    count++;
                }
            }
            return count;
        }else{
            int mid = (from + to) / 2;
            Counter first = new Counter(values,from,mid,filter);
            Counter second = new Counter(values,mid,to,filter);
            invokeAll(first,second);
            return first.join() + second.join();
        }
    }
}














