import java.util.Scanner;

public class Demo1{
	public static void main(String[] args){
		//*******	������ ����		i==1        4-->7    5-->9
		//*** ***  ������  ���ո�  ������  ����	i==2    3   1   3
		//**    **  ������  ���ո�  ������  ����	i==3    2   3   2
		//*       *  ������  ���ո�  ������  ����	i==4    1   5   1
		//�ɶ��� ��׳��(�Ͻ�) �Ż�(�ṹ ���� ���� �ڴ� ���� ��չ)  2*i-3
		Scanner input = new Scanner(System.in);
		System.out.println("������������:");
		int line = input.nextInt();
		for(int i=1;i<=line;i++){//��������
			if(i==1){//��һ�й���
				//������
				for(int j=1;j<=2*line-1;j++){
					System.out.print("*");
				}
			}else{//�����й���
				//������
				for(int j=1;j<=(line+1)-i;j++){
					System.out.print("*");
				}
				//���ո�
				for(int j=1;j<=2*i-3;j++){
					System.out.print(" ");
				}
				//������
				for(int j=1;j<=(line+1)-i;j++){
					System.out.print("*");
				}
			}
			//����
			System.out.println();
		}
	}
}