public class Demo3{
	public static void main(String[] args){
		//��ӡ���9*9�˷���
		//1*1=1		���ʽ����--?
		//1*2=2  2*2=4
		//1*3=3  2*3=6  3*3=9
		//   j  + "*" +   i + "=" +     j*i
		//������  *  ����  =  �˻�
		//��һ��֮��  �����������仯 j  �����̶�  i
		for(int i=1;i<=9;i++){//��������
			//��һ��?
			for(int j=1;j<=i;j++){//����ÿһ�б��ʽ�ĸ���
				System.out.print(j+"*"+i+"="+(j*i)+"\t");
			}
			//����
			System.out.println();
		}
	}
}