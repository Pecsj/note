public class TestBreak{
	public static void main(String[] args){
		int i = 1;
		int j = 1;
		for(;i<=5;i++){
			for(;j<=5;j++){
				if(j==3){
					break;
				}
				System.out.println("�ظ��˧");
			}//i==1   j==3  ִ���������   i==2  j==?�Ӽ���ʼ��?3  i==3  j==3
		}
		System.out.println(i);//6
		System.out.println(j);//3
		//ѭ��ִ���˶��ٴ�10   �ظ��˧����˶��ٴ�
		//ѭ��ִ�����   i6   j3�ֱ��Ǽ�?

		/*
		for(int i=1;i<=5;i++){
			if(i==3){
				break;//��ֹ �ն� //������if������ʱ�� �ն�ѭ��
			}
			System.out.println(i);
		}
		//ִ�еĽ����ʲô?  12
		//ִ����Ϻ�   i��ֵӦ���Ǽ�? 3
		*/
	}
}