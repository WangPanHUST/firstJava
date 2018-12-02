package chapter5.abstractClasses;
/** 
* @author WangPan wangpanhust@qq.com: 
* @version 2018年9月18日 下午14:22:06 
* 类说明：抽象类，只用于派生子类
  抽象类可以不含抽象方法，含抽象方法的类必须是抽象类
  可以声明抽象类对象，但必须引用非抽象类子类对象
  抽象方法以abstract修饰，只用声明返回类型，方法名和所需参数，无方法体
*/
public abstract class Person {
	private String name;
	//抽象方法，在子类中实现
	public abstract String getDescription();
	
	public Person(String aName){
		this.name = aName;
	}

	public String getName(){
		return name;
	}
}	
