package chapter5.objectAnalyzer;

import java.lang.reflect.*;
import java.util.ArrayList;
/** 
* @author WangPan wangpanhust@qq.com: 
* @version 2018年9月23日 上午11:04:36 
* 类说明 
*/
public class ObjectAnalyzer {

	private ArrayList<Object> visited = new ArrayList<>();

	/**
	Converts an object to a string representation that lists all fields
	@param obj an object
	@return a string with the object's class name and all fields names and values
 	*/

 	public String toString(Object obj){

 		if(obj == null){
 			return "null";
 		}
 		if(visited.contains(obj)){
 			return "...";
 		}
 		visited.add(obj);

 		Class cl = obj.getClass();

 		if(cl == String.class){
 			return (String)obj;
 		}
 		if(cl.isArray()){
 			String r = cl.getComponentType() + "[] {";
 			for(int i=0;i<Array.getLength(obj);i++){
 				if(i>0){
 					r += ",";
 				}
 				Object val = Array.get(obj,i);
 				if(cl.getComponentType().isPrimitive()){
 					r += val;
 				}else{
 					r += toString(val);//递归调用
 				}
 			}
 			return r +"}";
 		}
 		
 		String r = cl.getName();
 		//inspect the fields of this class and all superclasses
 		do{
 			r += "[";
 			Field[] fields = cl.getDeclaredFields();
 			AccessibleObject.setAccessible(fields,true);

 			for(Field f:fields){
 				if(!Modifier.isStatic(f.getModifiers())){
 					if(!r.endsWith("[")){
 						r += ",";
 					}
 					r += f.getName() + "=";
 					try{
 						Class type = f.getType();
 						Object val = f.get(obj);
 						
 						if(type.isPrimitive()){
 							r += val;
 						}else{
 							r += toString(val);
 						}
 					}catch(Exception e){
 						e.printStackTrace();
 					}
 					
 				}
 			}
 			r += "]";
 			cl = cl.getSuperclass();
 			if(cl != null) {
 				System.out.println(cl.getName());
 			}
 		}while(cl != null);

 		return r;
 	}
}
