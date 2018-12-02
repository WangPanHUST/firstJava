package chapter9.treeSet;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/11/11 18:41
 * @description 9-3、4，树集的使用，树集是有序集合，每个元素都被放在排序好的位置上
 **/
public class TreeSetTest {

    public static void main(String[] args){

        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster",1234));
        parts.add(new Item("Wiget",4562));
        parts.add(new Item("Modem",9912));

        System.out.println(parts);  //[[description=Toaster,partNumber=1234], [description=Wiget,partNumber=4562], [description=Modem,partNumber=9912]]

        //new TreeSet<>(Comparator.comparing(Item::getDescription)) Comparator.comparing方法会返回一个比较器
        //TreeSet中的排序规则将按照比较器提供的规则
        NavigableSet<Item> sortByDescription = new TreeSet<>(Comparator.comparing(Item::getDescription));
        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);  //[[description=Modem,partNumber=9912], [description=Toaster,partNumber=1234], [description=Wiget,partNumber=4562]]
    }
}






































