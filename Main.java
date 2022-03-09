// SIMPLE CALCULATOR
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Scanner jin=new Scanner(System.in);
	    
	    int a,b,ch;
	    double result=0;
	    System.out.println("ilk sayi: ");
	    a=jin.nextInt();
	    System.out.println("ikinci sayi: ");
	    b=jin.nextInt();
	    System.out.println("*******işlem girişi*******:\n\t1-)Toplama\n\t2-)Çıkarma\n\t3-)Çarpma\n\t4-)Bolme");
	    ch=jin.nextInt();
	    if(ch==1){
	        
	        result=a+b;
	    }
		else if(ch==2) {
		    result=a-b;
		}
		else if(ch==3){
		    result=a*b;
		}
		else if(ch==4){
		    result=a/b;
		}
		else{
		    System.out.println("Hatalı Giriş");
		}
		System.out.println("sonuç="+result);
		
	}
}
