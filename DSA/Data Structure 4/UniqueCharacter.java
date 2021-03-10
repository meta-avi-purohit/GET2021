import java.util.*;

public class UniqueCharacter {

	private static Map<String, Integer> caches = new HashMap<>();

	public static int uniqueCharacter(String str) { 
        for (String name : UniqueCharacter.caches.keySet())  
            System.out.print(name + " ");
        System.out.println();
        for (int size : UniqueCharacter.caches.values())  
            System.out.print(size + "\t");  
        System.out.println();
		if (caches.containsKey(str)) {
			return caches.get(str);
		} else {
			Set<Character> s = new HashSet<>();
			for (int i = 0; i < str.length(); i++) {
				if(str.charAt(i)== ' ')
					i++;
				s.add(str.charAt(i));
			}
			caches.put(str, s.size());
			return s.size();
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int choice = 1;
		while(choice == 1){
		System.out.println("Enter String :");
		String str = scan.nextLine();
		int result = UniqueCharacter.uniqueCharacter(str);
		System.out.println("Total Unique Character : " + result);
		System.out.println("You Want to find more (Press 1 else Press 0) : ");
		choice = Integer.parseInt(scan.nextLine());
		}
		scan.close();
	}

}
