package basic;

/**
* @author WangPan wangpanhust@qq.com: 
* @version 2018��9��15�� ����10:12:08 
* ������������
*/
public class ParamTest {
	
	public static void main(String[] args) {
		
		//����������һ�������������͵Ĳ���������ֵ�ͻ򲼶��ͣ�
		System.out.println("Testing tripleValue:");
		double percent = 10;
		System.out.println("Before:percent = :" + percent);
		tripleValue(percent);
		System.out.println("After:percent = :" + percent);
		
		//һ���������Ըı�һ�����������״̬����Ϊ�����ж���Ͷ���Ŀ���ͬʱ����ͬһ������
		System.out.println("Testing tripSalary:");
		thirdEmployee e = new thirdEmployee("wp",300000);
		System.out.println("Before:salary = :" + e.getSalary());
		tripleSalary(e);
		System.out.println("After:salary = :" + e.getSalary());
		
		//main������swap�������ڴ��е�λ�ò�ͬ���洢��x��y�ĵ�ַ��һ����
		System.out.println("Testing swap:");
		thirdEmployee x = new thirdEmployee("James Bond",50000);
		thirdEmployee y = new thirdEmployee("Black Obama",60000);
		System.out.println("Before:x = :" + x.getName());
		System.out.println("Before:y = :" + y.getName());
		swap(x,y);
		System.out.println("After: x = :" + x.getName());
		System.out.println("After: y = :" + y.getName());
		
	}
	
	public static void tripleValue(double x) {
		x = 3 * x;
		System.out.println("End of method : x = " + x);
	}
	
	public static void tripleSalary(thirdEmployee x) {
		x.raiseSalary(200);
		System.out.println("End of method :" + x.getSalary());
	}
	
	public static void swap(thirdEmployee x,thirdEmployee y) {
		thirdEmployee temp = x;
		x = y;
		y = temp;
		System.out.println("End of method :" + x.getName());
		System.out.println("End of method :" + y.getName());
	}
}

class thirdEmployee{
	
	private String name;
	private double salary;
	
	public thirdEmployee(String n,double s){
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