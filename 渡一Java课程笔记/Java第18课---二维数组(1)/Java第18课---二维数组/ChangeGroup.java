import java.util.Scanner;

public class ChangeGroup{
	public static void main(String[] args){
		//����һ����ά���� ������ʾ�༶���ÿһ��ͬѧ
		int[][] array = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		//���ÿһ�ܽ���һ��  ����?
		Scanner input = new Scanner(System.in);
		System.out.println("��������һ������,����������������Ľ��");
		int week = input.nextInt();//6
		for(int i=1;i<=week%4;i++){
			int[] x = array[0];
			array[0] = array[1];
			array[1] = array[2];
			array[2] = array[3];
			array[3] = x;
		}
		//�򵥿�һ��
		for(int[] arr:array){
			for(int v:arr){
				System.out.print(v+"\t");
			}
			System.out.println();
		}
	}
}




