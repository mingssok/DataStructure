public class LinkedlistBag implements Bag {
	
	Node head, index;
	private int size = 0;

	@Override
	public void add(Object object) {
		Node node = (Node) object;

		if (this.head == null) { // 가장 첫 번째를 헤드로 지정
			this.head = node;
			size++;
		} else {
			Node temp = this.head; // 헤드는 바뀌면 안 되니까 임시에 저장
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
			size++;
		}
		System.out.println("가방에 '" + node.data + "'을(를) 넣었습니다.");
	}

	@Override
	public void contains(Object object) {
		this.index = this.head;
		while (this.index != null) {
			if (this.index.data.equals(object)) {
				System.out.println("가방에 '" + object + "'이(가) 있습니다.");
				return;
			} else {
				this.index = this.index.next;
			}
		}
		System.out.println("오류 : 가방에 '" + object + "'이(가) 없습니다.");
	}

	@Override
	public Object getFirst() {
		this.index = this.head;
		return this.index.data;
	}

	@Override
	public Object getNext() {
		try {
			this.index = this.index.next;
		} catch (NullPointerException e) {
			throw e;
		}
		return this.index.data;
	}

	@Override
	public void remove(Object object) {
		this.index = this.head;
		Node prev = this.head;
		while (this.index != null) {
			if (this.index.data.equals(object)) {
				if (this.index.next == null) { // 다음이 없다면, 이전 인덱스 다음에 null 연결
					if (size == 1) {
						this.head = null;
					}
					prev.next = null;
				} else if (this.index == this.head) { // 처음 값을 뺀다면
					this.head = this.head.next;
				} else { // 사이에 낀 경우 ex) 1과 3 연결 등
					prev.next = this.index.next;
				}
				size--;
				System.out.println("가방에서 '" + object + "'을(를) 꺼냈습니다.");
				return;
			} else {
				prev = this.index;
				this.index = this.index.next;
			}
		}
		System.out.println("오류 : 가방에 '" + object + "'이(가) 없습니다.");

	}

	@Override
	public int size() {
		return size;
	}

}
