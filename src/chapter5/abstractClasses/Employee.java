package chapter5.abstractClasses;

import java.time.*;
/** 
* @author WangPan wangpanhust@qq.com: 
* @version 2018年9月18日 下午14:23:35 
* 类说明：子类employee
*/
public class Employee extends Person{

	private double salary;
	private LocalDate hireDay;

	public Employee(String aName,double aSalary,int aYear,int aMonth,int aDay){
		super(aName);
		this.salary = aSalary;
		this.hireDay = LocalDate.of(aYear,aMonth,aDay);
	}

	public double getSalary(){
		return salary;
	}

	public LocalDate getHireDay(){
		return hireDay;
	}

	public String getDescription(){
		return String.format("an employee with a salary of $%.2f",salary);
	}

	public void raiseSalary(double byPercent){
		double raise = salary * byPercent / 100;
		salary += raise;
	}
}
