public class TestArray{
	public static void main(String[] args){
		int a = 10;
		int b = a;
		b = 100;
		System.out.println(a);//?  10

		int[] x = new int[]{10,20,30};//�ظ�x ��¼һ�����Һ���  3��ͬѧ  С��y  �������һ��ͬѧ��վ
		//ջ�ڴ��е�С����  ���Ͷ�����ֻ�ܴ洢���ֶ���  ������ֻ�ܴ�һ��
		//����new�ؼ���  �൱�� �ڶ��ڴ������뿪��һ���µĿռ�
		//�����ڶ��ڴ�Ŀռ���̬  ��һ�������ĵ�ַ
		//�������ͱ����ռ�洢����ֵ  ���ݵľ���ֵ   һ���ı� ��һ������
		//�������ͱ����ռ�洢���ǵ�ַ(����)  ���ݵľ�������  һ���ı� ��һ�����Ÿı�
		int[] y = x;
		y[0] = 100;
		System.out.println(x[0]);//?   100



		/*
		//NegativeArraySizeException ����ʱ�쳣 ���������ʱ�򳤶ȸ��˸��� ����ĳ��Ȳ��Ϸ�
		int[] array = new int[5];
		array[0] = 10;
		array[1] = 20;
		array[5] = 100;//ArrayIndexOutOfBoundsException
		*/

		//int[] array = new int[]{10,20,30,40,50};
		//ͨ��Ԫ���������е�λ��index(���� �±�)������
		//array[index];
		//��������ȡ��ĳһ��λ�õ�Ԫ��
		//int value = array[4];
		//System.out.println(value);
		//�������ڵ�ĳһ��λ�ô���Ԫ��
		//array[3] = 400;
		//�����з�Χ��

		//int value = array[5];
		//System.out.println(value);
		//�쳣---����ʱ�쳣
		//ArrayIndexOutOfBoundsException  ��������Խ��
		//index����    0��ʼ-----����(����-1)����

		//�������е�ÿһ��Ԫ�ض��ó�����һ��
		/*
		for(int index=0;index<5;index++){//ÿһ����һ��������  ȡ�����ֵ  5��
			int value = array[index];
			System.out.println(value);
		}
		System.out.println("-----����һ�������ķָ���-----");
		for(int value : array){
			value = 100;
			System.out.println(value);
		}
		*/
	}
}