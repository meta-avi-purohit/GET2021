import java.util.*;
public class Cart {

	Scanner sc = new Scanner(System.in);
	String itemlist[] = {"Toothpaste","Bscuit    ","Honey     ","Kechap    ","Oil       "};
	int itemprice[]= {70, 20,50,80,90};
	int itemqty[] = { 12, 12,12,12,12};
	int[] mycart = {0,0,0,0,0};
	public void menu(){
		System.out.println("----------------------------------------------");
		System.out.println("S.NO.   Item Name          Price        Quantity");
		for(int i = 0;i<5;i++)
		{
			System.out.println((i+1)+"        "+itemlist[i]+"         " + itemprice[i] +"           "+ itemqty[i]);
		}
		System.out.println("----------------------------------------------");
	}
	public void display(){
		System.out.println("Enter your Choice:");
		System.out.println("1. For See Availabe items");
		System.out.println("2. Add Item to Cart");
		System.out.println("3. Remove Item from Cart");
		System.out.println("4. Show Items in Cart");
		System.out.println("5. Generate Bill");
		int c = sc.nextInt();
		choice(c);
	}
	public void add()
	{
		char c = 'y';
		while( c != 'n')
		{
			
		System.out.println("Enter S.NO. of Item : ");
		int i = sc.nextInt();
		System.out.println("Enter Quantity of Item :");
		int q = sc.nextInt();
		if(mycart[i-1] + q < 12)
		{
			mycart[i-1] = mycart[i-1] + q;
		}
		else
		{
			System.out.println("There is Not Enough Q");
		}
		System.out.println("Do you want to add more item(y or n)");
		c = sc.next().charAt(0);
		}
}
	public void show()
	{
		System.out.println("----------------------------------------------");
		System.out.println("S.NO.   Item Name          Quintity");
		for(int i = 0;i<5;i++)
		{
			if(mycart[i] != 0)
			{
				System.out.println(i+1 + "        " + itemlist[i] + "        "+mycart[i]);
			}
		}
		System.out.println("----------------------------------------------");
	}
	public void genBill()
	{
		int total = 0;
		for(int i = 0; i<5 ; i++)
		{
			if(mycart[i] != 0)
			{
				total = total + (mycart[i]*itemprice[i]);
			}
		}
		System.out.println("Bill : " + total + " Bucks");
	}
	public void remove()
	{
		char c = 'y';
		while( c != 'n')
		{
		System.out.println("Enter S.NO. of Item : ");
		int i = sc.nextInt();
		System.out.println("Enter Quantity of Item :");
		int q = sc.nextInt();
		if(mycart[i-1] - q > 0)
		{
			mycart[i-1] = mycart[i-1] - q;
		}
		else
		{
			System.out.println("Sooooryyyyy");
		}
		System.out.println("Do you want to remove more item(y or n)");
		c = sc.next().charAt(0);
		}
	}
	public void choice(int i){
		switch(i){
		case 1:
			menu();
			display();
			break;
		case 2:
			menu();
			add();
			display();
			break;
		case 3:
			remove();
			display();
			break;
		case 4:
			show();
			display();
			break;
		case 5:
			genBill();
			display();
			break;
		default:
			System.out.println("Wrong number entered!!!!");
			display();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart c = new Cart();
		c.display();
	}

}
