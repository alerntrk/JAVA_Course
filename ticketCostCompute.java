import java.util.Scanner;
public class Main {
	public static void main(String args[]){
		Scanner inp = new Scanner(System.in);
		int km,age,type;
		System.out.println("enter the distance: ");
		km=inp.nextInt();
		System.out.println("enter your age: ");
		age=inp.nextInt();
		System.out.println("enter type: ");
		type=inp.nextInt();
		double normalFiyat,indirim;
		normalFiyat=0;
		indirim=0;
		if(age>0 && km>0 && (type==1 || type==2)){
			
			normalFiyat=km*0.10;
			if(age<12){
				indirim=normalFiyat*0.5;
			}
			if(type==2){
				indirim=indirim+normalFiyat*0.15;
				normalFiyat+=normalFiyat;
			}
			normalFiyat=normalFiyat-indirim;
			
		}
		else{
			System.out.println("error amk..");
			
		}
		System.out.println("fiyat:"+normalFiyat+" yapilan indirim: "+indirim);
	
	}
	
}
