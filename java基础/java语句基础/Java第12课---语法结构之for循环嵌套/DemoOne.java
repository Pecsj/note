public class DemoOne{
	public static void main(String[] args){
		//�ɶ���  ��׳��(�Ͻ�)  �Ż�(�ṹ ���� Ч�� �ڴ� ������ ����չ��)
		for(int x =45;x<95;x++){
			if((x-10) + (x+20) + (x/2) + (x*2) == 370){
				System.out.println("�׼ӹ��������Ϊ:"+(x-10));
				System.out.println("�Ҽӹ��������Ϊ:"+(x+20));
				System.out.println("���ӹ��������Ϊ:"+(x/2));
				System.out.println("���ӹ��������Ϊ:"+(x*2));
			}
		}
	}
}