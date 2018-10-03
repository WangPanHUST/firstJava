package equals;
/** 
* @author WangPan wangpanhust@qq.com: 
* @version 2018年9月19日  上午11:03:59 
* 类说明
*/
public class EqualsTest {
	
	public static void main(String[] args) {
		
		Employee alice1 = new Employee("Alice Adams",200000,2020,7,3);
		Employee alice2 = alice1;
		Employee alice3 = new Employee("Alice Adams",200000,2020,7,3);
		Employee bob = new Employee("Bob Brandson",150000,2020,8,6);
		
		//==会判断两个实例是否引用同一个对象，alice1和alice2不是同一个对象，只是状态一样
		System.out.println("alice1 == alice2:" + (alice1 == alice2));	
		System.out.println("alice1 == alice3:" + (alice1 == alice3));
		
		//euqals方法会最终判断两个对象的状态是否一致，即判断name、salary和hireDay
		System.out.println("alice1.equals(alice3);" + alice1.equals(alice3));
		System.out.println("alice1.equals(bob);" + alice1.equals(bob));

		System.out.println("bob.toString():" + bob);

		Manager carl = new Manager("Carl Cracker",80000,2020,8,3);
		Manager boss = new Manager("Carl Cracker",80000,2020,8,3);

		boss.setBonus(10000);

		System.out.println("boss.toString():" + boss);
		System.out.println("Carl.equals(boss):" + carl.equals(boss));
		
		System.out.println("alice1.hashCode()" + alice1.hashCode());
		System.out.println("alice3.hashCode()" + alice3.hashCode());
		System.out.println("bob.hashCode()" + bob.hashCode());
		System.out.println("carl.hashCode()" + carl.hashCode());
		System.out.println("boss.hashCode()" + boss.hashCode());
		
		System.out.println(carl.getClass().getSuperclass());

	}


}
