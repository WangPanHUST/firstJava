package chapter9.priorityQueue;

import java.time.LocalDate;
import java.util.PriorityQueue;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/11/12 9:59
 * @description 9-5，优先级队列，remove和add操作让最小的元素移动到首位，而迭代访问也只能保证第一个元素是最小的，输出的其他元素仍然是无序的
 **/
public class PriorityQueueTest {

    public static void main(String[] args){

        PriorityQueue<LocalDate> pq = new PriorityQueue<>();
        pq.add(LocalDate.of(2018,11,12));
        pq.add(LocalDate.of(2017,11,11));
        pq.add(LocalDate.of(2016,11,10));

        //迭代访问只能保证第一个元素仍然是最小的，但是后续的元素仍然是无序的
        System.out.println("Iterating over elements...");
        for(LocalDate ld : pq){
            System.out.println(ld);
            /*
            只有第一个是最小的，而其他仍然是无序输出的
            2016-11-10
            2018-11-12
            2017-11-11
             */
        }

        //remove方法总是返回树的根，对树执行add或remove操作，总是让最小的元素移动到根
        System.out.println("Removing elements...");
        while (!pq.isEmpty()){
            System.out.println(pq.remove());
            /*
            每次remove都是返回的最小的那个元素
            2016-11-10
            2017-11-11
            2018-11-12
             */
        }

    }
}
