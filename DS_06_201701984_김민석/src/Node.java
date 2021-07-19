
public class Node {
	Object data;
	Node next, prev;

	public Node(String data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
	
	public String toString() {
		return (String) data;
	}
}
