import java.util.Scanner;

public class Run {

	public void run() {

		Scanner s = new Scanner(System.in);
		Scanner str_s = new Scanner(System.in);
		int number;
		String str = "";
		List_Queue list = new List_Queue();

		boolean T = true;
		while (T) {
			System.out.println();
			System.out.println(" ------------------- List -------------------");
			System.out.println(" 1 : 선택조회 | 2 : 삭제 | 3 : 전체조회 | 9 : 종료");
			System.out.println(" --------------------------------------------");
			number = s.nextInt();
			switch (number) {
			case 1: // 선택조회
				System.out.print("조회할 물품을 입력하세요. ");
				str = str_s.nextLine();
				if (list.search(str) == true) {
					System.out.println("'" + str + "' 조회 성공");
				} else {
					System.out.println(str + "은(는) 없습니다.");
				}
				break;

			case 2: // 삭제
				System.out.print("삭제할 물품을 입력하세요. ");
				str = str_s.nextLine();
				if (list.remove(str) == true) {
					System.out.println("'" + str + "' 삭제 성공");
				} else {
					System.out.println(str + "은(는) 없습니다.");
				}
				break;

			case 3: // 전체조회
				System.out.println(list.searchAll());
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
