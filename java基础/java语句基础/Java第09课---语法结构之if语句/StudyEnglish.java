import java.util.Scanner;

public class StudyEnglish{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("��������һ�����֣����������Ӧ��Ӣ������");
		int day = input.nextInt();//���Զ�ȡ�������������   input.nextLine();��ȡ�ַ���
		if(day==1){
			System.out.println("monday");
		}else if(day==2){
			System.out.println("tuesday");
		}else if(day==3){
			System.out.println("wednesday");
		}else if(day==4){
			System.out.println("thursday");
		}else if(day==5){
			System.out.println("friday");
		}else if(day==6){
			System.out.println("saturday");
		}else if(day==7){
			System.out.println("sunday");
		}else{
			System.out.println("��Ѿ�в��� ���ú���");
		}
	}
}