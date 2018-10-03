package equals;

import java.time.*;
import java.util.Objects;
/** 
* @author WangPan wangpanhust@qq.com: 
* @version 2018年9月19日  上午10:36:15 
* 类说明 
*/
public class Employee {

	private String name;
	private double salary;
	private LocalDate hireDay;

	public Employee(String aName,double aSalary,int aYear,int aMonth,int aDay){
		this.name = aName;
		this.salary = aSalary;
		this.hireDay = LocalDate.of(aYear,aMonth,aDay);
	}

	public String getName(){
		return name;
	}

	public double getSalary(){
		return salary;
	}

	public LocalDate getHireDay(){
		return hireDay;
	}

	public void raiseSalary(double byPercent){
		double raise = byPercent * salary / 100;
		salary += raise;
	}

	public boolean equals(Object otherObject){

		//是否引用同一个对象
		if(this == otherObject){
			return true;
		}

		//显示参数是null对象
		if(otherObject == null){
			return false;
		}

		//类的类型不匹配
		if(getClass() != otherObject.getClass()){
			return false;
		}

		//otherObject确定是一个非null的Employee对象
		Employee other = (Employee) otherObject;

		return Objects.equals(name,other.name) && salary == other.salary 
				&& Objects.equals(hireDay,other.hireDay);
	}

	public int hashCode(){
		return Objects.hash(name,salary,hireDay);
	}
	
	//直接print（Employee），会调用Employee的toString方法
	public String toString(){
		return getClass().getName() + "[name = " + name +",salary = " + salary
				+ ",hireDay = " + hireDay + "]";
	}
}
