package chapter5.objectAnalyzer;

import java.util.ArrayList;
import chapter5.inheritance.Employee;
/** 
* @author WangPan wangpanhust@qq.com: 
* @version 2018年9月24日 下午2:27:51 
* 类说明：5-14、15，运行时利用反射分析对象
*/
public class ObjectAnalyzerTest {
	public static void main(String[] args){
//		ArrayList<Integer> squares = new ArrayList<>();
//		for(int i=1;i<=5;i++){
//			squares.add(i * i);
//		}
//		System.out.println(squares);
		ArrayList<Employee> staff = new ArrayList<>(3);
		
		staff.add(new Employee("Peter Wong",300000,2020,7,9));
		staff.add(new Employee("James Bond",250000,1985,6,9));
		staff.add(new Employee("Black Obama",150000,2008,6,6));

		System.out.println(new ObjectAnalyzer().toString(staff));
	}
}
