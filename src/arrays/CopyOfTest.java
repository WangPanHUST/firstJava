package arrays;

import java.lang.reflect.*;
import java.util.*;
/** 
* @author WangPan wangpanhust@qq.com: 
* @version 2018年9月24日 下午4:06:17 
* 类说明 
*/
public class CopyOfTest {

	public static void main(String[] args){
		
		String[] s = {"wong","fei"};
		s = (String[])goodCopyOf(s,1);
		System.out.println(Arrays.toString(s));
		
		int[] i = {1,2,3};
		i = (int[])goodCopyOf(i,5);
		System.out.println(Arrays.toString(i));
	}

	public static Object goodCopyOf(Object a,int newLength){
		Class cl = a.getClass();
		if(!cl.isArray()){
			return null;
		}
		Class type = cl.getComponentType();
		int length = Array.getLength(a);
		Object newArray = Array.newInstance(type,newLength);
		System.arraycopy(a,0,newArray,0,Math.min(length,newLength));
		return newArray;
	}
}
