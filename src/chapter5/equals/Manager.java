package chapter5.equals;
/** 
* @author WangPan wangpanhust@qq.com: 
* @version 2018年9月19日 上午10:53:02 
* 类说明：子类Manager，equals和toString方法的改动
*/
public class Manager extends Employee{
	private double bonus;

	public Manager(String aName,double aSalary,int aYear,int aMonth,int aDay){
		super(aName,aSalary,aYear,aMonth,aDay);
		this.bonus = 0;
	}

	public double getSalary(){
		//使用super获取超类中定义的salary
		double baseSalary = super.getSalary();
		return baseSalary + bonus;
	}

	public void setBonus(double aBonus){
		this.bonus = aBonus;
	}

	public boolean equals(Object otherObject){
		if(!super.equals(otherObject)){
			return false;
		}

		Manager other = (Manager) otherObject;
		return bonus == other.bonus;
	}

	public String toString(){
		return super.toString() + ",bonus = " + bonus + "]";
	}
}


