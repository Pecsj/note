
import java.util.Scanner;

public class DiceGame{
	public static void main(String[] args){
		//1.���ҡ���ӵĹ���   �������һ�����ӵ���  1-6����
		//Math--->Scanner(1.import 2.new 3.input.next();)
		double value = Math.random();//�з�Χ[0.0-1.0)  0.0----0.99999999
		int number = (int)(value*6+1);
		//2.����Ҳ²��С     �� С
		Scanner input = new Scanner(System.in);
		System.out.println("�����С ������");
		String choose = input.nextLine();//�����Ƕ�ȡ���������
		//3.�Ƚϵ�����²���
		System.out.println("����ҡ���ĵ���Ϊ:"+number);
		//   (����1 2 3 ͬʱ С) ���� (����4 5 6 ͬʱ ��)
		//   (number<=3 && choose.equals("С")) || (number>3 && choose.equals("��"))
		//   ==  equals();����
		//   "a"=="b"   "a".equals("b");
		if((number<=3 && choose.equals("С")) || (number>3 && choose.equals("��"))){
			System.out.println("��ϲ�� �¶���");
		}else{
			System.out.println("�Բ��� �´��� ��2��Ǯ");
		}
	}
}