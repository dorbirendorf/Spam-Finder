


public class Node {

	private Node next;
	private Object item;
	
	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Object getItem() {
		return item;
	}

	public void setItem(Object item) {
		this.item = item;
	}

	public Node(Object item, Node next) {
		this.item = item;
		this.next = next;
	}
}
