package chapter9.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/11/12 10:37
 * @description 9-6，HashMap的使用，其中LingkedHashMap会以元素的插入顺序进行访问
 **/
public class MapTest {

    public static void main(String[] args){

        //两个类型的区别是访问时候是否按照插入的顺序进行访问，LinkedHashMap会以插入的顺序进行访问，HashMap则以hashcode的顺序进行访问
        Map<String, Employee> staff = new HashMap<>();
        //Map<String, Employee> staff = new LinkedHashMap<>();

        staff.put("501",new Employee("WP"));
        staff.put("111",new Employee("KF"));
        staff.put("000",new Employee("PW"));
        staff.put("3",new Employee("FK"));

        System.out.println(staff);  //{000=PW, 111=KF, 3=FK, 501=WP}

        //删除对应的映射，并返回这个键之前对应的值
        staff.remove("000");

        System.out.println(staff);  //{111=KF, 3=FK, 501=WP}

        //替换某个映射
        staff.put("111",new Employee("Ppp"));

        System.out.println(staff.get("111"));   //Ppp

        //lambda表达式在HashMap中的使用
        staff.forEach((k,v) -> System.out.print(v + " "));  //Ppp FK WP
    }
}

class Employee{

    private String name;

    public Employee(String aName){
        name = aName;
    }

    public String getName(){
        return name;
    }

    public String toString(){
        return name;
    }
}