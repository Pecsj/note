import java.util.Scanner;

public class DemoOne{
	public static void main(String[] args){
		//1.����һ������ score �����洢ѧ���ɼ�
		Scanner input = new Scanner(System.in);
		System.out.println("������һ��ѧ���ɼ�,���������ж�����");
		int score = input.nextInt();
		//2.���óɼ���ֵ �������ж���������
		switch(score/10){
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			System.out.println("������ ������");
			break;
		case 6:
			System.out.println("ŷҮ ��������");
			break;
		case 7:
			System.out.println("���û��а�");
			break;
		case 8:
			System.out.println("�ͱȽϺ��� Ҳ�ò�����ѧ��");
			break;
		case 9:
			System.out.println("�����ý�ѧ���� ���ҳԷ�");
			break;
		case 10:
			if(score==100){
				System.out.println("ѧ�Ա�ba");
				break;
			}
		default:
			System.out.println("û�������~~");
			break;
		}
	}
}