public class Test{
	public static void main(String[] args){
		int a = 1;
		int b = 2;
		//��ʽһ ���õ������ռ�
		//int c = a;
		//a = b;
		//b = c;
		//��ʽ��  �����������ֵĺ�
		//a = a+b;
		//b = a-b;
		//a = a-b;
		//��ʽ��  �����������������м�ֵ
		a = a^b;
		b = a^b;
		a = a^b;
		System.out.println(a);//2
		System.out.println(b);//1
	}
}