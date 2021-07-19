import java.util.Scanner;

public class Run {

	public void run() {

		Scanner s = new Scanner(System.in);
		Scanner str_s = new Scanner(System.in);
		int number;
		String str = "";
		stack stack = new LinkedStack();

		boolean T = true;
		while (T) {
			System.out.println();
			System.out.println(
					" ------------------------------------ Linked Stack --------------------------------------------");
			System.out.println(" 1 : 물품 삽입(PUSH) | 2 : 최상단 물품 조회(PEEK) | 3 : 물품 꺼내기(POP) | 4 : 가방크기 조회(SIZE) | 9. 종료");
			System.out.println(
					" ----------------------------------------------------------------------------------------------");
			number = s.nextInt();
			switch (number) {
			case 1: // 물품추가
				System.out.print("스택에 넣을 물품을 입력해주세요. ");
				str = str_s.nextLine();
				stack.push(new Node(str));
				System.out.println(str + "를 넣었습니다.");
				break;

			case 2: // 최상단 물품조회
				try {
					stack.peek();
				} catch (Exception e) {
					System.out.println("오류 : 아직 스택에 물품이 없습니다.");
					break;
				}
				System.out.print("스택 최상위 물품은 " + stack.peek() + "입니다.");
				break;

			case 3: // 최상단 물품 꺼내기
				String data;
				try {
					data = (String) stack.pop();
				} catch (Exception e) {
					System.out.println("오류 : 아직 스택에 물품이 없습니다.");
					break;
				}
				System.out.print("스택에서 " + data + "를 꺼냈습니다.");
				break;

			case 4: // 가방 사이즈 조회
				System.out.print("현재 스택의 크기는 " + stack.size() + "입니다.");
				break;

			case 9: // 종료
				T = false;
				s.close();
				str_s.close();
				System.out.println("스택 기능을 종료합니다.");
				break;
			default:
				System.out.println("올바른 명령어를 입력해주세요.");
			}
		}
	}

}
