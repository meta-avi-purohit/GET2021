import java.util.*;

class HexCalc{
	
	//To Add two Hexadecimal Number.
	public String addhexadecimal(String h1, String h2)
	{
		int d1 = hexaToDecimal(h1);
		int d2 = hexaToDecimal(h2);
		String sum = decimalTohexa(d1 + d2);
		return sum;
	}
	
	//To Subtract Two Hexadecimal Number.
	public String subtracthexadecimal(String h1, String h2)
	{
		int d1 = hexaToDecimal(h1);
		int d2 = hexaToDecimal(h2);
		int result;
		if(d1>d2)
			{
				 result = d1 - d2;
			}
		else
			{
				 result = d2 - d1;
			}
		String subtract = decimalTohexa(result);
			return subtract;
	}
	
	//To Multiply Two Hexadecimal Number.
	public String multiplyhexadecimal(String h1, String h2)
	{
		int d1 = hexaToDecimal(h1);
		int d2 = hexaToDecimal(h2);
		String multiply = decimalTohexa(d1*d2);
		return multiply;
	}
	
	//To Divide Two Hexadecimal Number.
	public String divideheaxdecimal(String h1, String h2)
	{
		int d1 = hexaToDecimal(h1);
		int d2 = hexaToDecimal(h2);
		int divide = d1/d2;
		String div =  decimalTohexa(divide);
		return div;
	}
	
	//To convert Hexadecimal to Decimal.
	public int hexaToDecimal(String hexadecimal)
	{
		String hexaarray = "0123456789ABCDEF";
		int power = 0;
		int decimal = 0;
		for(int i = hexadecimal.length() - 1; i>=0; i--)
		{
			int index = hexaarray.indexOf(hexadecimal.charAt(i));
			decimal = decimal + (int)Math.pow(16,power)*index;
			power++;
		}
		return decimal;
	}
	
	//To convert Decimal to Hexadecimal.
	public String decimalTohexa(int decimal)
	{
		String hexaarray = "0123456789ABCDEF";
		String hexadecimal = "";
		if(decimal == 0)
			return "0";
		int remainder;
		while(decimal>0)
		{
		    remainder = decimal%16;
			hexadecimal = hexaarray.charAt(remainder) + hexadecimal;
			decimal = decimal/16;
		}
		return hexadecimal;
	}
	
	//To compare Equal or Not.
	public boolean isEqual(String h1,String h2)
	{
		return h1 == h2;		
	}
	
	//To compare Greater.
	public boolean isGreater(String h1, String h2)
	{
		int n = 0;
		while(n<h1.length() && n<h2.length())
		{
			if(h1.charAt(n) > h2.charAt(n))
			{
				return true;
			}
			n++;
		}
		return false;
	}
	
	//To compare Lesser.
	public boolean isLesser(String h1, String h2)
	{
		int n = 0;
		while(n<h1.length() && n<h2.length())
		{
			if(h1.charAt(n) < h2.charAt(n))
			{
				return true;
			}
			n++;
		}
		return false;
	}
}

//Main
public class Question1 {
	public static void main(String[] agrs){
		Scanner scan = new Scanner(System.in);
		HexCalc H = new HexCalc();
		System.out.println("Enter two Hexadecimal Values(Capital Alphabets Only) : ");
		String hex1 = scan.next();
		String hex2 = scan.next();
		System.out.println("Addition :" + H.addhexadecimal(hex1,hex2));
		System.out.println("Subtraction : " + H.subtracthexadecimal(hex1, hex2));
		System.out.println("Multiplication : "+ H.multiplyhexadecimal(hex1, hex2));
		System.out.println("Divide : " + H.divideheaxdecimal(hex1,hex2));
		if(H.isEqual(hex1, hex2))
			System.out.println("Both are Equal");
		if(H.isGreater(hex1, hex2))
			System.out.println(hex1 + " is greater than "+hex2);
		if(H.isLesser(hex1, hex2))
			System.out.println(hex1 + " is less than " + hex2);
		scan.close();
	}
}