package basic;

import java.util.Arrays;
import java.util.Scanner;

/** 
* @author WangPan wangpanhust@qq.com: 
* @version 2018��9��13�� ����10:49:43 
* ��ȡ������ֲ�����
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
			
			//��֤�ѳ�ȡ�Ĳ��ٳ���
			total[r] = total[totalNum-1];
			totalNum--;
		}
		
		Arrays.sort(lucky);
		System.out.println(Arrays.toString(lucky));
		
		in.close();
		
	}
}
