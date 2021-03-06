import java.util.Scanner;

public class Marksheet {

	private float grade[];
	private int numberOfStudents;

	/**
	 * Constructor
	 * 
	 * @param length
	 * @param grade
	 */
	Marksheet(int length, float grade[]) {
		this.numberOfStudents = length;
		this.grade = grade;
	}

	/**
	 * Calculates Average Grade Of All Students
	 * 
	 * @return
	 * @throws ArithmeticException
	 */
	public float average() throws ArithmeticException {
		int sum = 0;
		for (int i = 0; i < numberOfStudents; i++) {
			sum += grade[i];
		}
		float average = sum / numberOfStudents;
		return (float) Math.round(average * 100) / 100;
	}

	/**
	 * Calculate Maximum of All Grades
	 * 
	 * @return
	 * @throws ArithmeticException
	 */
	public float maximum() throws ArithmeticException {
		float max = grade[0];
		for (int i = 0; i < numberOfStudents; i++) {
			if (max < grade[i]) {
				max = grade[i];
			}
		}
		return (float) Math.round(max * 100) / 100;
	}

	/**
	 * Calculate Minimum Of All Grades
	 * 
	 * @return
	 * @throws ArithmeticException
	 */
	public float minimum() throws ArithmeticException {
		float min = grade[0];
		for (int i = 0; i < numberOfStudents; i++) {
			if (min > grade[i]) {
				min = grade[i];
			}
		}
		return (float) Math.round(min * 100) / 100;
	}

	/**
	 * Calculate Percentage of Students Pass(Grade>=40)
	 * 
	 * @return
	 * @throws ArithmeticException
	 */
	public float percentage() throws ArithmeticException {
		float passNumber = 0;
		for (int i = 0; i < numberOfStudents; i++) {
			if (grade[i] >= 40) {
				passNumber++;
			}
		}
		float percentage = (passNumber / numberOfStudents) * 100;
		return (float) Math.round(percentage * 100) / 100;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter total number of Students : ");
		int total = scan.nextInt();
		float a[] = new float[total];
		System.out.println("Enter Greades of All Students : ");
		for (int i = 0; i < total; i++) {
			a[i] = scan.nextFloat();
		}
		Marksheet M = new Marksheet(total, a);
		System.out.println("Average : " + M.average());
		System.out.println("Maximun : " + M.maximum());
		System.out.println("Minimun : " + M.minimum());
		System.out.println("Percentage of Student Passes : " + M.percentage());
		scan.close();
	}
}
