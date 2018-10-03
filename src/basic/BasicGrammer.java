package basic;

import java.util.Arrays;

public class BasicGrammer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x,y=0	;
		int sqr;
		x = -1;	
		sqr = x >> 2;
//		System.out.println(sqr);
//		System.out.println((int)Math.round(y));
		
		String Hello = "Hello";
		String subString = Hello.substring(1,4);//substring��a,b������ĳ���Ϊb-a
		String sJoin = Hello.join("#","Ppp","strong");//join ����һ���ַ����ں��������ַ��м�
		int index = Hello.indexOf("l");
		
		int[] array = new int[10];
		
		for(int i = 0;i < 10;i++) {
			array[i] = i;
		}
		
		//foreachѭ��
		for(int e : array) {
			System.out.println(e);
		}
		
		//Arrays.toString�����ذ�������Ԫ�ص��ַ���
		System.out.println(Arrays.toString(array));

	}

}
