package chapter5.reflection;

import java.util.*;
import java.lang.reflect.*;
/** 
* @author WangPan wangpanhust@qq.com: 
* @version 2018年9月22日 上午10:50:24 
* 类说明:5-13，利用反射打印一个类的详细信息
*/
public class ReflectionTest {
	public static void main(String[] args){
		//read class name from command line args or user input
		String name;
		if(args.length > 0){
			name = args[0];
		}
		else{
			Scanner in = new Scanner(System.in);
			System.out.println("Enter class name (e.g. java.util.Date):");
			name = in.next();
		}

		try{
			//打印类名和超类名(if != Object)
			Class cl = Class.forName(name);//cl = java.util.Date.class or cl LocalDate.getClass(), LocalDate is a instance of java.util.Date
			Class supercl = cl.getSuperclass();
			String modifiers = Modifier.toString(cl.getModifiers());
			if(modifiers.length() > 0){
				System.out.print("class " + name);
			}
			if(supercl != null && supercl != Object.class){
				System.out.print(" extends " + supercl.getName());
			}
			System.out.print("{\n");
			printFields(cl);
			printConstructors(cl);
			printMethods(cl);
			System.out.print("\n}");
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		System.exit(0);
	}

/**
 打印全部的构造器
*/
public static void printConstructors(Class cl){

	Constructor[] constructors = cl.getDeclaredConstructors();


	for(Constructor c : constructors){
		String name = c.getName();
		System.out.print("  ");
		String modifiers = Modifier.toString(c.getModifiers());
		if(modifiers.length() > 0){
			System.out.print(modifiers + " ");//e.g. public
		}
		System.out.print(name + "(");

		//参数的类型
		Class[] paramTypes = c.getParameterTypes();
		for(int i = 0;i < paramTypes.length;i++){
			if(i > 0){
				System.out.print(",");
			}
			System.out.print(paramTypes[i].getName());			
		}
		System.out.println(")");
	}
	System.out.println();
}

/**
打印所有的方法
*/
public static void printMethods(Class cl){

	Method[] methods =  cl.getDeclaredMethods();

	for(Method m : methods){
		Class retType = m.getReturnType();
		String name  = m.getName();

		System.out.print("  ");

		//print modifiers,return type and method name 
		String modifiers = Modifier.toString(m.getModifiers());
		if(modifiers.length() > 0){
			System.out.print(modifiers + " ");
		}
		System.out.print(retType.getName() + " " + name + "(");

		//print paramater types
		Class[] paramTypes = m.getParameterTypes();
		for(int i = 0;i < paramTypes.length;i++){
			if(i > 0){
				System.out.print(paramTypes[i].getName());
			}
		}
		System.out.println(")");
	}
}

/**
打印所有的域
*/
public static void printFields(Class cl){

	Field[] fields = cl.getDeclaredFields();


	for(Field f : fields){
		Class type = f.getType();
		String name = f.getName();
		System.out.print("  ");

		String modifiers = Modifier.toString(f.getModifiers());
		if(modifiers.length() > 0){
			System.out.print(modifiers + " ");
		}
		System.out.println(type.getName() + " " + name + ";");
	}
	System.out.println();
}

}
/*
输出：
Enter class name (e.g. java.util.Date):
chapter5.inheritance.Employee
class chapter5.inheritance.Employee{
  private java.lang.String name;
  private double salary;
  private java.time.LocalDate hireDay;

  public chapter5.inheritance.Employee(java.lang.String,double,int,int,int)

  public java.lang.String getName()
  public void raiseSalary()
  public double getSalary()
  public java.time.LocalDate getHireDay()

}
 */