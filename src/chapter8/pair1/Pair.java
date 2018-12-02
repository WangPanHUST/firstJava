package chapter8.pair1;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/10/26 19:45
 * @description 泛型类
 **/
public class Pair<T> {

    private T first;
    private T second;

    public Pair(){
        this.first = null;
        this.second = null;
    }

    public Pair(T aFirst,T aSecond){
        this.first = aFirst;
        this.second = aSecond;
    }

    public T getFirst(){
        return first;
    }

    public T getSecond(){
        return second;
    }

    public void setFirst(T newFirst){
        first = newFirst;
    }

    public void setSecond(T newSecond){
        second = newSecond;
    }

}
