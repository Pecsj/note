public class SaveNum{
	public static void main(String[] args){
		//1.��Ҫ����һ������
		int[] array = new int[50];//�г���  Ԫ��û��(Ĭ��ֵ)
		//2.��Ҫ��1-100֮���ż������������
		for(int i=0;i<array.length;i++){//ִ��50��  �Ӽ���������  ���ô�0��ʼ���ȽϷ���
			array[i] = 2*i+2;
		}
		//3.�����֤��һ��
		for(int v:array){
			System.out.println(v);
		}
	}
}