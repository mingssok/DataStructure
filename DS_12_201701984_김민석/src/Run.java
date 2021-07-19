import java.util.Scanner;

public class Run {

	public void run() {

		Scanner s = new Scanner(System.in);
		Scanner str_s = new Scanner(System.in);
		
		int number;
		AVLTree tree = new AVLTree(50);

		boolean T = true;
		while (T) {
			System.out.println();
			System.out.println(" ------------------------------------------------ BinaryTree ------------------------------------------------");
			System.out.println(" 1 : add | 2 : getHeight | 3 : getLeft | 4 : getRight | 5 : getRoot | 6 : showTree | 7 : contains | 9 : quit");
			System.out.println(" ------------------------------------------------------------------------------------------------------------");
			number = s.nextInt();
			switch (number) {
			case 1: // add
				System.out.print("add : ");
				int x = str_s.nextInt();
				if(tree.add(x) == true) {
					System.out.println("add 완료");
				} else {
					System.out.println("원래 존재했던 값입니다.");
				}
				System.out.println();
				break;

			case 2: // getHeight
				System.out.println("Height : " + tree.getHeight());
				System.out.println();
				break;

			case 3: // getLeft
				System.out.println("Left : " + tree.getLeft());
				System.out.println();
				break;
				
			case 4: // getRight
				System.out.println("Right : " + tree.getRight());
				System.out.println();
				break;
			
			case 5: // getRoot
				System.out.println("Root : " + tree.getRoot());
				System.out.println();
				break;
				
			case 6: // showTree
				System.out.println("tree :" + tree.toString());
				System.out.println();
				break;
				
			case 7: // contains
				System.out.print("포함여부 체크 : ");
				int y = str_s.nextInt();
				if(tree.contains(y) == true) {
					System.out.println("(" + y + ") - 존재함");
				} else {
					System.out.println("(" + y + ") - 존재하지 않음");
				}
				System.out.println();
				break;

			case 9: // exit
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
