package chapter5.abstractClasses;
/** 
* @author WangPan wangpanhust@qq.com: 
* @version 2018年9月18日 下午14:37:28 
*类说明：5-4、5、6、7，抽象类、抽象方法
*/
public class PersonTest {
	public static void main(String[] args){

		Person[] people = new Person[2];

		people[0] = new Employee("James Bond",300000,2020,5,9);
		people[1] = new Student("Peter Wong","EI");

		for(Person p:people){
			System.out.println(p.getName() + "," + p.getDescription());
		}
	}
}
