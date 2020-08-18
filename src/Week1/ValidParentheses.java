package Week1;

import java.util.Stack;

/**
 * 
 * @author vbtapper
 *
 *Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * 	Input: "()"
 * 	Output: true
 * 
 * Example 2:
 *	Input: "()[]{}"
 *	Output: true
 *	
 * Example 3:
 *
 *	Input: "(]"
 *	Output: false
 *	
 * Example 4:
 *
 *	Input: "([)]"
 *	Output: false
 *
 * Example 5:
 *
 *	Input: "{[]}"
 *	Output: true
 */
public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "{[]}";
		
		System.out.println(isValid(s));
	}
	
	private static char getOpposite(char c) {
		
		switch (c) {
			case '(':
				return ')';
			
			case '[':
				return ']';
				
			case '{':
				return '}';
				
			case '}':
				return '{';
				
			case ')':
				return '(';
				
			case ']':
				return '[';
				
			default: 
				return 0;
		}
		
	}
	
	public static boolean isValid(String s) {
		
		boolean result = false;
		Stack<Character> helperStack = new Stack<Character>();
		
		helperStack.push(s.charAt(0));
		for(int i = 1; i < s.length(); i++) {
			if(helperStack.size() > 0) {
				if(helperStack.peek() == getOpposite(s.charAt(i))) {
					helperStack.pop();
				}
				else {
					helperStack.push(s.charAt(i));
				}
			}
			else {
				helperStack.push(s.charAt(i));
			}
		}
		
		if(helperStack.size() == 0)
			result = true;
		
		return result;
	}
}
