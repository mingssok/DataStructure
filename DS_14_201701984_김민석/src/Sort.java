
public class Sort {

	public void mergeSort(int[] arr) {
		sort(arr, 0, arr.length);
	}

	private void sort(int[] arr, int low, int high) {

		if (high - low < 2) { // 원소가 하나면 멈춤
			return; // 무한루프 리턴
		}

		int mid = (low + high) / 2;
		// 나눠서 두 번 재귀, divide
		sort(arr, low, mid);
		sort(arr, mid, high);
		merge(arr, low, mid, high);
	}

	private void merge(int[] arr, int low, int mid, int high) {
		int[] temp = new int[high - low];
		int t = 0; // 인덱스
		int l = low;
		int h = mid;

		while (l < mid && h < high) {
			if (arr[l] < arr[h]) {
				temp[t++] = arr[l++];
			} else {
				temp[t++] = arr[h++];
			}
		}
		while (l < mid) {
			temp[t++] = arr[l++];
		}
		while (h < high) {
			temp[t++] = arr[h++];
		}
		for (int i = low; i < high; i++) {
			arr[i] = temp[i - low];
		}
	}

	public void heapSort(int[] arr) {
		heap(arr, arr.length);

	}

	private void heap(int[] arr, int end) {
		// 최대힙 구성
		for (int i = 1; i < end; i++) {
			int c = i;
			do {
				int root = (c - 1) / 2;
				if (arr[root] < arr[c]) { // 루트가 자식보다 작다면 스왑
					int temp = arr[root];
					arr[root] = arr[c];
					arr[c] = temp;
				}
				c = root;
			} while (c != 0);
		}

		// 힙 구성
		for (int i = end - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			int root = 0;
			int c = 1;

			do {
				c = 2 * root + 1;

				if (c < i - 1 && arr[c] < arr[c + 1]) { // 왼쪽 자식이 오른쪽 자식보다 작다면
					c++;
				}

				if (c < i && arr[root] < arr[c]) {
					temp = arr[root];
					arr[root] = arr[c];
					arr[c] = temp;
				}
				root = c;

			} while (c < i);
		}
	}

	public void quickSort(int[] arr) {
		quick(arr, 0, arr.length - 1);
	}

	private void quick(int[] arr, int start, int end) {

		if (start >= end) {
			return;
		}

		int pivot = start;
		int i = start + 1;
		int j = end;
		int temp;

		while (i <= j) {
			while (i <= end && arr[i] <= arr[pivot]) {
				i++;
			}

			while (j > start && arr[j] >= arr[pivot]) {
				j--;
			}

			if (i > j) {
				temp = arr[j];
				arr[j] = arr[pivot];
				arr[pivot] = temp;
			} else {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		quick(arr, start, j - 1);
		quick(arr, j + 1, end);
	}

	public void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
