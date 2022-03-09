import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Scanner jin=new Scanner(System.in);
	    
	   String  Username;
	   String Password;
	   System.out.println("enter your username:");
	   Username=jin.next();
	   System.out.println("enter your password:");
	   Password=jin.next();
	   if(Username.equals("java")&&Password.equals("4343")){
	       System.out.println("Succesfully logged in...");
	   }
	   else{
	       System.out.println("Wrong username or password");
	   }
		
	}
}
