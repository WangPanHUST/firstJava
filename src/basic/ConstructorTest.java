package basic; /**
* @author WangPan wangpanhust@qq.com: 
* @version 2018年9月17日 上午10:04:10 
* 类说明 
*/
import java.util.Random;

public class ConstructorTest {
	
	public static void main(String[] args) {
		fourthEmployee[] staff = new fourthEmployee[3];
		
		staff[0] = new fourthEmployee("Peter Wong",300000);
		staff[1] = new fourthEmployee(100000);
		staff[2] = new fourthEmployee();
		
		for(fourthEmployee e:staff) {
			System.out.println("name = " + e.getName() + ",id = " + e.getId() + ",salary = " + e.getSalary());
		}
	}
}

class fourthEmployee{
	private static int nextId;
	
	private int id;
	private String name = "";
	private double salary;
	
	//静态初始化块
	static {
		Random generator = new Random();
		nextId = generator.nextInt(10000);
	}
	
	//初始化块
	{
		id = nextId;
		nextId++;
	}
	
	public fourthEmployee(String aName,double aSalary) {
		this.name = aName;
		this.salary = aSalary;
	}
	
	public fourthEmployee(double aSalary) {
		//调用另一个构造器，fourthEmployee（String，double）,该实例对象 name = fourthEmployee # xxx（nextId）
		this("fourhEmployee #" + nextId,aSalary);
	}
	
	public fourthEmployee() {
		
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
	
	
}