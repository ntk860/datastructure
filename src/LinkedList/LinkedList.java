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
}
