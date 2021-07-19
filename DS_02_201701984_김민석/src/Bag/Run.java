package Bag;

import java.util.Scanner;

public class Run {

	public void run() {

		Scanner s = new Scanner(System.in);
		Scanner str_s = new Scanner(System.in);
		int number;
		String str = "";
		ArrayBag bag = new ArrayBag();

		boolean T = true;
		while (T) {
			System.out.println();
			System.out.println(
					" -----------------------------------------가방 기능 선택-------------------------------------------------");
			System.out
					.println(" 1 : 물품 추가 | 2 : 물품 조회 | 3 : 1번 물품 조회 | 4 : 다음 물품 조회 | 5 : 물품 꺼내기 | 6. 가방크기 조회 | 9. 종료");
			System.out.println(
					" -----------------------------------------------------------------------------------------------------");
			number = s.nextInt();
			switch (number) {
			case 1: // 물품추가
				System.out.print("가방에 넣을 물품을 입력해주세요. ");
				str = str_s.nextLine();
				bag.add(str);
				break;

			case 2: // 물품조회
				System.out.print("조회할 물품을 입력해주세요. ");
				str = str_s.nextLine();
				bag.contains(str);
				break;

			case 3: // 1번 물품 조회
				System.out.print("가방에 첫 번째로 들어간 물품은 " + bag.getFirst() + "입니다.");
				break;

			case 4: // 다음 물품 조회
				System.out.print("지금 조회물품의 다음물품은 " + bag.getNext() + "입니다.");
				break;

			case 5: // 물품 꺼내기
				System.out.print("가방에서 꺼낼 물품을 입력해주세요. ");
				str = str_s.nextLine();
				bag.remove(str);
				break;

			case 6: // 가방 사이즈
				System.out.print("현재 가방의 크기는 " + bag.size() + "입니다.");
				break;

			case 9: // 종료
				T = false;
				s.close();
				str_s.close();
				System.out.println("가방 기능을 종료합니다.");
				break;
			default:
				System.out.println("올바른 명령어를 입력해주세요.");
			}
		}
	}

}
