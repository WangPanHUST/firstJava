package inheritance;

import java.time.LocalDate;

/** 
* @author WangPan wangpanhust@qq.com: 
* @version 2018年9月17日 下午8:57:13 
* 类说明：超类 Employee
*/
public class Employee {
	
	private String name;
	private double salary;
	private LocalDate hireDay;
	
	
	public Employee(String n,double s,int year,int month,int day) { 
		
		this.name = n;
		this.salary = s;
		this.hireDay = LocalDate.of(year, month, day);
		
	}
	
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public LocalDate getHireDay() {
		return hireDay;
	}
	
	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	
}
