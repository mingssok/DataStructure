import java.util.Scanner;

public class Run {

	public void run() {

		Scanner s = new Scanner(System.in);
		Scanner str_s = new Scanner(System.in);
		int number;
		String str = "";
		Queue queue = new DoublyLinkedQueue();

		boolean T = true;
		while (T) {
			System.out.println();
			System.out.println(
					" ----------------------------- Doubly Linked Queue -------------------------------------");
			System.out.println(" 1 : PUSH | 2 : POP | 3 : SIZE | 4 : EMPTY | 5 : FRONT | 6 : BACK | 7 : REMOVE | 9. QUIT");
			System.out.println(
					" ---------------------------------------------------------------------------------------");
			number = s.nextInt();
			switch (number) {
			case 1: // PUSH
				System.out.print("큐에 넣을 물품을 입력해주세요. ");
				str = str_s.nextLine();
				queue.push(new Node(str));
				System.out.println("큐에 '" + str + "' 넣기 성공");
				break;

			case 2: // POP
				String data;
				data = (String) queue.pop();
				if (data == null) {
				System.out.println("[오류] : 아직 큐에 물품이 없습니다.");
					break;
				}
				System.out.print("큐에서 '" + data + "' 빼기 성공");
				break;

			case 3: // SIZE
				System.out.print("큐의 크기 : " + queue.size());
				break;
				
			case 4: // EMPTY
				if(queue.empty() == true) {
					System.out.print("큐가 비었습니다.");
				} else {
					System.out.print("큐에 물건이 들어있습니다");
				}
				break;
				
			case 5: // FRONT
				try {
					data = (String) queue.front();
				} catch (Exception e) {
					System.out.println("[오류] : 아직 큐에 물품이 없습니다.");
					break;
				}
				System.out.print("첫 번째 원소 : " + queue.front());
				break;
				
			case 6: // BACK
				try {
					data = (String) queue.back();
				} catch (Exception e) {
					System.out.println("[오류] : 아직 큐에 물품이 없습니다.");
					break;
				}
				System.out.print("마지막 원소 : " + queue.back());
				break;
				
			case 7: // REMOVE
				queue.remove();
				break;

			case 9: // QUIT
				T = false;
				s.close();
				str_s.close();
				System.out.println("큐 기능을 종료합니다.");
				break;
			default:
				System.out.println("올바른 명령어를 입력해주세요.");
			}
		}
	}

}
