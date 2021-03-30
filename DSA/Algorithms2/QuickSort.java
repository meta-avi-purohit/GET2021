import java.util.*;

class Employee implements Comparable<Employee> {

	private String name;
	private int age;
	private int salary;

	Employee(String name, int age, int salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	/*
	 * To get Age of Employee
	 */
	public int getAge() {
		return age;
	}

	/*
	 * To get Name of Employee
	 */
	public String getName() {
		return name;
	}

	/*
	 * To get Salary of Employee
	 */
	public int getSalary() {
		return salary;
	}

	@Override
	public int compareTo(Employee E) {
		if (salary < E.getSalary()) {
			return 1;
		} else if (salary == E.getSalary()) {
			if (age > E.getAge()) {
				return 1;
			}
			return -1;
		}
		return -1;
	}

}

public class QuickSort {
	static class Node {
		Employee employee;
		Node next;

		Node(Employee E) {
			this.employee = E;
			this.next = null;
		}
	}

	Node head;

	/**
	 * Add Node to the LinkList;
	 * @param data
	 */
	void addNode(Employee data) {
		if (head == null) {
			head = new Node(data);
			return;
		}

		Node curr = head;
		while (curr.next != null)
			curr = curr.next;

		Node newNode = new Node(data);
		curr.next = newNode;
	}

	/**
	 * Print the LinkList
	 * 
	 * @param n
	 */
	void printList() {
		Node node = head;
		while (node != null) {
			System.out.println("Name :" + node.employee.getName() + " Age :"
					+ node.employee.getAge() + " Salary :"
					+ node.employee.getSalary());
			node = node.next;
		}
	}

	/*
	 * Function Return Pivote Node for sorting
	 */
	Node paritionLast(Node start, Node end) {
		if (start == end || start == null || end == null)
			return start;

		Node pivot = start;
		Node curr = start;
		Employee pivotData = end.employee;
		while (start != end) {
			if (start.employee.compareTo(pivotData) < 1) {
				pivot = curr;
				Employee temp = curr.employee;
				curr.employee = start.employee;
				start.employee = temp;
				curr = curr.next;
			}
			start = start.next;
		}
		Employee temp = curr.employee;
		curr.employee = pivotData;
		end.employee = temp;
		return pivot;
	}

	/*
	 * function to sort the linked list
	 */
	void sort(Node start, Node end) {
		if (start == null || start == end || start == end.next)
			return;
		Node pivot = paritionLast(start, end);
		sort(start, pivot);
		if (pivot != null && pivot == start)
			sort(pivot.next, end);
		else if (pivot != null && pivot.next != null)
			sort(pivot.next.next, end);
	}

	// Driver Code
	public static void main(String[] args) {
		QuickSort list = new QuickSort();
		Scanner scan = new Scanner(System.in);
		int choice = 1;
		while (choice != 0) {
			System.out.println("Enter AGE , SALARY , NAME");
			int age = scan.nextInt();
			int salary = scan.nextInt();
			scan.nextLine();
			String name = scan.nextLine();
			Employee E = new Employee(name, age, salary);
			list.addNode(E);
			System.out
					.println("Want to enter more data(Press 1 OTHERWISE Press 0) :");
			choice = scan.nextInt();
		}
		Node n = list.head;
		while (n.next != null)
			n = n.next;

		System.out.println("Linked List before sorting : ");
		list.printList();

		list.sort(list.head, n);

		System.out.println("\nLinked List after sorting : ");
		list.printList();

		scan.close();
	}
}
