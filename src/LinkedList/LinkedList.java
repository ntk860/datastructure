package LinkedList;

public class LinkedList {

	private Node head; 
	  
	static class Node { 
        int data; 
        Node next; 
        
        Node(int d) 
        { 
            data = d; 
            next = null; 
        }  
    } 
    
    /**
     * Insert a node into the linked list
     * @param val
     */
    public void insert(int val) {
    	if(head == null) {
    		head = new Node(val);
    	}
    	else {
    		Node n = head; 
        	while(n.next != null)
        		n = n.next;
        	
        	n.next = new Node(val);
    	}
    }
    
    /**
     * Insert a node to the linked list
     * at a specific position.
     * 
     * @param val
     * @param pos
     */
    public void insert(int val, int pos) {
    	
    }
    
    /**
     * Remove a node from the linked list
     * assuming the node is present 
     * @param val
     */
    public void remove(int val) {
    	
    	Node prev = head;
    	Node n = head;
    	while(n.next != null) {
    		prev = n;
    		n = n.next;
    		
    		if(n.data == val) 
    			break;
    	}
    	
    	prev.next = n.next;
    }
    
    /**
     * Print the list to the console
     */
    public void print() {
    	Node n = head; 

    	while(n != null) {
    		System.out.print(n.data + " ");
    		n = n.next;
    	}
    	System.out.println();
    }
    
    /**
	 * You are given two non-empty linked lists representing two non-negative integers. 
	 * The digits are stored in reverse order and each of their nodes contain a single digit. 
	 * Add the two numbers and return it as a linked list.
	 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
	 */
	public static void addTwoNumbers(Node l1, Node l2) {
		Node m = l1;
		Node n = l2;
		
		int remainder = 0;
		while(m != null) {
			if(m.data + n.data >= 10) {
				System.out.println(0);
				remainder = (m.data + n.data) % 10;
			}
			else {
				System.out.println(m.data + n.data + remainder);
			}
		}
	}
    
}
