package Week2;

import java.util.Stack;

public class ReverseLinkedList {

	public static void main(String[] args) {
		

	}

	public void reverseList(ListNode head) {
        Stack<Integer> helperStack = new Stack<Integer>();
        
        while(head != null) {
        	helperStack.add(head.val);
        	
        	head = head.next;
        }
        
        System.out.println(helperStack);
    }
}
