import java.util.Scanner;

public class ArrayTree {

	String[] arrTree;

	public void run() {
		System.out.println("원소를 입력하세요.");
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		String[] arr_input = input.split(" ");
		s.close();
		arrTree = new String[100];

		for (int i = 1; i <= arr_input.length; i++) {
			arrTree[i] = arr_input[i - 1];
		}

	}

	public void preOrder(int I) {
		if (arrTree[I] != null) {
			System.out.print(arrTree[I] + "\t");
			preOrder(2 * I); // 1 2 4 8 16 이렇게 쭉
			preOrder(2 * I+1);
		}
	}

	public void inOrder(int I) {
		if (arrTree[I] != null) {
			inOrder(2 * I); // 1 2 4 8 16 이렇게 쭉
			System.out.print(arrTree[I] + "\t");
			inOrder(2 * I+1);
		}
	}

	public void postOrder(int I) {
		if (arrTree[I] != null) {
			postOrder(2 * I); // 1 2 4 8 16 이렇게 쭉
			postOrder(2 * I+1);
			System.out.print(arrTree[I] + "\t");
		}
	}
}
