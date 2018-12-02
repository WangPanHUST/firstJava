package chapter4.CalenderTest;

import java.time.*;
/*
 4-1，方法演示，访问器和更改器
 */

public class CalenderTest{

	public static void main(String[] args){
		LocalDate date = LocalDate.now();
		int month = date.getMonthValue();
		int today = date.getDayOfMonth();

		//获得当月1号是星期几
		date = date.minusDays(today-1);
		DayOfWeek weekday = date.getDayOfWeek();
		int value = weekday.getValue();

		System.out.println("Mon Tue Wed Thu Fri Sat Sun");
		for(int i = 1;i < value;i++){
			System.out.print("    ");
		}
		
		//只要日期还在当月就输出该天
			while(date.getMonthValue() == month){
				//%d表示输出整数
				System.out.printf("%3d",date.getDayOfMonth());
				if(date.getDayOfMonth() == today){
					System.out.print("*");
				}
				else{ 
					System.out.print(" ");
				}
				
				date = date.plusDays(1);
				if(date.getDayOfWeek().getValue() == 1){
					System.out.println();
				}
			}
			
			if(date.getDayOfWeek().getValue() != 1){
					System.out.println();
				}
		
	}
}
/*
 输出
 Mon Tue Wed Thu Fri Sat Sun
              1   2   3   4
  5   6   7   8   9  10  11
 12  13  14  15  16  17  18
 19  20  21  22  23  24  25
 26  27  28* 29  30
 */