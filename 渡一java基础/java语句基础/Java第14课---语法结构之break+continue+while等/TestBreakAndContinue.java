public class TestBreakAndContinue{
	public static void main(String[] args){
		int i=1;
		int j=1;
		ok:for(;i<=5;i++){
			ko:for(;j<=5;j++){
				if(j==3){
					continue ok;
				}//j==3ͣסһ�� ������һ��i++  i=2
				System.out.println("�ظ���˧һ��");
			}
		}
		//ִ��������ٴ�10   ִ����� i6  j3?
		System.out.println(i);
		System.out.println(j);



		/*
		int i=1;
		int j=1;
		ok:for(;i<=5;i++){
			ko:for(;j<=5;j++){
				if(j==3){
					break ok;
				}
				System.out.println("�ظ���Ǻ�˧");
			}
		}
		System.out.println(i);
		System.out.println(j);
		//�������2    i j�ֱ��Ǽ�?1  3
		//breakΪʲô�ն������ѭ��?    �����������    ����ѭ��һģһ��
		//���j==3ʱ��   break�ն������ѭ��----???   ��ѭ��������  ѭ�����
		*/
	}
}