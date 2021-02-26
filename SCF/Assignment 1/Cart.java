import java.util.*;
public class Cart 
{

	Scanner sc = new Scanner(System.in);
	//This itemList array of Items that are present in  Store.
	String itemList[] = {"Toothpaste","Biscuit   ","Honey     ","Kechap    ","Oil       "};
	
	//This itemPrice array is to tell price of Items in Store.
	int itemPrice[]= {70, 20,50,80,90};
	
	//itemQty array is use to show Quantity of Items in Store.
	int itemQty[] = { 12, 12,12,12,12};
	
	//myCart array is use to Add/Remove Items as User demand.
	int[] myCart = {0,0,0,0,0};
	
	//This Function is For Display the Items available in Store.
	public void Menu()
	{
		System.out.println("------------------------------------------------");
		System.out.println("S.NO.   Item Name          Price        Quantity");
		for(int i = 0;i<5;i++)
		{
			System.out.println((i+1)+"        "+itemList[i]+"         " + itemPrice[i] +"           "+ itemQty[i]);
		}
		System.out.println("------------------------------------------------");
	}
	
	//This Function is For Display the Choices to user.
	public void Display()
	{
		System.out.println("Enter your Choice:");
		System.out.println("1. For See Availabe items");
		System.out.println("2. Add Item to Cart");
		System.out.println("3. Remove Item from Cart");
		System.out.println("4. Show Items in Cart");
		System.out.println("5. Generate Bill");
		int c = sc.nextInt();
		Choice(c);
	}
	
	//Add() is use to add items in cart.
	public void Add()
	{
		char c = 'y';
		while( c != 'n')
		{
			
		System.out.println("Enter S.NO. of Item : ");
		int i = sc.nextInt();
		System.out.println("Enter Quantity of Item :");
		int q = sc.nextInt();
			if(myCart[i-1] + q < 12)//Check if User want to enter more Quantity Greater than Quantity in Store.
				{
					myCart[i-1] = myCart[i-1] + q;
				}
			else
				{
					System.out.println("There is Not Enough Quantity in Shop!");
				}
		System.out.println("Do you want to add more item(y or n)");
		c = sc.next().charAt(0);
		}
	}
	
	//Show() is use to show the items present in Cart.
	public void Show()
	{
		System.out.println("--------------------------------------");
		System.out.println("S.NO.   Item Name          Quantity");
		for(int i = 0;i<5;i++)
		{
			if(myCart[i] != 0)
			{
				System.out.println(i+1 + "        " + itemList[i] + "        "+myCart[i]);
			}
		}
		System.out.println("--------------------------------------");
	}
	
	//GenBill() is to generate bill for user.
	public void GenBill()
	{
		int total = 0;
		for(int i = 0; i<5 ; i++)
		{
			if(myCart[i] != 0)
			{
				total = total + (myCart[i]*itemPrice[i]);
			}
		}
		System.out.println("------------------------");
		System.out.println("Bill : " + total + " Rs");
		System.out.println("------------------------");
	}
	
	//Remove() is to Update an Item from Cart.
	public void Remove()
	{
		char c = 'y';
		while( c != 'n')
		{
		System.out.println("Enter S.NO. of Item : ");
		int i = sc.nextInt();
		System.out.println("Enter Quantity of Item :");
		int q = sc.nextInt();
			if(myCart[i-1] - q > 0)//Check for -ve Number.
				{
					myCart[i-1] = myCart[i-1] - q;
				}
			else
				{
					System.out.println("There is Not Enough Quantity in Item!");
				}
		System.out.println("Do you want to remove more item(y or n)");
		c = sc.next().charAt(0);
		}
	}
	
	//Choice() Call all the Function that perform specific task.
	public void Choice(int i)
	{
		switch(i)
		{
		case 1:
			Menu();
			Display();
			break;
		case 2:
			Menu();
			Add();
			Display();
			break;
		case 3:
			Remove();
			Display();
			break;
		case 4:
			Show();
			Display();
			break;
		case 5:
			GenBill();
			Display();
			break;
		default:
			System.out.println("Wrong number entered!!!!");
			Display();
		}
	}
	
	//Main Function
	public static void main(String[] args)
	{
		Cart c = new Cart();
		c.Display();
	}

}
