public class TestArray{
	public static void main(String[] args){

		System.out.println(args.length);//����
		for(String value : args){
			System.out.println(value);
		}


		/*
		int[][] array = new int[3][2];
		array[0][0] = 10;
		array[0][1] = 20;
		array[1] = array[0];
		array[0] = new int[4];
		array[0][0] = 100;
		System.out.println(array[1][0]);//?   10
		*/
		
		//��ά����Ķ�̬��ʼ��
		//int[][] array = new int[3][];//{{0,0},{0,0},{0,0}}
		//array[0] = new int[2];
		//array[0][0] = 10;
		//array[0][1] = 20;
		//array[0][2] = 30;//����ʱ�쳣ArrayIndexOutOfBoundsException

		/*
		//����----��ʼ��(��̬)
		int[][] array = new int[][]{{1,2},{3,4,5,6},{7,8,9}};
		//���������ڵ�Ԫ��---index
		//int value = array[0][0];//ǰ���ʾС����λ��  �����ʾС������Ԫ�ص�λ��
		//System.out.println(value);//1   array[1][2];//5   array[2][2];//9
		//����ı���/��ѯ
		for(int i=0;i<array.length;i++){//�����������е�С����
			for(int j=0;j<array[i].length;j++){//����ÿһ��С�����е�Ԫ��
				int value = array[i][j];
				System.out.print(value+"\t");
			}
			System.out.println();
		}
		System.out.println("-------------");
		for(int[] arr : array){
			for(int value : arr){
				System.out.print(value+"\t");
			}
			System.out.println();
		}
		*/
	}
}