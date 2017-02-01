package irrigationSystem;

import java.util.Scanner;

public class Pollution {

	public static void main(String[] args) 
	{
		
		int p;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the pollution level in terms of Total Dissolved Solids(mg/l) :- ");
		p=s.nextInt();
		if(p<=2100)
		{
			System.out.println("The pollution level is Okay and has no harm.");
		}
		else if(p>2100)
		{
			System.out.println("OMG! The pollution level is unsafe for the supply to the fields.");
			System.out.println("Please don't supply the water to the fields else the crops will be destroyed.");
		}
	}
}
