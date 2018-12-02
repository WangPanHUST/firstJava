package chapter8.pair3;

import chapter5.inheritance.Employee;
import chapter5.inheritance.Manager;
import chapter8.pair1.Pair;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/10/30 20:31
 * @description：8-3，通配符的使用演示，<？extends Employee> 可以读取但不能进行赋值，<? super Manager> 可以赋值但不能读取
 **/
public class PairTest3 {

    public static void main(String[] args){

        Manager ceo  = new Manager("Peter",800000,2030,9,1);
        Manager cfo  = new Manager("Kuff",500000,2031,9,1);
        Pair<Manager> buddies = new Pair<>(ceo,cfo);
        printBuddies(buddies);  //Peter and Kuff are buddies.

        ceo.setBonus(100000);
        cfo.setBonus(50000);

        Manager[] managers  = {ceo,cfo};

        Pair<Employee> result = new Pair<>();
        minmaxSalary(managers,result);
        System.out.println("first:"  + result.getFirst().getName() + "," + "second:" + result.getSecond().getName());   //first:Kuff,second:Peter

        maxminSalary(managers,result);
        System.out.println("first:"  + result.getFirst().getName() + "," + "second:" + result.getSecond().getName());   //first:Peter,second:Kuff

    }

    public static void printBuddies(Pair<? extends Employee> p){
        //通配符子类限定通常用于获取返回值，p的具体类型是Employee或其子类，都可以表示成Employee的引用
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println(first.getName() + " and " + second.getName() + " are buddies.");
    }

    public static void minmaxSalary(Manager[] m,Pair<? super Manager> result){
        if(m.length == 0){
            return;
        }
        Manager min = m[0];
        Manager max = m[0];
        for(int i = 1;i < m.length;i++){
            if(min.getSalary() > m[i].getSalary()){
                min  = m[i];
            }
            if(max.getSalary() < m[i].getSalary()){
                max = m[i];
            }
        }
        //这里result是Manager或Manager的超类，所以可以调用写入操作，即set，实际上这里result在main方法中是Employee类，无法读取，因为manager不能被赋予超类引用
        result.setFirst(min);
        result.setSecond(max);
    }

    public static void maxminSalary(Manager[] m,Pair<? super Manager> result){
        minmaxSalary(m,result);
        PairAlg.swap(result);
    }

}

class PairAlg{

    public static boolean hasNulls(Pair<?> p){
        return p.getFirst() == null || p.getSecond() == null;
    }

    public static void swap(Pair<?> p){
        //在这种情况下，swapHelper方法的参数T捕获通配符，可以确认通配符表达的的单个、确定的类型
        swapHelper(p);
    }

    public static <T> void swapHelper(Pair<T> p){
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }
}
