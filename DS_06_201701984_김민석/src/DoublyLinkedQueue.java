import java.util.Scanner;

public class DoublyLinkedQueue implements Queue {

	Node head, tail;
	int size = 0;

	@Override
	public boolean push(Object obj) {
		Node newNode = (Node) obj;

		if (this.head == null) { // 가장 첫 번째를 헤드로 지정
			this.head = newNode;
			this.tail = newNode;
			size++;
			return true;
		} else {
			Node temp = this.head; // 헤드는 바뀌면 안 되니까 임시에 저장
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
			tail = newNode;
			newNode.prev = temp;
			size++;
			return true;
		}
	}

	@Override
	public Object pop() {
		String headData;
		
		if (size > 1) {
			headData = (String) head.data;
			head = head.next;
			head.prev = null;
			size--;
			return headData;

		} else if (size == 1) {
			headData = (String) head.data;
			head = null;
			tail = null;
			size = 0;
			return headData;

		} else {
			return null;
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean empty() {
		return head == null;
	}

	@Override
	public Object front() {
		return head.data;
	}

	@Override
	public Object back() {
		return tail.data;
	}

	@Override
	public void remove() {
		Node temp = this.head;
		Scanner a = new Scanner(System.in);
		String str;
		if (temp == null) {
			System.out.println("큐에 원소가 하나도 없습니다. 최소 1개 이상의 원소가 있어야 작동합니다.");
			return;
		}
		
		System.out.print("큐의 원소 : ");
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		
		if (size == 1) {
			System.out.println("\n큐에 " + head.data + " 밖에 없습니다. 삭제할까요? (Y/N)");
			str = a.nextLine();
			if (str.equals("Y")) {
				head = null;
				tail = null;
				size = 0;
				return;
			} else if (str.equals("N")) {
				System.out.println("되돌아갑니다.");
				return;
			} else {
				System.out.println("입력무효");
				return;
			}

		} 

		System.out.print("\n삭제할 원소를 골라주세요. ");
		str = a.nextLine();

		temp = this.head;
		while (temp != null) {
			if (temp.data.equals(str)) {
				 if (temp == head) {
					head = head.next;
					head.prev = null;
					size--;
				} else if (temp == tail) {
					temp.prev.next = null;
					tail = temp.prev;
					size--;
				} else {
					temp.prev.next = temp.next;
					temp.next.prev = temp.prev;
					size--;
				}
			}
			temp = temp.next;
		}

	}

}
