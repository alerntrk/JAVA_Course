package paket;

public class GCD {
	private Integer a,b;
	private int result;
	GCD(Integer x,Integer y){
		this.a=x;
		this.b=y;
	}
	void findGCD(){
		
		for(int i=1;i<=a && i<=b;i++){
			if(a%i==0 && b%i==0) result=i;	
		}
		System.out.println("GCD of "+a+" and "+b+" is "+result);

	}
}
