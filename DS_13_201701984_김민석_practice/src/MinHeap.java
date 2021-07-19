
public class MinHeap {
	int arr[];
	int last; // size, index

	public MinHeap() {
		this.arr = new int[100];
		this.arr[0] = 0;
		this.last = 1;
	}

	public void push(int x) {
		arr[last++] = x; // 삽입 및 인덱스 증가
		int i = last - 1; // i = 현재 인덱스를 가리킴
		while (i > 1 && arr[i / 2] > arr[i]) {
			int temp = arr[i]; // 자식 저장
			arr[i] = arr[i / 2]; // 자식 = 부모 (부모를 자식으로 삽입)
			arr[i / 2] = temp; // 자식을 부모로 삽입
			i = i / 2; // 부모를 가리켜서 다시 조건을 돈다.
		}
	}

	public int pop() {
		int result = arr[1];
		arr[1] = arr[--last]; // 제일 마지막 값을 맨위로 올려줌
		arr[last] = 0; // 마지막값 초기화
		int i = 1;
		while (true) {
			int next = i * 2; // left 자식
			if (next > arr.length)
				break; // 범위 초과 방지
			if (arr[next] > arr[next + 1]) { // 왼오 자식 비교
				if (arr[next + 1] == 0) { // 초깃값 0임
					int temp = arr[i];
					arr[i] = arr[next];
					arr[next] = temp;
					break;
				}
				next++; // 오른쪽이 0이 아니면 넘김
			}
			if (arr[next] == 0 || arr[next] > arr[i])
				break;
			int temp = arr[i];
			arr[i] = arr[next];
			arr[next] = temp;
			i = next;
		}
		return result;
	}
}
