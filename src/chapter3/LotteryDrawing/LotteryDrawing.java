package chapter3.LotteryDrawing;

import java.util.Arrays;
import java.util.Scanner;

/** 
* 3-7，从数组中抽取不同的几个值，3-8/3-9，多维数组（略）
*/
public class LotteryDrawing {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Total numbers?");
		int totalNum = in.nextInt();
		
		System.out.println("Draw numbers?");
		int luckyNum = in.nextInt();
		
		int[] total = new int[totalNum];
		int[] lucky = new int[luckyNum];
		
		for(int i=0;i<total.length;i++) {
			total[i] = i+1;
		}
		
		for(int j=0;j<lucky.length;j++) {
			int r = (int)(Math.random()*totalNum);
			lucky[j] = total[r];
			
			//保证不会重复抽取
			total[r] = total[totalNum-1];
			totalNum--;
		}
		
		Arrays.sort(lucky);
		System.out.println(Arrays.toString(lucky));
		
		in.close();
		
	}
}
