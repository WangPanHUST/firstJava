package priorityQueue;

import java.time.LocalDate;
import java.util.PriorityQueue;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/11/12 9:59
 * @description
 **/
public class PriorityQueueTest {

    public static void main(String[] args){

        PriorityQueue<LocalDate> pq = new PriorityQueue<>();
        pq.add(LocalDate.of(2018,11,12));
        pq.add(LocalDate.of(2017,11,11));
        pq.add(LocalDate.of(2016,11,10));

        System.out.println("Iterating over elements...");
        for(LocalDate ld : pq){
            System.out.println(ld);
        }

        //remove方法总是返回树的根，对树执行add或remove操作，总是让最小的元素移动到根
        System.out.println("Removing elements...");
        while (!pq.isEmpty()){
            System.out.println(pq.remove());
        }

    }
}
