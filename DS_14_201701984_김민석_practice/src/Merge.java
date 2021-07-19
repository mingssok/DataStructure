
public class Merge {
	public void print(int[] arr) {
		for (int i = 0 ; i < arr.length ; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
 	}
	
	public void sort(int[] arr) {
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
		int t = 0;
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
		for (int i = low ; i < high ; i++) {
			arr[i] = temp[i-low];
		}
	}
}
