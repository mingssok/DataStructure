
public class MinHeap implements PriorityQueue {

	Node[] arr;
	int last;

	public MinHeap() {
		this.arr = new Node[100];
		this.arr[0] = new Node(0, null);
		this.last = 1;
	}

	@Override
	public void push(Node x) {
		arr[last++] = x; // 삽입 및 인덱스 증가
		int i = last - 1; // i = 현재 인덱스를 가리킴

		while (i > 1 && arr[i / 2].number > arr[i].number) { // 부모가 자식보다 우선순위가 높다
			Node temp = arr[i]; // 자식 저장
			arr[i] = arr[i / 2]; // 부모를 자식으로 삽입
			arr[i / 2] = temp; // 자식을 부모로 삽입
			i = i / 2; // 부모노드를 가리켜 다시 while문을 돈다.
		}
	}

	@Override
	public Node pop() {
		Node result = arr[1]; // pop할 노드 저장
		if (last == 1) {
			arr[last] = null;
			return result;
		}
		arr[1] = arr[--last]; // 제일 마지막 값을 맨위로 올려줌
		arr[last] = new Node(0, null); // 마지막값 초기화

		int i = 1;
		while (true) {
			int next = i * 2; // left 자식
			if (next > arr.length)
				break; // 범위 초과 방지
			try {
				if (arr[next].number > arr[next + 1].number) { // 왼쪽 > 오른쪽 이라면
					if (arr[next + 1].number == 0) { // 초깃값 0임
						Node temp = arr[i];
						arr[i] = arr[next];
						arr[next] = temp;
						break;
					}
					next++; // 오른쪽이 0이 아니면 넘김
				}
				if (arr[next].number == 0 || arr[next].number > arr[i].number) // 왼쪽이 null이거나, 왼쪽이 루트보다 크다면
					break;
				Node temp = arr[i];
				arr[i] = arr[next];
				arr[next] = temp;
				i = next;
			} catch (NullPointerException e) {
				return result;
			}
		}
		return result;
	}

	@Override
	public Node top() {
		return arr[1];
	}

	@Override
	public int size() {
		return last - 1;
	}
}
