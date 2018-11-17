package linkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/11/7 21:09
 * @description operations on linkedlists
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

        ListIterator<String> aIter = a.listIterator();//add方法只有子类ListIterator中才有
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext()){
            if(aIter.hasNext()){
                aIter.next();//获得迭代器的位置
            }
            aIter.add(bIter.next());
        }

        System.out.println(a);

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

        System.out.println(b);

        //
        a.removeAll(b);
        System.out.println(a);

    }
}
