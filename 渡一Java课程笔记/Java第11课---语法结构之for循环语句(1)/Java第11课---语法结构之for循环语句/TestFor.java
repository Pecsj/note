public class TestFor{
	public static void main(String[] args){
		int round=1;
		for( ; round<=5 ; round+=2){
			System.out.println("�ܵ���"+ round +"Ȧ��");//2 4 6
		}
		//ѭ��ִ����� round===6
		System.out.println("ѭ��ִ�����:"+round);
		//������������������(���� ջ�ڴ�ռ� ��������ʼ�������� ���꼰����)
	}
}