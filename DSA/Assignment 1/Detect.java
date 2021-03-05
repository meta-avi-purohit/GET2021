import java.util.*;

public class Detect {

	// Function Detect Loop
	public boolean detectLoop(LinkedList list) {

		Node temp1 = list.head, temp2 = list.head;
		int flag = 0;
		while (temp1 != null && temp2 != null && temp2.next != null) {
			temp1 = temp1.next;
			temp2 = temp2.next.next;
			if (temp1 == temp2) {
				flag = 1;
				break;
			}
		}
		if (flag == 1)
			return true;
		else
			return false;
	}

	// Main
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int choice = 1;
		LinkedList list = new LinkedList();
		System.out
				.println("Enter a element to insert in Linked List(ONLY NUMBERS) : ");
		while (choice != 0) {
			int data = scan.nextInt();
			list = list.insert(list, data);
			System.out
					.print("Want to insert more(Press 1) otherwise(Press 0) : ");
			choice = scan.nextInt();
		}
		System.out.println("###List###");
		list.print(list);
		System.out.println();
		Detect D = new Detect();

		// Check Before Loop Creation
		if (D.detectLoop(list)) {
			System.out.println("Loop Found");
		} else {
			System.out.println("Loop Not Found");
		}

		// Loop Creation
		list.head.next = list.head;

		// Check After Loop Creation
		if (D.detectLoop(list)) {
			System.out.println("Loop Found");
		} else {
			System.out.println("Loop Not Found");
		}
		scan.close();
	}

}
