package chapter4.ConstructorTest;
import java.util.Random;
/**
 * @author WangPan wangpanhust@qq.com:
 * @version 2018年9月17日 上午10:04:10
 * 4-5，对象构造的几种方式
 */

public class ConstructorTest {
	
	public static void main(String[] args) {
		FourthEmployee[] staff = new FourthEmployee[3];
		
		staff[0] = new FourthEmployee("Peter Wong",300000);
		staff[1] = new FourthEmployee(100000);
		staff[2] = new FourthEmployee();
		
		for(FourthEmployee e:staff) {
			System.out.println("name = " + e.getName() + ",id = " + e.getId() + ",salary = " + e.getSalary());
		}
	}
}

class FourthEmployee{
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
	
	public FourthEmployee(String aName,double aSalary) {
		this.name = aName;
		this.salary = aSalary;
	}
	
	public FourthEmployee(double aSalary) {
		//调用另一个构造器，FourthEmployee（String，double）,该实例对象 name = FourthEmployee # xxx（nextId）
		this("FourhEmployee #" + nextId,aSalary);
	}
	
	public FourthEmployee() {
		
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