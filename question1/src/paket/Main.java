package paket;
import java.util.Scanner;

public class Main {
	
	public static void main(String args[]){
		
		Integer a,b;
		System.out.println("please enter two value");
		Scanner scan=new Scanner(System.in);
		a=scan.nextInt();
		b=scan.nextInt();
		GCD g=new GCD(a,b);
		g.findGCD();
		
		
	}
	

}
