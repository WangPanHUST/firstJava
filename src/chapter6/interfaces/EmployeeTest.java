package chapter6.interfaces;

import java.util.*;
/** 
* @author WangPan wangpanhust@qq.com: 
* @version 2018年9月25日 上午10:18:57 
* 类说明：6-1、2，理解接口的含义，这里是Comparable接口，便于Array进行排序
*/
public class EmployeeTest {

	public static void main(String[] args){

		Employee[] staff = new Employee[3];

		staff[0] = new Employee("wong",300000);
		staff[1] = new Employee("li",280000);
		staff[2] = new Employee("guo",290000);

		//根据雇员的薪水进行排序
		Arrays.sort(staff);

		for(Employee e:staff){
			System.out.println("name = " + e.getName() + ",salary = " + e.getSalary());
		}
	}
}
