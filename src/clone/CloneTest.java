package clone;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/10/2 15:32
 * @description
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

            System.out.println("original = " + original);
            System.out.println("copy = " + copy);
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
    }
}
