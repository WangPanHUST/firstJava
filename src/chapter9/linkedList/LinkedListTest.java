package chapter9.linkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/11/7 21:09
 * @description 9-1，LikedList的使用，list是有序的集合，可以存在重复元素
 **/
public class LinkedListTest {

    public static void main(String[] args){

        List<String> a = new LinkedList<>();
        a.add("Bob");
        a.add("Ash");
        a.add("Joy");

        List<String> b = new LinkedList<>();
        b.add("Qaq");
        b.add("Tvt");
        b.add("Ppp");
        b.add("Kxf");

        //merge the words from b into a
        //add方法只有子类ListIterator中才有
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext()){
            if(aIter.hasNext()){
                aIter.next();//获得迭代器的位置
            }
            //add方法对之后next的调用没有影响，仍然按照a只有三个元素的顺序进行调用，而previous会调用更新之后的列表
            aIter.add(bIter.next());
        }

        System.out.println(a);  //[Bob, Qaq, Ash, Tvt, Joy, Ppp, Kxf]

        //remove every second word from b
        //这里在上一个while中，bIter的位置已经是链表b的末尾，这里要重新获得一个位置在链表首端的迭代器
        bIter = b.iterator();
        while (bIter.hasNext()){
            bIter.next();
            if(bIter.hasNext()){
                bIter.next();
                bIter.remove();
            }
        }
        System.out.println(b);  //[Qaq, Ppp]

        //remove all words in b from a
        a.removeAll(b);
        System.out.println(a);  //[Bob, Ash, Tvt, Joy, Kxf]

    }
}
