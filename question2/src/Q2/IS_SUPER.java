package Q2;

public class IS_SUPER {
	int num;
	IS_SUPER(int a){
		this.num=a;
	}
	public boolean check_square(){
		
		for(int i=0;i<=num;i++){
			if(i*i == num) return true;
			
		}
		return false;
	}
	public int fact(String a){
		int i=1;
		int result=1;
		int b=Integer.valueOf(a);
		do{
			if(b==1)break;
			i++;
			result=result*i;
		}
		while(i<b);
		//System.out.println(result);
		return result;
	}
	
	public boolean check_peterson()
	{
		String str=String.valueOf(num);
		int result=0;
		for(int i=0;i<str.length();i++){
			result+=fact(String.valueOf(str.charAt(i)));
			
		}
		//System.out.println(result);
		if(result==num)return true;
		return false;
	
    }
}