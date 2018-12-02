package chapter5.equals;
/** 
* @author WangPan wangpanhust@qq.com: 
* @version 2018年9月19日  上午11:03:59 
* 类说明：5-8、9、10，（11略，枚举类）进行equals判断、打印及hashCode
*/
public class EqualsTest {
	
	public static void main(String[] args) {
		
		Employee alice1 = new Employee("Alice Adams",200000,2020,7,3);
		Employee alice2 = alice1;
		Employee alice3 = new Employee("Alice Adams",200000,2020,7,3);
		Employee bob = new Employee("Bob Brandson",150000,2020,8,6);
		
		//==会判断两个实例是否引用同一个对象，alice1和alice3不是同一个对象，只是状态一样
		System.out.println("alice1 == alice2:" + (alice1 == alice2));	//alice1 == alice2:true
		System.out.println("alice1 == alice3:" + (alice1 == alice3));  //alice1 == alice3:false
		
		//euqals方法会最终判断两个对象的状态是否一致，即判断name、salary和hireDay
		System.out.println("alice1.equals(alice3);" + alice1.equals(alice3));	//alice1.equals(alice3);true
		System.out.println("alice1.equals(bob);" + alice1.equals(bob));		//alice1.equals(bob);false

		System.out.println("bob.toString():" + bob);	//bob.toString():chapter5.equals.Employee[name = Bob Brandson,salary = 150000.0,hireDay = 2020-08-06]

		Manager carl = new Manager("Carl Cracker",80000,2020,8,3);
		Manager boss = new Manager("Carl Cracker",80000,2020,8,3);

		boss.setBonus(10000);

		System.out.println("boss.toString():" + boss);	//boss.toString():chapter5.equals.Manager[name = Carl Cracker,salary = 80000.0,hireDay = 2020-08-03],bonus = 10000.0]
		System.out.println("Carl.equals(boss):" + carl.equals(boss));	//Carl.equals(boss):false
		
		System.out.println("alice1.hashCode()" + alice1.hashCode());	//alice1.hashCode()-763880442
		System.out.println("alice3.hashCode()" + alice3.hashCode());	//alice3.hashCode()-763880442
		System.out.println("bob.hashCode()" + bob.hashCode());		//bob.hashCode()-571344805
		System.out.println("carl.hashCode()" + carl.hashCode());	//carl.hashCode()-341695103
		System.out.println("boss.hashCode()" + boss.hashCode());	//boss.hashCode()-341695103
		
		System.out.println("carl's superclass:" + carl.getClass().getSuperclass());		//class chapter5.equals.Employee

	}


}
