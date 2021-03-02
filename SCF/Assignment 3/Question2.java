import java.util.*;

final class Poly{
	private final int polynomial[];
	
	public Poly(int polynomial[])
	{
		this.polynomial = new int[polynomial.length];
		for(int i = 0; i<polynomial.length;i++)
		{
			this.polynomial[i] = polynomial[i];
		}
	}
	
	//Display Polynomial
	public void display()
	{
		System.out.println("Polynomial is :");
		for(int i = polynomial.length-1;i>0;i--)
		{
			if(this.polynomial[i] != 0 )
				System.out.print(polynomial[i]+"X^" +i+" + ");
		}
		System.out.println(polynomial[0]+"X^" + 0);
	}
	
	//Evaluate the Polynomial by value Of X.
	public float evaluate(float x)
	{
		float result = 0;
		for(int i = 0 ;i<this.polynomial.length;i++)
		{
			result = result + (float)Math.pow(x, i)*this.polynomial[i];
		}
		return result;
	}
	
	//Add two Polynomials
	public int[] addpoly(Poly P1, Poly P2)
	{
		int l1 = P1.polynomial.length;
		int l2 = P2.polynomial.length;
		int size = Math.max(l1,l2);
		int sum[] = new int[size];
		for(int i = 0;i<l1;i++)
		{
			sum[i] = P1.polynomial[i];
		}
		for(int i = 0; i<l2; i++)
		{
			sum[i] += P2.polynomial[i];
		}
		return sum;
	}
	
	//Multiply two Polynomial
	public int[] multiplypoly(Poly P1, Poly P2)
	{
		int l1 = P1.polynomial.length;
		int l2 = P2.polynomial.length;
		int size = l1 + l2 - 1;
		int product[] = new int[size];
		
		for(int i = 0;i<size;i++)
			product[i] = 0;
		for(int i = 0;i<l1;i++)
		{
			for(int j = 0;j<l2;j++)
			{
				product[i + j] += P1.polynomial[i]*P2.polynomial[j];
			}
		}
		return product;
	}
	
	
	//To get Degree
	public int degree(Poly P){
		int degree = P.polynomial.length - 1;
		return degree;
	}
	
	//for better Console Output
	public void pattern()
	{
		for(int i = 0 ;i<50;i++)
			System.out.print("-");
		System.out.println();
	}
}

public class Question2 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		//Polynomial 1
		System.out.print("Enter Order of Polynomial : ");
		int number = scan.nextInt();
		int poly[] = new int[number];
		for(int i = 0;i<number; i++)
		{
			System.out.print("Enter the Coffecient of X^" + i + " : ");
			poly[i] = scan.nextInt();
		}
	    
		Poly P1 = new Poly(poly);
		P1.pattern();
		P1.display();
		P1.pattern();
		
		
		//Degree 
		System.out.println("Degree of Polynomial is : " + P1.degree(P1));
		P1.pattern();
		
		//Evaluate
		System.out.print("Enter the Value of X : ");
		float x = scan.nextFloat();
		System.out.println("Result of Polynomial : " + P1.evaluate(x));
		P1.pattern();
		
		//Polynomial 2
		System.out.print("Enter Order of Polynomial : ");
		int number1 = scan.nextInt();
		int poly1[] = new int[number1];
		for(int i = 0;i<number1; i++)
		{
			System.out.print("Enter the Coffecient of X^" + i + " : ");
			poly1[i] = scan.nextInt();
		}
		Poly P2 = new Poly(poly1);
		P1.pattern();
		P2.display();
		P1.pattern();
		
		
		//Add
		int sum[] = P1.addpoly(P1, P2);
		Poly P3 = new Poly(sum);
		System.out.print("Sum ");
		P3.display();
		P1.pattern();
		
		
		//Multiply
		int multiply[] = P1.multiplypoly(P1, P2);
		System.out.print("Multiply ");
		Poly P4 = new Poly(multiply);
		P4.display();
		P1.pattern();
		scan.close();
	}
}
