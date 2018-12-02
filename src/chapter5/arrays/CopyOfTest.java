package chapter5.arrays;

import java.lang.reflect.*;
import java.util.*;
/**
* @author WangPan wangpanhust@qq.com: 
* @version 2018年9月24日 下午4:06:17 
* 类说明：5-16，利用反射动态创建数组
*/
public class CopyOfTest {

	public static void main(String[] args){
		
		int[] i = {1,2,3};
		i = (int[])goodCopyOf(i,5);
		System.out.println(Arrays.toString(i));	//[1,2,3,0,0]，新数组的长度是5，末尾补0

		String[] s = {"wong","fei"};
		s = (String[])goodCopyOf(s,1);
		System.out.println(Arrays.toString(s));	//[wong]

		System.out.println("The following call will generate an exception.");
		s = (String[]) badCopyOf(s,1);
		//Exception in thread "main" java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.String;at chapter5.arrays.CopyOfTest.main(CopyOfTest.java:23)

	}

	public static Object goodCopyOf(Object a,int newLength){
		Class cl = a.getClass();
		if(!cl.isArray()){
			return null;
		}
		Class type = cl.getComponentType();
		int length = Array.getLength(a);
		//创建一个对应类型和指定长度的新数组
		Object newArray = Array.newInstance(type,newLength);
		//src,srcPos,dst,dstPos,length
		System.arraycopy(a,0,newArray,0,Math.min(length,newLength));
		return newArray;
	}

	public static Object[] badCopyOf(Object[] a,int newLength){
		Object[] newArray = new Object[newLength];
		//这样产生的数组对象仍然是Object类，无法永久的转换为对应的类型
		System.arraycopy(a,0,newArray,0,Math.min(a.length,newLength));
		return newArray;
	}
}
