import java.util.Scanner;

public class SeasonDemo{
	public static void main(String[] args){
		//1.����һ��month���� �����洢һ���·�ֵ(Scanner)
		Scanner input = new Scanner(System.in);
		System.out.println("������һ���·ݣ����������ж������ļ���");
		int month = input.nextInt();//�����Ƕ�ȡ���������   input.nextLine();��ȡ�ַ���
		//2.ͨ��month�洢��ֵ ���м��ڵ��ж�
		if(month<1 || month>12){
			System.out.println("����������ֲ������·� ��������");
		}else if(month>=3 && month<=5){
			System.out.println("����");
		}else if(month>=9 && month<=11){
			System.out.println("����");
		}else if(month>=6 && month<=8){
			System.out.println("����");
		}else{
			System.out.println("����");
		}
	}
}