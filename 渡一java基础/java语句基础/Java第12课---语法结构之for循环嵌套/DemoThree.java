public class DemoThree{
	public static void main(String[] args){
		//double value = Math.pow(double a , double b);//�����Ǽ���a��b�η�
		/*for(int num=100;num<1000;num++){
			int b = num/100;
			int s = num/10%10;//   num%100/10;
			int g = num%10;
			if(b*b*b+s*s*s+g*g*g==num){
				System.out.println(num+"��ˮ�ɻ���");
			}
		}*/
		for(int num=100;num<1000;num++){
			if(Math.pow(num/100,3)+Math.pow(num%100/10,3)+Math.pow(num%10,3)==num){
				System.out.println(num+"��ˮ�ɻ���");
			}
		}
	}
}