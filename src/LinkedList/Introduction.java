package LinkedList;

public class Introduction {

	public static void main(String[] args) {
		LinkedList llist = new LinkedList();
		
		llist.insert(2);
		llist.insert(3);
		llist.insert(4);
		llist.insert(5);
		llist.insert(6);

		System.out.println("Printing the list");
		llist.print();
		
		System.out.println("Delete node 5");
		llist.remove(5);
		
		System.out.println("Printing without node 5");
		llist.print();
		
		//llist.addTwoNumbers();
	}

}
