package chapter5.inheritance;
/** 
* @author WangPan wangpanhust@qq.com: 
* @version 2018年9月17日 下午8:57:23 
* 类说明：子类Manager
*/
public class Manager extends Employee{
	
	private double bonus;

	public Manager(String aName,double aSalary,int aYear,int aMonth,int aDay){
		//super调用超类的构造器
		super(aName,aSalary,aYear,aMonth,aDay);
		bonus = 0;
	}

	public double getSalary(){
		//super调用超类的方法
		double salary = super.getSalary();
		return salary + bonus;
	}

	public void setBonus(double aBonus){
		bonus = aBonus;
	}
}
