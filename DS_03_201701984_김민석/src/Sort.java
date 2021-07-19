
public class Sort {
	public void sort(String[][] arr) {
		String temp[];

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i + 1][0] == null) {
				break;
			}

			for (int j = 1; j < arr.length - i; j++) {
				if (arr[j][0] == null) {
					break;
				}

				if (Integer.parseInt(arr[j][0]) < Integer.parseInt(arr[j - 1][0])) {
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}

		System.out.print("파일의 내용을 정렬했습니다.");
	}
}