package chapter9.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/11/9 11:30
 * @description 9-2，Set接口的使用，Set中不允许存在重复元素，元素排列是无序的，可以进行快速查找
 **/
public class SetTest {

    public static void main(String[] args){
        Set<String> words = new HashSet<>();
        long totalTime = 0;

        System.out.println("Please enter some words:");

        try(Scanner in = new Scanner(System.in)){
            //最后输入"s"来结束输入，"s"不会进入words中的
            while (!in.hasNext("s")){
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }
        }

        Iterator<String> setIter = words.iterator();
        for (int i = 1;i <= 20 && setIter.hasNext();i++){
            System.out.println(setIter.next());
        }
        System.out.println("...");
        System.out.println(words.size() + " distinct words. " + totalTime + "milliseconds");
    }
}
