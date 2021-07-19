// 정렬 실습
public class Main {

	public static void main(String[] args) {
		// 버블정렬
		
		int arr[] = {5,8,5,3,21,5,6,2,1,5,6,3};
		bubbleSort(arr); // 버블정렬 : 둘을 동그랗게 묶고, 앞보다 뒤가 작으면 정렬, 아니면 넘어가고... -> O(n^2)
		
		
		for (int i = 0 ; i < arr.length ; i++) {
			System.out.println(arr[i]);
		}
	}

	
	public static void bubbleSort(int[] a) {
		for (int i = 0 ; i < a.length-1 ; i++) {
			for(int j = 1 ; j < a.length - i ; j++) { // 버블 한 번 돌면 맨 끝값은 제일 큰 값이라 조회하지 않아도 되어서 i만큼 빼주는거래 
				if (a[j] < a[j-1]) {
					int temp = a[j-1];
					a[j-1] = a[j];
					a[j] = temp;
				}
			}
		}
	}
}
