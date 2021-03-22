import java.util.*;
public class PriorityQueue {
	int queue[][];
	int sort[][];
	int size;
	PriorityQueue(int size,int array[][]) {
		this.size = size;
		this.queue = new int[size][2];
		this.queue = array;
		this.sort = new int[size][2];
	}
	public void display(){
		System.out.println("#############################");
		for (int i = 0; i < size; i++) {
			System.out.println("Process : " + queue[i][0] + " Priority : " + queue[i][1]);
		}
	}
	public void displaySort(){
		System.out.println("#############################");
		for (int i = 0; i < size; i++) {
			System.out.println("Process : " + sort[i][0] + " Priority : " + sort[i][1]);
		}
	}
	public void sort(int i,int array[][])
	{
		if(i>=size){
			return;
		}
		int max = 0;
		for(int j = 0; j<size;j++)
		{
			if(array[max][1] < array[j][1]){
				max = j;
			}
		}
		sort[i][0] = array[max][0];
		sort[i][1] = array[max][1];
		array[max][0] = 0;
		array[max][1] = 0;
		sort(i+1,array);
	}
	
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Number of Process :");
		int process = scan.nextInt();
		int array[][] = new int[process][2];
		for (int i = 0; i < process; i++) {
			array[i][0] = scan.nextInt();
			array[i][1] = scan.nextInt();
		}
		PriorityQueue P = new PriorityQueue(process, array);
		P.display();
		P.sort(0, P.queue);
		P.displaySort();
		System.out.println("#############################");
		scan.close();
	}
}
