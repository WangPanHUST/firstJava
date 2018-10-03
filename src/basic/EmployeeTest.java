package basic;

import java.time.*;
/** 
* @author WangPan wangpanhust@qq.com: 
* @version 2018��9��14�� ����10:00:10 
* �û��Զ�����
*/
public class EmployeeTest {
	
	public static void main(String[] args) {
		
		Employee[] staff = new Employee[3];
		
		staff[0] = new Employee("Peter Wong",300000,2020,7,8);
		staff[1] = new Employee("James Bond",280000,2020,7,9);
		staff[2] = new Employee("LN",270000,2020,7,6);
		
		for(Employee e:staff) {
			e.raiseSalary(5);
		}
		
		for(Employee e:staff) {
			System.out.println(e.getName() + "'s salary is:" + e.getSalary() + ",hireDay is " + e.getHireDay());
		}
		
	}
}


class Employee{	
	
	private String name;
	private double salary;
	private LocalDate hireDay;
	
	//constructor ��Ҫ������ĳ�ʼ״̬,constructor���ǰ�����new��������ִ�б����ã����ܶ�һ���Ѿ����ڵĶ�����ù�����
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