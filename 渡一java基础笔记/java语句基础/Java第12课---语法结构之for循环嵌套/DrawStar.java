import java.util.Scanner;

public class DrawStar{
	public static void main(String[] args){
		for(int i=1;i<=4;i++){//��������
			//��ռλ��
			for(int j=1;j<=4-i;j++){
				System.out.print(" ");
			}
			//������
			for(int j=1;j<=i;j++){
				System.out.print("*");
			}
			//����
			System.out.println();
		}
		




		/*for(int i=1;i<=4;i++){//��������
			//������
			for(int j=1;j<=i;j++){
				System.out.print("*");
			}
			//����
			System.out.println();
		}*/
		//i==5  5<=4  
		//	j==1  j<=3
		//	*
		//	**
		//	***
		//	****
		//	|



		/*
		int count = 4;//ÿһ�����ǵĸ�������
		for(int i=1;i<=4;i++){
			for(int j=1;j<=count;j++){
				System.out.print("*");
			}
			System.out.println();
		}//�ü������������4��һ��������
		//i j�ֱ������ʲô?    i���Ƶ�������  j���Ƶ���ÿһ�����ǵĸ���
		//˫��ѭ��Ƕ��ִ�еĴ����ǳ˻��Ĺ�ϵ
		//   i==5   5<=4 false
		//           j==5  5<=4 true
		//	****
		//             ****
		//             ****
		//             ****
		//             |
		*/


		//������
		/*System.out.println("�𾴵Ŀͻ�,������Ҫ������?");
		Scanner input = new Scanner(System.in);
		int count = input.nextInt();
		for(int i=1;i<=count;i++){
			System.out.print("*");
		}*/
	}
}