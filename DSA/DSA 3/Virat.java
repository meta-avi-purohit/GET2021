import java.util.*;
public class Virat{
	public void display(PriorityQueue P){
		System.out.println("#############################");
		for (int i = 0; i < P.size; i++) {
			System.out.println("Bowler : " + P.queue[i][0] + " Balls : " + P.queue[i][1]);
		}
	}
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Number of Bowlers :");
		int bowlers = scan.nextInt();
		System.out.println("Enter the total number of balls Virat is going to play : ");
		int totalBallsToPlay = scan.nextInt();
		System.out.println("Enter Bowler and Balls :");
		int array[][] = new int[bowlers][2];
		for (int i = 0; i < bowlers; i++) {
			array[i][0] = scan.nextInt();
			array[i][1] = scan.nextInt();
		}
		Virat V = new Virat();
		PriorityQueue P = new PriorityQueue(bowlers, array);
		V.display(P);
		P.sort(0, P.queue);
		System.out.println("#############################");
		for (int i = 0; i < P.size; i++) {
			if(totalBallsToPlay == 0 || totalBallsToPlay < 0){
				break;
			}
			totalBallsToPlay -= P.sort[i][1];
			System.out.println("Bolwer : " + P.sort[i][0]);
		}
		System.out.println("#############################");
		scan.close();
	}
}
