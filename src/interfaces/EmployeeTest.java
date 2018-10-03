package interfaces;

import java.util.*;
/** 
* @author WangPan wangpanhust@qq.com: 
* @version 2018年9月25日 上午10:18:57 
* 类说明 
*/
public class EmployeeTest {

	public static void main(String[] args){

		Employee[] staff = new Employee[3];

		staff[0] = new Employee("wong",300000);
		staff[1] = new Employee("li",280000);
		staff[2] = new Employee("guo",290000);

		Arrays.sort(staff);

		for(Employee e:staff){
			System.out.println("name = " + e.getName() + ",salary = " + e.getSalary());
		}
	}
}
