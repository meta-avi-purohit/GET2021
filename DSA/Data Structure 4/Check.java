import java.util.*;

class Employee implements Comparable<Employee>{

	int empId;
	int salary;
	String name;

	public Employee(int empId, String name, int salary) {
		this.empId = empId;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public int compareTo(Employee object) {
		for (int i = 0; i < Math.min(this.name.length(),
					object.name.length()); i++) {
				if(this.name.charAt(i)>object.name.charAt(i))
					return 1;
				else if(this.name.charAt(i)<object.name.charAt(i))
					return -1;
		}
			return 0;
	}

}

public class Check  {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Employee> E = new ArrayList<Employee>();
		Map<Integer,Integer> M = new HashMap<>();
		int choice = 1;
		while(choice != 0){
		System.out.println("Enter EMPID , SALARY , NAME");
		int empid = scan.nextInt();
		int salary = scan.nextInt();
		scan.nextLine();
		String name = scan.nextLine();
		if(!M.containsKey(empid)) {
			M.put(empid, 1);
			E.add(new Employee(empid, name, salary));
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
