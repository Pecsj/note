public class TestWhile{
	public static void main(String[] args){
		int i = 1;
		while(i<=4){
			//���ո�ռλ
			int j = 1;
			while(j<=4-i){
				System.out.print(" ");
				j++;
			}
			//������
			int k = 1;
			while(k<=2*i-1){
				System.out.print("*");
				k++;
			}
			//����
			System.out.println();
			i++;
		}














		/*
		int sum = 120;//��ʾˮ���е�ˮ
		int hour = 0;//��¼����Сʱ�� ?
		while(sum>0){
			sum+=18;
			sum-=30;
			hour++;//��¼һ��Сʱ��
			System.out.println("����ѭ�����:"+sum);
		} 
		System.out.println("����"+hour+"Сʱ��ˮ���");
		/*

		/*
		int i = 10;
		do{
			System.out.println("ִ��ing:"+i);//12345
			i++;
		}while(i<=5);
		*/

		/*
		int i = 10;
		while(i<=5){
			System.out.println("ִ��ing:"+i);//12345
			i++;
		}
		System.out.println("ִ�����:"+i);
		//ִ�����ʲô? ִ����Ϻ� i==��
		*/
	}
}