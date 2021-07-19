public class LinkedStack implements stack {

	Node head, top, prev;
	private int size = 0;
	
	@Override
	public boolean push(Object data) {
		Node node = (Node) data;

		if (this.head == null) { // 가장 첫 번째를 헤드로 지정
			this.head = node;
			this.top = node;
			size++;
			return true;
		} else {
			Node temp = this.head; // 헤드는 바뀌면 안 되니까 임시에 저장
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
			this.top = temp.next;
			size++;
			return true;
		}
	}

	@Override
	public Object pop() {
		if (size > 1) {
			String strTemp = (String) top.data;
			Node nodeTemp = this.head; // 헤드는 바뀌면 안 되니까 임시에 저장
			while (nodeTemp.next != null) {
				prev = nodeTemp;
				nodeTemp = nodeTemp.next;
			}
			top = prev;
			top.next = null;
			size--;
			return strTemp;

		} else if (size == 1) {
			String strTemp = (String) top.data;
			head = null;
			top = null;
			size = 0;
			return strTemp;

		} else {
			return null;
		}
	}

	@Override
	public Object peek() {
		return this.top.data;
	}

	@Override
	public int size() {
		return this.size;
	}

}
