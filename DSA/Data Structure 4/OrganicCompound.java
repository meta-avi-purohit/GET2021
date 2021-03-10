import java.util.*;

public class OrganicCompound {

	private static Map<Character, Integer> compounds = new HashMap<>();

	static {
		compounds.put('C', 12);
		compounds.put('H', 1);
		compounds.put('O', 16);
	}

	public static int molecularMass(String compound) {
		if (compound.length() == 0)
			return 1;
		int i = 0, ch = 1, result = 0;
		while (i < compound.length()) {
			int tempsum = 0;
			String number = "";
			if (compound.charAt(i) == 'C' || compound.charAt(i) == 'H'
					|| compound.charAt(i) == 'O') {
				ch = compounds.get(compound.charAt(i));
				if ((i == compound.length() - 1)
						|| (compound.charAt(i + 1) == 'C'
								|| compound.charAt(i + 1) == 'H' || compound
								.charAt(i + 1) == 'O')) {
					number += "1";
				}
				i++;
			}
			if (i < compound.length() && compound.charAt(i) >= '0'
					&& compound.charAt(i) <= '9') {
				while (i < compound.length() && compound.charAt(i) != 'C'
						&& compound.charAt(i) != 'O'
						&& compound.charAt(i) != 'H') {
					number += compound.charAt(i);
					i++;
				}

			}
			tempsum = ch * (Integer.parseInt(number));
			result += tempsum;
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Organice compound formula : ");
		String comp = scan.next();
		int i = 0, result = 0, temp1, temp2;
		while (i < comp.length()) {
			String st = "";
			String ch = "";
			if (comp.charAt(i) == '(') {
				temp1 = 0;
				temp2 = 0;
				i++;
				while (i < comp.length() && comp.charAt(i) != ')') {
					st = st + comp.charAt(i);
					i++;
				}
				temp1 += molecularMass(st);
				i++;
				while (i < comp.length() && comp.charAt(i) >= '0'
						&& comp.charAt(i) <= '9') {
					ch = ch + comp.charAt(i);
					i++;
				}
				temp2 += molecularMass(ch);
				result += (temp1 * temp2);
				st = "";
			} else {
				while (i < comp.length() && comp.charAt(i) != '(') {
					st = st + comp.charAt(i);
					i++;
				}
				result += molecularMass(st);
			}
		}
		System.out.println("Molecular Mass : " + result);
		scan.close();
	}
}
