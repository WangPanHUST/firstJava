package chapter4.ParamTest;

/**
*4-4，方法参数，参数是基本数据类型时，方法拷贝值，参数是对象引用时，方法拷贝引用
 方法不能改变基本类型参数
 可以改变对象参数的状态
 不能让对象引用参数引用另一个对象
*/
public class ParamTest {
	
	public static void main(String[] args) {
		
		//方法不能改变基本类型参数
		System.out.println("Testing tripleValue:");
		double percent = 10;
		System.out.println("Before:percent = :" + percent);
		tripleValue(percent);
		System.out.println("After:percent = :" + percent);
		
		//方法可以改变对象引用参数的状态
		System.out.println("Testing tripSalary:");
		ThirdEmployee e = new ThirdEmployee("wp",300000);
		System.out.println("Before:salary = :" + e.getSalary());
		tripleSalary(e);
		System.out.println("After:salary = :" + e.getSalary());
		
		//方法不能让对象引用参数引用另一个对象
		System.out.println("Testing swap:");
		ThirdEmployee x = new ThirdEmployee("James Bond",50000);
		ThirdEmployee y = new ThirdEmployee("Black Obama",60000);
		System.out.println("Before:x = :" + x.getName());
		System.out.println("Before:y = :" + y.getName());
		swap(x,y);
		System.out.println("After: x = :" + x.getName());
		System.out.println("After: y = :" + y.getName());
		
	}

	//
	public static void tripleValue(double x) {
		x = 3 * x;
		System.out.println("End of method : x = " + x);
	}
	
	public static void tripleSalary(ThirdEmployee x) {
		x.raiseSalary(200);
		System.out.println("End of method :" + x.getSalary());
	}
	
	public static void swap(ThirdEmployee x,ThirdEmployee y) {
		ThirdEmployee temp = x;
		x = y;
		y = temp;
		System.out.println("End of method :" + x.getName());
		System.out.println("End of method :" + y.getName());
	}
}

class ThirdEmployee{
	
	private String name;
	private double salary;
	
	public ThirdEmployee(String n,double s){
		this.name = n;
		this.salary = s;
	}
	
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void raiseSalary(int byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}
		
}