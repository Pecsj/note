public class Test9{
	public static void main(String[] args){
		//int[] array = {5,2,3,1,4};
		//�������� --> {1,2,3,4,5} ����Ԫ��λ�û���  ����λ�õ�����
		//ð��������㷨
		int[] array = {5,2,3,1,4};
		for(int i=1;i<5;i++){//���ƱȽ��ִ�  ÿһ��ð����һ����Сֵ
			for(int j=4;j>=i;j--){//������׶�  һֱ�ȵ�����  4��
				if(array[j]<array[j-1]){
					int x = array[j];
					array[j] = array[j-1];
					array[j-1] = x;
				}
			}
		}
		for(int v:array){
			System.out.println(v);
		}
	}
}