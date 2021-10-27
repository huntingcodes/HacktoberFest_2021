


// Author : https://github.com/puru-vishnoi

import java.util.Scanner;
import java.util.ArrayList;
public class BalanceBracket {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("enter a string with '(', '{' or '['");
	String s = sc.nextLine();
	String y = isBalanced(s);
	System.out.println(y);
}
static String isBalanced(String s)
{
	String result = "NO";
	ArrayList<String> al = new ArrayList<String>();
	
	for(int i = 0; i < s.length(); i++)
	{
		if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
        {
			al.add(Character.toString(s.charAt(i)));
		}
		
		else if(s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']')
		{
			if(al.size() != 0 && al.get(al.size()-1).equals("(") && s.charAt(i) == ')')
			{
				al.remove(al.size()-1);
			}
			else if(al.size() != 0 && al.get(al.size()-1).equals("{") && s.charAt(i) == '}')
			{
				al.remove(al.size()-1);
			}
			else if(al.size() != 0 && al.get(al.size()-1).equals("[") && s.charAt(i) == ']')
			{
				al.remove(al.size()-1);
			}
			else
			{
				return result = "NO";
			}
		}
		
	}
	if(al.isEmpty() == true)
	{
		return result = "YES";
	}
	return result;
}
}
