public class Demo2{
	public static void main(String[] args){
		//���ֽ�����                         �ո�   ���   �ұ�
		//       1		i==1	3    1-1    0
		//     12  1	i==2	2    1-2    1-1
		//   123  21	i==3	1    1-3    2-1
		// 1234  321	i==4	0    1-4    3-1
		for(int i=1;i<=4;i++){//��������
			//�ո�ռλ
			for(int j=1;j<=4-i;j++){
				System.out.print(" ");
			}
			//�������   �ı�--���ñ���  ����ѭ�����ı���j������  j++
			for(int j=1;j<=i;j++){
				System.out.print(j);
			}
			//�ұ�����   �ı�--����j����   j--
			for(int j=i-1;j>=1;j--){
				System.out.print(j);
			}
			//����
			System.out.println();
		}
	}
}