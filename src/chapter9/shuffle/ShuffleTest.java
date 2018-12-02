package chapter9.shuffle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/11/14 20:20
 * @description 9-7，使用包装类Collections的算法，shuffle和sort
 **/
public class ShuffleTest {

    public static void main(String[] args){

        List<Integer> members = new ArrayList<>();
        for(int i = 0;i < 10;i++){
            members.add(i);
        }
        System.out.println("The original list:" + members);     //The original list:[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        Collections.shuffle(members);
        System.out.println("The random list:" + members);       //The random list:[9, 1, 0, 4, 3, 8, 6, 7, 5, 2]

        List<Integer> winningCombination = members.subList(0,6);
        Collections.sort(winningCombination);
        System.out.println("The first six ordered members:" + winningCombination);      //The first six ordered members:[0, 2, 3, 5, 8, 9]

    }
}
