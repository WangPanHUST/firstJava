package chapter5.inheritance;

/** 
* @author WangPan wangpanhust@qq.com: 
* @version 2018年9月17日 下午8:44:50 
* 类说明：5-1、2、3，继承
*/
public class ManagerTest {
	public static void main(String[] args){
		Manager boss = new Manager("Peter Wong",300000,2020,7,5);
		boss.setBonus(100000);

		Employee[] staff = new Employee[3];
		
		//超类变量引用子类对象，staff[0]是Employee变量，被赋予Manager对象
		staff[0] = boss;
		staff[1] = new Employee("James Bond",200000,2020,9,6);
		staff[2] = new Employee("Black Obama",150000,2020,10,6);

		for(Employee e:staff){
			System.out.println("name = " + e.getName() + ",salary = " + e.getSalary());
		}
	}
}



