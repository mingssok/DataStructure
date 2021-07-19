import java.util.Random;
import java.util.Scanner;

public class Run {

	public void run() {
		
		Random rd = new Random();
		int ran[] = new int[20];
		Scanner s = new Scanner(System.in);
		Scanner str_s = new Scanner(System.in);

		int number;
		Sort sort = new Sort();

		boolean T = true;
		while (T) {
			System.out.println();
			System.out.println(" ---------------------------- Sort ----------------------------");
			System.out.println(" 1 : 합병 정렬 | 2 : 힙 정렬 | 3 : 퀵 정렬 | 4 : 랜덤배열 생성 | 9 : 종료");
			System.out.println(" --------------------------------------------------------------");
			number = s.nextInt();
			switch (number) {
			case 1: // 합병 정렬
				System.out.println("합병 정렬");
				sort.mergeSort(ran);
				sort.print(ran);
				break;

			case 2: // 힙 정렬
				System.out.println("힙 정렬");
				sort.heapSort(ran);
				sort.print(ran);
				break;

			case 3: // 퀵정렬
				System.out.println("퀵 정렬");
				sort.quickSort(ran);
				sort.print(ran);
				break;

			case 4: // 랜덤배열 생성
				for (int i = 0 ; i < 20 ; i++) {
					ran[i] = (int) (Math.random() * 100 + 1);
					System.out.print(ran[i] + " ");
				}
				System.out.println();
				break;

			case 9: // 종료
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
