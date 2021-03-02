import java.util.*;

final class IntSet{
	private final int set[];
	
	public IntSet(int set[])
	{
		this.set = new int[set.length];
		for(int i = 0;i<set.length;i++)
			this.set[i] = set[i];
	}
	
	//Check whether the Number is Member or not.
	public boolean isMember(int number)
	{
		for(int i: this.set)
		{
			if(number == i)
				return true;
		}
		return false;
	}
	
	//Return Complement
	public int[] getComplement()
	{
		int[] complement = new int[1000-this.set.length];
		int j = 0;
		for(int i = 1;i<=1000;i++)
		{
			if(isMember(i)){
				continue;
			}
			else{
				complement[j] = i;
				j++;
			}
		}
			return complement;
	}
	
	//Union of the Sets
	public int[] union(IntSet S1, IntSet S2){
		int l1 = S1.set.length ;
		int l2 = S2.set.length ;
        int result[] = new int[l1+l2];
			 int i,j,k=0,flag=0; 
			 for(i=0;i<l1;i++) 
			 { 
			  result[k]=S1.set[i]; 
			  k++; 
			 } 
			 for(i=0;i<l2;i++) 
			 { 
			  flag=0; 
			  for(j=0;j<l1;j++) 
			  { 
			   if(S2.set[i]==result[j]) 
			   { 
			    flag=1; 
			    break; 
			   } 
			  } 
			  if(flag==0) 
			  { 
			   result[k]=S2.set[i]; 
			   k++; 
			  } 
			 }
		return result;
	}
	
	//To Check Subset 
	public String isSubSet(IntSet S)
	{
		for(int i = 0;i<S.set.length;i++)
		{
			if(isMember(S.set[i]))
				continue;
			else
				return "It is Not a SubSet";
		}	
		return "Is is a SubSet";
	}
	
	//Return Size
	public int size()
	{
		return this.set.length;
	}
}
public class Question1 {
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		//Set 1
		System.out.print("Enter the Number of elements in set : ");
		int elements = scan.nextInt();
		int[] set = new int[elements];
		for(int i = 0; i<elements; i++)
		{
			set[i] = scan.nextInt();
		}
		IntSet S = new IntSet(set);
		
		//Size
		System.out.println("Size : " + S.size());
		
		//isMember Check
		System.out.print("Enter The element to Search : ");
		int number = scan.nextInt();
		if(S.isMember(number))
			System.out.println("Element is Present in Set");
		else
			System.out.println("Element is Not Present in Set");
		
		//Complement
		int[] complement = S.getComplement();
		System.out.println("Complement Of Set is :");
		for(int i: complement)
			System.out.print(i + "\t");
		System.out.println();
		
		//Set 2
		System.out.print("Enter the Number of elements in set : ");
		int elements1 = scan.nextInt();
		int[] set2 = new int[elements1];
		for(int i = 0; i<elements1; i++)
		{
			set2[i] = scan.nextInt();
		}
		IntSet S1 = new IntSet(set2);
		
		//Is Subset Check
		System.out.println(S.isSubSet(S1));
		
		//Union of Sets
		System.out.println("Union of two sets :");
		int result[] = S.union(S, S1);
		for(int i : result)
			if(i!=0){
				System.out.print(i + "  ");
			}
		
		scan.close();
	}
}
