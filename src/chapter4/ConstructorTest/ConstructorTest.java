package chapter4.ConstructorTest;
import java.util.Random;
/**
 * @author WangPan wangpanhust@qq.com:
 * @version 2018��9��17�� ����10:04:10
 * 4-5��������ļ��ַ�ʽ
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
	
	public FourthEmployee(String aName,double aSalary) {
		this.name = aName;
		this.salary = aSalary;
	}
	
	public FourthEmployee(double aSalary) {
		//������һ����������FourthEmployee��String��double��,��ʵ������ name = FourthEmployee # xxx��nextId��
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