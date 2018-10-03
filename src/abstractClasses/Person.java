package abstractClasses;
/** 
* @author WangPan wangpanhust@qq.com: 
* @version 2018年9月18日 下午14:22:06 
* 类说明：子类preson
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
