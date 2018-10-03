package basic;

import java.util.Scanner;

/** 
* @author WangPan wangpanhust@qq.com: 
* @version 2018��9��12�� ����8:15:13 
* �����������ޣ�whileѭ��
*/
public class Retirement {
	
	public static void main(String[] args) {
		
		Scanner Scan = new Scanner(System.in);
		
		System.out.println("How much money you need when retire?");
		double money = Scan.nextDouble();
		
		System.out.println("How much money you contribute every year?");
		double payment = Scan.nextDouble();
		
		System.out.println("What about the interestrate?");
		int interestRate = Scan.nextInt();
		
		double balance = 0.0;
		int years = 0;

		while(balance < money) {
			balance += payment;
			double interest = balance * interestRate / 100;
			balance += interest;
			years++;//����whileѭ��
		}
		
		System.out.println("You can retire in " + years + " years.");
		
		Scan.close();
		
		
	}

}
