package set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/11/9 11:30
 * @description uses a set to print all unique words in System.in
 **/
public class SetTest {

    public static void main(String[] args){
        Set<String> words = new HashSet<>();
        long totalTime = 0;

        try(Scanner in = new Scanner(System.in)){
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
