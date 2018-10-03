package interfaces;
/** 
* @author WangPan wangpanhust@qq.com: 
* @version 2018年9月25日 上午10:30:36 
* 类说明 
*/
public class Employee implements Comparable<Employee>{

	private String name;
	private double salary;

	public Employee(String aName,double aSalary){
		this.name = aName;
		this.salary = aSalary;
	} 

	public String getName(){
		return name;
	}

	public double getSalary(){
		return salary;
	}

	public void raiseSalary(double byPercent){
		double raise = byPercent * salary / 100;
		salary += raise;
	}

	//
	public int compareTo(Employee other){
		return Double.compare(salary,other.salary);
	}
}
