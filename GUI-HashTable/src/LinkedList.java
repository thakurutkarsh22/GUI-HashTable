
public class LinkedList<T extends Comparable<T>> {

	// Node class
	class Node {
		T data;
		Node next;

		Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	// LinkList class

	Node head;
	Node tail;
	int size;
	
	//constructors 
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	private LinkedList(Node head, Node tail, int size){
		this.head = head;
		this.tail = tail;
		this.size = size;
	}
	

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}
	
	// to diaplay LL chain output
	
	public void display() {
		Node node = this.head;

		while (node != null) {
			System.out.print(node.data + " => ");
			node = node.next;
		}

		System.out.println("END");
	}
	
	// Get first Element

	public T getFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		return this.head.data;
	}
	
	// Get Last Element

	public T getLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		return this.tail.data;
	}
	
	// Get any middle Element

	public T getAt(int idx) throws Exception {
		Node node = this.getNodeAt(idx);
		return node.data;
	}

	// Get any node
	
	private Node getNodeAt(int idx) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		if (idx < 0 || idx >= this.size()) {
			throw new Exception("Invalid arguments");
		}

		int counter = 0;
		Node retVal = this.head;
		while (counter < idx) {
			retVal = retVal.next;
			counter++;
		}

		return retVal;
	}
	
	// add at 1st position 

	public void addFirst(T item) {
		Node node = new Node(item, this.head);
		this.head = node;

		if (this.size() == 0) {
			this.tail = node;
		}

		this.size++;
	}
	
	// adding at Last Position 

	public void addLast(T item) {
		Node node = new Node(item, null);

		if (this.size() == 0) {
			this.head = this.tail = node;
		} else {
			this.tail.next = node;
			this.tail = node;
		}

		this.size++;
	}

	// adding at any random position 
	
	public void addAt(int idx, T item) throws Exception {
		if (idx < 0 || idx > this.size()) {
			throw new Exception("Invalid arguments");
		}

		if (idx == 0) {
			this.addFirst(item);
		} else if (idx == this.size()) {
			this.addLast(item);
		} else {
			Node nm1 = this.getNodeAt(idx - 1);
			Node n = nm1.next;

			Node node = new Node(item, n);
			nm1.next = node;

			this.size++;
		}
	}
	
	// Removing at 1st position

	public T removeFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		T returnVal = this.head.data;

		if (this.size() == 1) {
			this.head = this.tail = null;
		} else {
			this.head = this.head.next;
		}

		this.size--;

		return returnVal;
	}
	
	// Removing at last position
	
	public T removeLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		T retVal = this.tail.data;

		if (this.size() == 1) {
			this.head = this.tail = null;
		} else {
			Node node = this.getNodeAt(this.size() - 2);

			node.next = null;
			this.tail = node;
		}

		this.size--;

		return retVal;
	}
	
	// Removing at any position
	
	public T removeAt(int idx) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		if (idx < 0 || idx >= this.size()) {
			throw new Exception("Invalid arguments");
		}

		if (idx == 0) {
			return this.removeFirst();
		} else if (idx == this.size() - 1) {
			return this.removeLast();
		} else {
			Node nm1 = this.getNodeAt(idx - 1);
			Node n = nm1.next;
			Node np1 = nm1.next.next;

			nm1.next = np1;
			this.size--;

			return n.data;
		}
	}

	
	

}
