package basic;

import java.util.Scanner;

public class testInput{

	public static void main(String[] args){

		String ans = "";
		Answer answer = new Answer();
		ans = answer.getAnswer();
		System.out.println("end");

	}
}

class Answer{

	//private String ans;

	public Answer(){

	}

	public String getAnswer(){
		String ans = "";
		try(Scanner in = new Scanner(System.in)){
			ans = in.nextLine();
			System.out.println("current word:" + ans);

			//控制台输入的y，与直接让ans = "y"，不是等价的？
			while(!ans.equals("y")){
				ans = in.nextLine();
				System.out.println(ans);
				// ans = "y";
				// System.out.println(ans);
				System.out.println(ans.equals("y"));
			}
			System.out.println("now word:" + ans);
		}
		return ans;
	}
}