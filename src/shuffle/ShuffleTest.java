package shuffle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/11/14 20:20
 * @description randome shuffle and sort algorithms
 **/
public class ShuffleTest {

    public static void main(String[] args){

        List<Integer> members = new ArrayList<>();
        for(int i = 0;i < 10;i++){
            members.add(i);
        }
        System.out.println("The original list:" + members);
        Collections.shuffle(members);
        System.out.println("The random list:" + members);
        List<Integer> winningCombination = members.subList(0,6);
        Collections.sort(winningCombination);
        System.out.println(winningCombination);

    }
}
