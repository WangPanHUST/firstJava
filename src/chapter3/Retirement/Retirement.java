package chapter3.Retirement;

import java.util.Scanner;

/**
* 3-3，while循环，3-4，do-while循环，3-5，for循环（略）,3-6，大数值（略）
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
		String answer;

		//while-do
		while(balance < money) {
			balance += payment;
			double interest = balance * interestRate / 100;
			balance += interest;
			years++;
		}
		
		System.out.println("You can retire in " + years + " years.");

		/*
		//do-while
		do{
			balance += payment;
			double interest = balance * interestRate / 100;
			balance += interest;
			years++;

			System.out.println("Ready to retire?(Y/N)");
			answer = Scan.nextLine();
		}while (answer.equals("N"));
		*/
		Scan.close();
		
		
	}

}
