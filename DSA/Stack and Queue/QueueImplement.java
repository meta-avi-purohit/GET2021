import java.util.*;

interface Queue {
	
	public void enQueue(int data);

	public int deQueue();

	public void displayQueue();
}

public class QueueImplement implements Queue {
	private int size, front, rear;
	private int queue[];

	QueueImplement(int size) {
		queue = new int[size];
		this.size = size;
		this.front = this.rear = -1;
	}

	/**
	 * Function to insert data in Queue
	 * 
	 * @param data
	 */
	@Override
	public void enQueue(int data) {
		if ((front == 0 && rear == size - 1)
				|| (rear == (front - 1) % (size - 1))) {
			System.out
					.println("################################################");
			System.out.println("Queue is Full");
			System.out
					.println("################################################");
		} else if (front == -1) {
			front = 0;
			rear = 0;
			queue[rear] = data;
		} else if (rear == size - 1 && front != 0) {
			rear = 0;
			queue[rear] = data;
		} else {
			rear = (rear + 1);
			if (front <= rear) {
				queue[rear] = data;
			}
			// } else {
			// queue[rear] = data;
			// }
		}
	}

	/**
	 * Delete element form the Queue
	 * 
	 * @return
	 */
	@Override
	public int deQueue() {
		int pop;
		if (front == -1) {
			System.out
					.println("################################################");
			System.out.println("Queue is Empty");
			System.out
					.println("################################################");
			return -1;
		}

		pop = queue[front];

		if (front == rear) {
			front = -1;
			rear = -1;
		} else if (front == size - 1) {
			front = 0;
		} else {
			front = front + 1;
		}
		return pop;
	}

	/**
	 * Function to Display the Queue
	 */
	@Override
	public void displayQueue() {

		if (front == -1) {
			System.out
					.println("################################################");
			System.out.println("Queue is Empty");
			System.out
					.println("################################################");
			return;
		}

		System.out.println("################################################");
		System.out.print("Elements in the  Queue are: ");

		if (rear >= front) {
			for (int i = front; i <= rear; i++) {
				System.out.print(queue[i]);
				System.out.print(" ");
			}
			System.out.println();
		} else {
			for (int i = front; i < size; i++) {
				System.out.print(queue[i]);
				System.out.print(" ");
			}
			for (int i = 0; i <= rear; i++) {
				System.out.print(queue[i]);
				System.out.print(" ");
			}
			System.out.println();
			System.out
					.println("################################################");
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter size of the queue : ");
		int size = scan.nextInt();
		QueueImplement Q = new QueueImplement(size);
		int c = 1;
		while (c == 1) {
			System.out
					.println("################################################");
			System.out.println("1 -> INSERT ELEMENT IN QUEUE");
			System.out.println("2 -> DELETE ELEMENT IN QUEUE");
			System.out.println("3 -> DISPLAY ELEMENTS IN QUEUE");
			System.out.println("4 -> EXIT");
			System.out
					.println("################################################");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				int ch = 1;
				while (ch == 1) {
					System.out.println("Enter data : ");
					int data = scan.nextInt();
					Q.enQueue(data);
					System.out
							.println("IF WANT TO INSERT MORE (Press 1 else Press 0)");
					ch = scan.nextInt();
				}
				break;
			case 2:
				ch = 1;
				while (ch == 1) {
					Q.deQueue();
					System.out
							.println("IF WANT TO DELETE MORE (Press 1 else Press 0)");
					ch = scan.nextInt();
				}
				break;
			case 3:
				Q.displayQueue();
				break;
			case 4:
				c = 0;
				break;
			default:
				System.out.println("WRONG VALUE ENTERED!!!!!!");
			}
		}
		scan.close();
	}
}
