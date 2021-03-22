import java.util.*;
class Node {
	public int empid;
	public int salary;
	public int age;
	public String name;

	private Node next;
	private Node prev;

	Node(int empid, int salary, int age, String name) {
		this.empid = empid;
		this.salary = salary;
		this.age = age;
		this.name = name;
		this.next = null;
		this.prev = null;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public Node getPrevious() {
		return prev;
	}
	
	public void setPrevious(Node prev) {
		this.prev = prev;
	}
	public int getSalary() {
		return salary;
	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public int getID() {
		return empid;
	}
}

public class LinkedList {

	private Node head;

	LinkedList() {
		this.head = null;
	}
	
	public void insertNode(int id,String name, int salary,int age){
		Node newNode = new Node(id, salary, age, name);
		if(head == null){
			head = newNode;
		} else {
			Node last = head;
			while(last.getNext() != null) {
				last = last.getNext();
			}
			last.setNext(newNode);
			newNode.setPrevious(last);
		}
	}
	public void displayLinkedList() {
		Node last = head;
		while(last != null) {
			System.out.println("ID : " + last.getID() + " NAME : " + last.getName() + " AGE : " + last.getAge() + " SALARY : " + last.getSalary() );
			last = last.getNext();
		}
	}
	public void insertionSort() {
		Node ptr = head;
		while(ptr != null) {
			Node temp = ptr.getPrevious();
			while(temp != null) {
				if(temp.getSalary() < ptr.getSalary()) {
					ptr.setPrevious(temp.getPrevious());
					temp.setPrevious(ptr);
					temp.setNext(ptr.getNext());
					ptr.setNext(temp);
					if(ptr.getPrevious() == null){
						head = ptr;
					}
					if(ptr != null){
						if(ptr.getPrevious() != null) {
							ptr.getPrevious().setNext(ptr);
						}
					}
					if(temp != null){
						if(temp.getNext() != null){
							temp.getNext().setPrevious(temp);
						}
					}
					temp = ptr.getPrevious();
				} else if (temp.getSalary() == ptr.getSalary()) {
					if(ptr.getAge() < temp.getAge()) {
						ptr.setPrevious(temp.getPrevious());
						temp.setPrevious(ptr);
						temp.setNext(ptr.getNext());
						ptr.setNext(temp);
						temp = ptr.getPrevious();
						if(ptr.getPrevious() == null){
							head = ptr;
						}
						if(ptr != null){
							if(ptr.getPrevious() != null) {
								ptr.getPrevious().setNext(ptr);
							}
						}
						if(temp != null){
							if(temp.getNext() != null){
								temp.getNext().setPrevious(temp);
							}
						}
					} else {
						break;
					}
				} else {
					break;
				}
			}
			ptr = ptr.getNext();
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkedList L = new LinkedList();
		int choice = 1;
		while (choice != 0) {
			System.out.println("Enter : ");
			System.out.println("ID  NAME  AGE SALARY :");
			int id = scan.nextInt();
			scan.nextLine();
			String name = scan.nextLine();
			int age = scan.nextInt();
			int salary = scan.nextInt();
			L.insertNode(id, name, salary, age);
			System.out.print("Want to insert more(Press 1) otherwise(Press 0) : ");
			choice = scan.nextInt();
		}
		L.insertionSort();
		L.displayLinkedList();
	}
}
