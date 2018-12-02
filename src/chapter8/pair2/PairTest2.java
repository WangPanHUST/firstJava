package chapter8.pair2;

import java.time.*;
import chapter8.pair1.Pair;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/10/28 11:10
 * @description 8-2，类型限定，使用extends关键字，确保进入泛型的类符合某个特定条件
 **/

public class PairTest2{

	public static void main(String[] args){
		//LocalDate类是实现了Comparable接口的
		LocalDate[] birthdays = {
			LocalDate.of(1960,12,16),
			LocalDate.of(1960,8,8),
			LocalDate.of(1990,12,6),
			LocalDate.of(2000,8,11)
		};
		Pair<LocalDate> mm = ArrayAlg.minmax(birthdays);
		System.out.println("min = " + mm.getFirst());	//min = 1960-08-08
		System.out.println("max = " +mm.getSecond());	//max = 2000-08-11
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

