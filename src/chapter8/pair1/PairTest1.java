package chapter8.pair1;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/10/26 19:32
 * @description 8-1，泛型类的使用
 **/
public class PairTest1 {

    public static void main(String[] args){
        String[] words = {"Wang","pan","is","a","good","boy"};
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println("min = " + mm.getFirst());   //min = a
        System.out.println("max = " + mm.getSecond());  //max = Wang

    }
}

class ArrayAlg{

    public static Pair<String> minmax(String[] s){
        if(s == null || s.length == 0){
            return null;
        }
        String min = s[0];
        String max = s[0];
        for(int i = 1;i < s.length;i++){
            if(min.compareToIgnoreCase(s[i]) > 0){
                min = s[i];
            }
            if(max.compareToIgnoreCase(s[i]) < 0){
                max = s[i];
            }
        }

        return new Pair<>(min,max);
    }
}