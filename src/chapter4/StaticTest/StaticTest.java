package chapter4.StaticTest;

/**
4-3，静态域，静态域不依赖域对象，通过类名直接访问
*/
public class StaticTest {
	
	public static void main(String[] args) {
		
		SecondEmployee[] staff = new SecondEmployee[3];
		
		staff[0] = new SecondEmployee("Pwter Wong",300000);
		staff[1] = new SecondEmployee("James Bond",200000);
		staff[2] = new SecondEmployee("Black Obama",100000);
		
		for(SecondEmployee e:staff) {
			e.setId();
			System.out.println("NO." + e.getId() + "，Name:" + e.getName() + "，Salary:" + e.getSalary());
		}
		
		int nextId = SecondEmployee.getNextId();
		System.out.println("Next id is:" + nextId);
		
	}
	/*
	输出：
	NO.1，Name:Pwter Wong，Salary:300000.0
	NO.2，Name:James Bond，Salary:200000.0
	NO.3，Name:Black Obama，Salary:100000.0
	Next id is:4
	 */
	
}

class SecondEmployee{
	
	private static int nextId = 1;
	
	private String name;
	private double salary;
	private int id;
	
	public SecondEmployee(String n,double s){
		this.name = n;
		this.salary =s;
		this.id = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId() {
		id = nextId;
		nextId++;
	}
	
	public static int getNextId() {
		return nextId;
	}
}
