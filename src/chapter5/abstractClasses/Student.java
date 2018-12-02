package chapter5.abstractClasses;
/** 
* @author WangPan wangpanhust@qq.com: 
* @version 2018年9月18日 下午14:33:26 
* 类说明：子类student
*/
public class Student extends Person{

	private String major;

	public Student(String aName,String aMajor){
		super(aName);
		this.major = aMajor;
	}

	public String getDescription(){
		return "a student majoring in " + major;
	}
}
