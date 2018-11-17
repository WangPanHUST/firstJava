package pair2;

import java.time.*;
import pair1.Pair;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/10/28 11:10
 * @description
 **/

public class PairTest2{

	public static void main(String[] args){
		LocalDate[] birthdays = {
			LocalDate.of(1968,11,16),
			LocalDate.of(1965,7,8),
			LocalDate.of(1995,11,6),
			LocalDate.of(2008,7,11)
		};
		Pair<LocalDate> mm = ArrayAlg.minmax(birthdays);
		System.out.println("min = " + mm.getFirst());
		System.out.println("max = " +mm.getSecond());
	}
}

class ArrayAlg{

	public static <T extends Comparable> Pair<T> minmax(T[] a){
		if(a == null || a.length == 0){
			return null;
		}
		T min = a[0];
		T max = a[0];
		for(int i = 1;i < a.length;i++){
			if(min.compareTo(a[i]) > 0){
				min = a[i];
			}
			if(max.compareTo(a[i]) < 0){
				max = a[i];
			}
		}
		return new Pair<>(min,max);
	}
}


//class Pair<T>{
//
//	private T first;
//	private T second;
//
//	public Pair(){
//		this.first = null;
//		this.second = null;
//	}
//	public Pair(T aFirst,T aSecond){
//		this.first = aFirst;
//		this.second = aSecond;
//	}
//
//	public T getFirst(){
//		return first;
//	}
//	public T getSecond(){
//		return second;
//	}
//
//	public void setFirst(T newFirst){
//		first = newFirst;
//	}
//	public void setSecond(T newSecond){
//		second = newSecond;
//	}
//}