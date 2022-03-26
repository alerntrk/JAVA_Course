package Q2;
import java.util.Scanner;

public class MAIN {
	public static void main(String[] args){
		int num=0;
		System.out.println("enter an integer");
		Scanner in=new Scanner(System.in);
		num=in.nextInt();
		IS_SUPER is = new IS_SUPER(num);
		if(is.check_peterson() && is.check_square()) System.out.println("This number is perfect square and peterson number as well");
		else System.out.println("not");
		
	}
	
	
}
