package clone;

import java.util.Date;
import java.util.GregorianCalendar;
/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/10/2 15:07
 * @description
 **/
public class Employee implements Cloneable {

    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String aName,double aSalary){
        this.name = aName;
        this.salary = aSalary;
        //都要初始化！
        hireDay = new Date();
    }

    public Employee clone() throws CloneNotSupportedException{

        //call Object.clone()
        Employee cloned = (Employee)super.clone();

        //clone mutable fields
        cloned.hireDay = (Date)hireDay.clone();

        return cloned;
    }

    public void setHireDay(int year,int month,int day){
        Date newHireDay = new GregorianCalendar(year,month-1,day).getTime();
        hireDay.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPercent){
        double raise = byPercent * salary / 100;
        salary += raise;
    }

    //重写toString方法，方便打印，否则会调用Object中的toString方法，这个会打印hash码这些东西
    public String toString(){
        return "Employee[name = " + name + ",salary = " + salary + ",hireday = " + hireDay + "]";

    }
}
























