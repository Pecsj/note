public class TestContinue{
	public static void main(String[] args){
		int i=1;
		int j=1;
		for(;i<=5;i++){
			for(;j<=5;j++){
				if(j==3){
					continue;
				}
				System.out.println("�ظ���ĺ�˧");
			}//i==1 j==6 ���4��  i==2   j==?��ʼ��6  i==3 j==6
		}
		System.out.println(i);
		System.out.println(j);
		//ѭ��ִ�й�����������ٴ�  20 
		//ѭ��ִ����Ϻ�   i6  j6







		/*
		for(int i=1;i<=5;i++){
			if(i==3){
				continue;//�նϱ���ѭ��  ����ִ����һ��ѭ��
			}
			System.out.println(i);
		}
		//ִ�й�����i���  1245
		//ִ��ѭ����� ����i  6
		*/
	}
}