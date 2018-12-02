package chapter5.arrayList;

import java.util.ArrayList;
import chapter5.inheritance.Employee;
/** 
* @author WangPan wangpanhust@qq.com: 
* @version 2018年9月19日 下午5:35:53 
* 类说明：5-11，ArrayList，泛型数组，不必指出数组的大小，使用add方法添加元素，使用set方法替换元素，使用get方法访问元素
*/
public class ArrayListTest {
	
	public static void main(String[] args){

		ArrayList<Employee> staff = new ArrayList<>();

		staff.add(new Employee("Peter Wong",300000,2020,7,9));
		staff.add(new Employee("James Bond",250000,1985,6,9));
		staff.add(new Employee("Black Obama",150000,2008,6,6));

		for(Employee e : staff){
			e.raiseSalary(5);
		}

		for(Employee e : staff){
			System.out.println("name = " + e.getName() + ",salary = " + e.getSalary());
		}
	}
}
