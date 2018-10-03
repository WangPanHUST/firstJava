package basic;

/**
* @author WangPan wangpanhust@qq.com: 
* @version 2018��9��14�� ����8:35:33 
* static����
*/
public class StaticTest {
	
	public static void main(String[] args) {
		
		secondEmployee[] staff = new secondEmployee[3];
		
		staff[0] = new secondEmployee("Pwter Wong",300000);
		staff[1] = new secondEmployee("James Bond",200000);
		staff[2] = new secondEmployee("Black Obama",100000);
		
		for(secondEmployee e:staff) {
			e.setId();
			System.out.println("NO." + e.getId() + "Name:" + e.getName() + "Salary:" + e.getSalary());
		}
		
		int nextId = secondEmployee.getNextId();
		System.out.println("Next id is:" + nextId);
		
	}
	
}

class secondEmployee{
	
	private static int nextId = 1;
	
	private String name;
	private double salary;
	private int id;
	
	public secondEmployee(String n,double s){
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
