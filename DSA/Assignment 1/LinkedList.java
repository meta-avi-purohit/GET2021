import java.util.*;

class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}
}

public class LinkedList {

	// Head node
	Node head;

	// Function To Insert Element in LinkedList.
	public LinkedList insert(LinkedList list, int data) {
		Node newNode = new Node(data);
		newNode.next = null;

		if (list.head == null) {
			list.head = newNode;
		} else {
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = newNode;
		}
		return list;
	}

	// Print Function
	public void print(LinkedList list) {
		Node currNode = list.head;
		while (currNode.next != null) {
			System.out.print(currNode.data + "->");
			currNode = currNode.next;
		}
		System.out.print(currNode.data);
	}

	// Function to Create SubList.
	public LinkedList subList(LinkedList list, int L, int R) {
		LinkedList subList = new LinkedList();
		int len = 0;
		Node last = list.head;
		while (last != null) {
			len++;
			last = last.next;
		}
		if (L <= 0 || R > len) {
			System.out.println("Wrong Values Entered ");
			System.exit(0);
		}
		int i = 1;
		Node currNode = list.head;
		while (i != L) {
			currNode = currNode.next;
			i++;
		}
		while (i <= R) {
			subList = insert(subList, currNode.data);
			currNode = currNode.next;
			i++;
		}
		return subList;
	}

	// Rotate Function
	public static void rotate(LinkedList list, int N) {
		if (N == 0)
			return;

		Node current = list.head;

		int count = 1;
		while (count < N && current != null) {
			current = current.next;
			count++;
		}

		if (current == null)
			return;
		Node kthNode = current;
		while (current.next != null)
			current = current.next;

		current.next = list.head;

		list.head = kthNode.next;

		kthNode.next = null;
	}

	// Add Function
	public static LinkedList add(LinkedList list, LinkedList subList, int L) {
		Node currNode = list.head;
		LinkedList result = new LinkedList();
		int i = 1;
		while (i != L) {
			result = result.insert(result, currNode.data);
			currNode = currNode.next;
			i++;
		}
		Node currNode1 = subList.head;
		while (currNode1 != null) {
			result = result.insert(result, currNode1.data);
			currNode1 = currNode1.next;
			currNode = currNode.next;
		}
		while (currNode != null) {
			result = result.insert(result, currNode.data);
			currNode = currNode.next;
		}
		return result;
	}

	// Main
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int choice = 1;
		LinkedList list = new LinkedList();

		// Insertion
		System.out.println("Enter a element to insert in Linked List(ONLY NUMBERS) : ");
		while (choice != 0) {
			int data = scan.nextInt();
			list = list.insert(list, data);
			System.out.print("Want to insert more(Press 1) otherwise(Press 0) : ");
			choice = scan.nextInt();
		}

		System.out.println("###List###");
		list.print(list);
		System.out.println("\n##########");

		System.out.println("Enter Left Index(L) and Right Index(R) : ");
		int L, R;
		L = scan.nextInt();
		R = scan.nextInt();
		LinkedList subList = list.subList(list, L, R);
		System.out.println("###Sublist###");
		list.print(subList);
		System.out.println();

		System.out.println("Enter Degree of rotation(like 1,2,3 etc.) : ");
		int N = scan.nextInt();
		rotate(subList, N);

		System.out.println("###Sublist After Rotation###");
		list.print(subList);
		LinkedList result = add(list, subList, L);
		System.out.println();
		System.out.println("###Final List###");
		list.print(result);
		scan.close();
	}
}
