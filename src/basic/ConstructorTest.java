package basic; /**
* @author WangPan wangpanhust@qq.com: 
* @version 2018��9��17�� ����10:04:10 
* ��˵�� 
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
	
	//��̬��ʼ����
	static {
		Random generator = new Random();
		nextId = generator.nextInt(10000);
	}
	
	//��ʼ����
	{
		id = nextId;
		nextId++;
	}
	
	public fourthEmployee(String aName,double aSalary) {
		this.name = aName;
		this.salary = aSalary;
	}
	
	public fourthEmployee(double aSalary) {
		//������һ����������fourthEmployee��String��double��,��ʵ������ name = fourthEmployee # xxx��nextId��
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