import java.util.*;

public class Search {

	public int linearSearch(int arr[], int element, int i, int n) {
		if (i == n) {
			return -1;
		} else if (arr[i] == element) {
			return i + 1;
		}
		return linearSearch(arr, element, i + 1, n);
	}

	public int binarySearch(int arr[], int element, int low, int high) {
		if (low > high) {
			return -1;
		}
		int mid = (low + high) / 2;
		if (arr[mid] == element)
			return mid + 1;
		if (arr[mid] < element)
			return binarySearch(arr, element, mid + 1, high);
		else
			return binarySearch(arr, element, low, mid - 1);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Search S = new Search();
		System.out.print("Enter Length of Array : ");
		int n = scan.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		System.out.println("Enter element to search : ");
		int element = scan.nextInt();
		System.out.println("####LINEAR SEARCH####");
		if (S.linearSearch(arr, element, 0, n) < 0) {
			System.out.println("Element Not Found");
		} else {
			System.out.println("Element found at : "
					+ S.linearSearch(arr, element, 0, n));
		}
		System.out.println("####BINARY SEARCH####");
		if (S.binarySearch(arr, element, 0, n - 1) < 0) {
			System.out.println("Element Not Found");
		} else {
			System.out.println("Element found at : "
					+ S.linearSearch(arr, element, 0, n));
		}
		scan.close();
	}
}
