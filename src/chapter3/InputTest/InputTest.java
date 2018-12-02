package chapter3.InputTest;
import java.io.File;
import java.util.*;

/**
 * 3-2，从控制台读取输入，并打印信息
 */

public class InputTest {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		System.out.println("What's your name?");
		String Name = in.nextLine();

		System.out.println("How old are you?");
		int age = in.nextInt();

		System.out.println("Hello," + Name + "," + age + "years old.");

	}
}
