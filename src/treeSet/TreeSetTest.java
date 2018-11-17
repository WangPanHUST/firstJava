package treeSet;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/11/11 18:41
 * @description sort a set of item by comparing their description
 **/
public class TreeSetTest {

    public static void main(String[] args){

        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster",1234));
        parts.add(new Item("Wiget",4562));
        parts.add(new Item("Modem",9912));
        System.out.println(parts);

        //new TreeSet<>(Comparator.comparing(Item::getDescription)) Comparator.comparing方法会返回一个比较器
        //TreeSet中的排序规则将按照比较器提供的规则
        NavigableSet<Item> sortByDescription = new TreeSet<>(Comparator.comparing(Item::getDescription));
        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);

    }
}






































