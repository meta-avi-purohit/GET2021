import java.util.*;

public class Area {

	private double width;
	private double radius;
	private double height;
	private double area;

	/**
	 * Calculate Area of Triangle 
	 * @param width - width of Triangle
	 * @param height - height of Triangle
	 * @return Area of type double
	 * @throws ArithmeticException
	 */
	public double triangle(double width, double height) throws ArithmeticException {
		return ((width * height) / 2);
	}

	/**
	 * Calculate Area of Rectangle 
	 * @param width - width of Rectangle
	 * @param height - height of Rectangle
	 * @return Area of type double
	 * @throws ArithmeticException
	 */
	public double rectangle(double width, double height) throws ArithmeticException {
		return (width * height);
	}
	
	/**
	 * Calculate Area Of Square
	 * @param width - width of Square
	 * @return - Area of type double
	 * @throws ArithmeticException
	 */
	public double square(double width) throws ArithmeticException {
		return (width * width);
	}

	/**
	 * Calculate Area of Circle
	 * @param radius - radius of Circle
	 * @return - Area Of Type Double
	 * @throws ArithmeticException
	 */
	public double circle(double radius) throws ArithmeticException {
		return (float)((3.14 * radius * radius) * 100 ) / 100;
	}

	/**
	 * Function to take input form user
	 * @param A - Object Of class Area
	 * @param choice 
	 */
	public static void choice(Area A, int choice) {
		Scanner scan = new Scanner(System.in);
		switch (choice) {
		case 1:
			System.out.println("Enter Width and Height of Triangle : ");
			A.width = scan.nextInt();
			A.height = scan.nextInt();
			A.area = A.triangle(A.width, A.height);
			System.out.println("Area : " + A.area);
			break;
		case 2:
			System.out.println("Enter Width and Height of Rectangle : ");
			A.width = scan.nextInt();
			A.height = scan.nextInt();
			A.area = A.rectangle(A.width, A.height);
			System.out.println("Area : " + A.area);
			break;
		case 3:
			System.out.println("Enter Width  of Square : ");
			A.width = scan.nextInt();
			A.area = A.square(A.width);
			System.out.println("Area : " + A.area);
			break;
		case 4:
			System.out.println("Enter Radius of Circle : ");
			A.radius = scan.nextInt();
			A.area = A.circle(A.radius);
			System.out.println("Area : " + A.area);
			break;
		default:
			System.out.println("Wrong value entered!!!!!");
		}
		scan.close();
	}

	/**
	 * Function to give choice for area calculation
	 * @param A
	 */
	public static void list(Area A) {
		Scanner scan = new Scanner(System.in);
		System.out.println("##########################");
		System.out.println("1 -> TRIANGLE");
		System.out.println("2 -> RECTANGLE");
		System.out.println("3 -> SQUARE");
		System.out.println("4 -> CIRCLE");
		System.out.println("##########################");
		int choice = scan.nextInt();
		choice(A, choice);
		scan.close();
	}


	public static void main(String[] args) {
		Area A = new Area();
		list(A);
	}
}
