import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Employee1 implements Comparable<Employee1>{

	int empId;
	int salary;
	String name;

	public Employee1(int empId, String name, int salary) {
		this.empId = empId;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public int compareTo(Employee1 object) {
		return this.empId - object.empId;
	}

}

public class Check2  {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Employee1> E = new ArrayList<Employee1>();
		Map<Integer,Integer> M = new HashMap<>();
		int choice = 1;
		while(choice != 0){
		System.out.println("Enter EMPID  , SALARY,Full NAME ");
		int empid = scan.nextInt();
		int salary = scan.nextInt();
		scan.nextLine();
		String name = scan.nextLine();
		
		if(!M.containsKey(empid)) { 
			M.put(empid, 1);
			E.add(new Employee1(empid, name, salary));
		}
		System.out.println("Want to enter more data(Press 1 OTHERWISE Press 0) :");
		choice = scan.nextInt();
		}
		Collections.sort(E);
		for(int i=0;i<E.size();i++)
			System.out.println(E.get(i).empId + " " +E.get(i).name + " " + E.get(i).salary);
		scan.close();
	}
}
