package basic;

import java.io.File;
import java.util.*;

public class InputTest {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("What's your name?");
		String Name = in.nextLine();
		
		System.out.println("Hello" + Name);
		
		in.close();
		
		//File f = new File("C:" + File.separator + "Users" + File.separator + "WangPan" + File.separator + "Desktop" + File.separator +"test.txt" );
		File f = new File("D:\\test.txt");
		Scanner Scan = null;
		try {
			//��ȡ�ļ�����ʹ��try/catch�������쳣������ᱨFileNotFoundException
			//try�Ŀ��������ڶ���ı����޷����ⲿʹ�ã����ScanҪ�������ⲿ
			Scan = new Scanner(f);
		}catch(Exception e){
			
		}
		
		StringBuffer Content = new StringBuffer();
		while(Scan.hasNext()) {
			Content.append(Scan.next()).append("\n");
		}
		
		System.out.println(Content);
		
		Scan.close();
		
	}
}
