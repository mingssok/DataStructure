import java.util.Scanner;

public class Run {

	public void run() {

		Scanner s = new Scanner(System.in);
		Scanner str_s = new Scanner(System.in);
		
		int number;
		BinaryTree left_bt = new BinaryTree("F", new BinaryTree("C"), new BinaryTree("E"));
		BinaryTree right_bt = new BinaryTree("B", new BinaryTree("D"), new BinaryTree("G"));
		BinaryTree bt = new BinaryTree("A", left_bt, right_bt);
		

		boolean T = true;
		while (T) {
			System.out.println();
			System.out.println(" --------------------- BinaryTree ---------------------");
			System.out.println(" 1 : PreOrder | 2 : InOrder | 3 : PostOrder | 9 : quit");
			System.out.println(" ------------------------------------------------------");
			number = s.nextInt();
			switch (number) {
			case 1:
				System.out.println("PreOrder");
				bt.preOrder(bt);
				System.out.println();
				break;

			case 2:
				System.out.println("InOrder");
				bt.inOrder(bt);
				System.out.println();
				break;

			case 3:
				System.out.println("PostOrder");
				bt.postOrder(bt);
				System.out.println();
				break;

			case 9: // QUIT
				T = false;
				s.close();
				str_s.close();
				System.out.println("종료합니다.");
				break;
			default:
				System.out.println("올바른 명령어를 입력해주세요.");
			}
		}
	}

}
