import java.util.*;

//Node
class Node {
	char data;
	Node next;
	Node child;

	Node(char d) {
		data = d;
		next = null;
		child = null;
	}
}

// LinkedList
public class NestedList {

	// head node
	Node head;

	// Function for Insertion an Element in Linked List.
	public static NestedList insert(NestedList list, char data) {

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

	// Function Link a Sub List to Main List
	public NestedList link(NestedList parent, NestedList list) {
		Node newNode = new Node(' ');
		newNode.next = null;
		newNode.child = list.head;

		if (parent.head == null) {
			parent.head = newNode;
		} else {
			Node last = parent.head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = newNode;
		}

		return parent;
	}

	// Function to Calculate Degree.
	public int degree(NestedList list) {
		Node currNode = list.head;
		int degree = 0;
		while (currNode != null) {
			int tempDegree = 0;
			Node currChild = currNode.child;
			while (currChild.next != null) {
				if (currChild.data >= 'a' && currChild.data <= 'z') {
					if (currChild.next.data >= '0'
							&& currChild.next.data <= '9') {
						tempDegree += Integer.parseInt(String
								.valueOf(currChild.next.data));
					}
				}
				currChild = currChild.next;
			}
			if (tempDegree > degree) {
				degree = tempDegree;
			}
			currNode = currNode.next;
		}
		return degree;
	}

	// Function To Display
	public void display(NestedList list) {
		Node currNode = list.head;
		System.out.println("Main LinkedList");

		while (currNode != null) {
			Node currChild = currNode.child;
			System.out.print("Child Linked List : ");
			while (currChild.next != null) {
				System.out.print(currChild.data + "->");
				currChild = currChild.next;
			}
			System.out.print(currChild.data);
			System.out.println();
			currNode = currNode.next;
		}
	}

	// Main Function
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// INPUT
		System.out
				.println("Enter Expression with Power of each variable(LIKE Y--->Y1) : ");
		String s = scan.nextLine();
		int k;
		char[] ch = s.toCharArray();
		char[] c = new char[ch.length + 1];
		for (k = 0; k < c.length - 1; k++)
			c[k] = ch[k];
		c[k] = '+';
		int i = 0, j = 0;
		NestedList parent = new NestedList();
		while (i < c.length) {

			// Sub list Creation
			NestedList list = new NestedList();
			while (j < c.length) {
				// System.out.print(c[i]+ " ");
				// Check for + and -
				if (c[j] == '+' || c[j] == '-')
					break;
				list = insert(list, c[i]);
				j++;
				i++;
			}
			if (i == c.length)
				break;
			if (c[j] == '+') {
				i++;
				j++;
			}
			if (j < c.length && c[j] == '-') {
				i++;
				j++;
			}

			// Call to link sublist to main
			parent = parent.link(parent, list);
		}

		System.out.println();
		parent.display(parent);

		System.out.print("\nDegree : ");
		int degree = parent.degree(parent);
		System.out.println(degree);
		scan.close();
	}

}
