import java.util.Scanner;

public class Test10{
	public static void main(String[] args){
		//1.��Ҫ�������洢 ���е��˺ź�����(�൱��С���ݿ�)
		String[] userBox = {"֣����","��һ����","Java"};
		int[] passwordBox = {123,666,888};
		//2.��Ҫ�û�����
		Scanner input = new Scanner(System.in);
		System.out.println("�������˺�:");
		String user = input.nextLine();//֣����
		System.out.println("����������:");
		int password = input.nextInt();
		//3.�Ƚ�
		boolean b = false;//���
		for(int i=0;i<userBox.length;i++){
			if(userBox[i].equals(user)){//�˺Ŵ��ڵ�
				if(passwordBox[i]==password){//������ȷ��
					System.out.println("��¼�ɹ�");//��¼  ��½
					b = true;
				}
				break;
			}
		}
		if(!b){
			//�û��� �� ���� ��һ������ȷ ��Ҫ���
			//b��ǵ�ֵ�������һ�����ܸ�
			System.out.println("�û������������");
		}
	}
}





