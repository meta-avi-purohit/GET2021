import java.util.*;
class JobScheduler{
	private int completionTime[];
	private int waitingTime[];
	private int turnAroundTime[];
	private int averageWaitingTime;
	private int maxWaitingTime=0;
	JobScheduler(int Process[][])
	{
		int numberofProcess = Process.length;
		
		//Completion Time Calculation
		completionTime = new int[numberofProcess];
		completionTime[0] = Process[0][1];
		
		for(int i = 1; i<numberofProcess; i++)
		{
	
			if(completionTime[i-1]<=Process[i][0])
			{
				completionTime[i] = Process[i][1] + Process[i][0];
			}
			else
			{
				completionTime[i] = completionTime[i-1] + Process[i][1];
			}
		}
		
		//Turn Around Time Calculation.
		turnAroundTime = new int[numberofProcess];
		for(int i = 0; i < numberofProcess; i++)
		{
			turnAroundTime[i] = completionTime[i] - Process[i][1];
		}
		
		
		//Waiting Time Calculation
		waitingTime = new int[numberofProcess];
		int sum = 0;
		for(int i = 0; i<numberofProcess; i++)
		{
			waitingTime[i] = turnAroundTime[i] - Process[i][0];
			if(waitingTime[i] < 0)
				waitingTime[i] = 0;
			sum += waitingTime[i];
			
			//To Find Maximum Waiting Time
			if(waitingTime[i]>maxWaitingTime)
			{
				maxWaitingTime = waitingTime[i];
			}
		}
		//Average Waiting Time
		averageWaitingTime = sum/numberofProcess;
	}
	
	//To get Completion Time of each Process
	public int[] getcompletionTime()
	{
		return completionTime;
	}
	
	//To get Turn Around Time of each Process
	public int[] gettrunaroundTime()
	{
		return turnAroundTime;
	}
	
	//To get Waiting Time of each Process
	public int[] getwaitingTime()
	{
		return waitingTime;
	}
	
	//To get Average Waiting Time
	public int getaveragewaitingTime()
	{
		return averageWaitingTime;
	}
	
	//To get Maximum Waiting Time
	public int getmaxwaitingTime()
	{
		return maxWaitingTime;
	}
}


//Main Class
public class Question2 
{
	public static void main(String[] args){
		System.out.print("Enter Number of processes : ");
		Scanner scan = new Scanner(System.in);
		int row = scan.nextInt();
		System.out.println("Enter Arival Time and Burst Time :");
		int Process[][] = new int[row][2];
		for(int i = 0 ; i<row; i++)
		{
			Process[i][0] = scan.nextInt();
			Process[i][1] = scan.nextInt();
		}
		JobScheduler J = new JobScheduler(Process);
		for(int i = 0 ; i<(row*9+10); i++)
			System.out.print("-");
		System.out.print("\nProcess\t");
		for(int i = 1; i<=Process.length; i++)
			System.out.print("\t|P" + i);
		System.out.print("\nCompletion Time");
		int[] completionTime = J.getcompletionTime();
		for(int i: completionTime)
			System.out.print(  "\t|" +i);
		int[] turnaroundTime = J.gettrunaroundTime();
		System.out.print("\nTurn Around Time");
		for(int i : turnaroundTime)
			System.out.print("|" + i +"\t");
		int[] waitingTime = J.getwaitingTime();
		System.out.print("\nWaiting Time ");
		for(int i : waitingTime)
			System.out.print("\t|" + i);
		System.out.println();
		for(int i = 0 ; i<(row*9+10); i++)
			System.out.print("-");
		int averagewaitingTime = J.getaveragewaitingTime();
		System.out.println("\nAverage Waiting Time :  " + averagewaitingTime);
		int maxwaitingTime = J.getmaxwaitingTime();
		System.out.println("Maximum Waiting Time :  " + maxwaitingTime);
		scan.close();
	}
}
