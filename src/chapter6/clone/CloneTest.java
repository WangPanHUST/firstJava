package chapter6.clone;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/10/2 15:32
 * @description 6-4、5，接口实例，深拷贝
 **/
public class CloneTest {

    public static  void main(String[] args){

        try{
            Employee original = new Employee("Peter",300000);
            original.setHireDay(2020,7,9);

            Employee copy = original.clone();
            copy.raiseSalary(10);

            //深拷贝其中的可变部分
            copy.setHireDay(2020,8,6);

            System.out.println("original = " + original);   //original = Employee[name = Peter,salary = 300000.0,hireday = Thu Jul 09 00:00:00 CST 2020]
            System.out.println("copy = " + copy);   //copy = Employee[name = Peter,salary = 330000.0,hireday = Thu Aug 06 00:00:00 CST 2020]
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
    }
}
