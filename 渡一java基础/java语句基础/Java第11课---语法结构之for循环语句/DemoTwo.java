import java.util.Scanner;

public class DemoTwo{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("��������һ�����ڣ���������ָ��ѧϰ�ƻ�");
		int day = input.nextInt();
		switch(day){
		case 1:
		case 3:
		case 5:
			System.out.println("Ӧ��ѧϰ���");
			break;
		case 2:
		case 4:
		case 6:
			System.out.println("Ӧ��ѧϰӢ��");
			break;
		case 7:
			System.out.println("���?���������Ӣ�ı����");
			break;
		default:
			System.out.println("��Ҫ����������ô?�����ڵģ��ú�ѧϰ");
			break;
		}
	}
}