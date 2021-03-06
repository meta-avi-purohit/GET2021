import java.util.*;

public class Strings {

	/**
	 * Function To Compare if the two strings are equal or Not
	 * if equal return 1 else return 0
	 * @param str1
	 * @param str2
	 * @return
	 */
	public int compareString(String str1, String str2) {
		if (str1.length() != str2.length())
			return 0;
		int flag = 0;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				flag = 1;
				break;
			}
		}
		if (flag == 1)
			return 0;
		else
			return 1;
	}
	
	/**
	 * Function to reverse the string.
	 * @param str
	 * @return Reverse String
	 */
	public String reverse(String str){
		String reverse = "";
		for(int i = str.length()-1; i >= 0; i--)
		{
			reverse += str.charAt(i);
		}
		return reverse;
	}
	
	/**
	 * Function to find largest Word by Length in String
	 * @param str
	 * @return
	 */
	public String largestWord(String str){
		String largest = "";
		int count = 0,i,index = 0;
		for( i = 0;i<str.length();i++){
			int cnt = 0;
			while(i<str.length() && str.charAt(i) != ' ')
			{
				cnt++;
				i++;
			}
			if(count < cnt){
				count = cnt;
				index = i;
			}
		}
		for(int j = index - 1 ; count > 0;j--,count--)
		{
			largest += str.charAt(j);
		}
		largest = reverse(largest);
		return largest;
	}
	
	/**
	 * Function to Replace to all uppercase to lowercase or vice-versa
	 * @param str
	 * @return
	 */
	public String replace(String str){
		char ch[] = str.toCharArray();
		for(int i = 0; i<ch.length;i++)
		{
			if(ch[i] >= 'a' && ch[i] <= 'z')
			{
				ch[i] = (char)((int)(ch[i]) - 32);
			}
			else if(ch[i] >= 'A' && ch[i] <= 'Z')
			{
				ch[i] = (char)((int)(ch[i] + 32));
			}
		}
		String str2 = String.valueOf(ch);
		return str2;
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		Strings S = new Strings();
		System.out.println("Enter A String : ");
		String str1 = scan.nextLine();
		System.out.print("Largest Word : ");
		System.out.println(S.largestWord(str1));
		System.out.println("String After Replace : " + S.replace(str1));
		System.out.print("Reverse : ");
		System.out.println(S.reverse(str1));
		System.out.println("Enter 2nd String : ");
		String str2 = scan.nextLine();
		if(S.compareString(str1, str2) == 1)
			System.out.println("Equal Strings");
		else
			System.out.println("Strings Are Not Equal");
		scan.close();
	}
}
