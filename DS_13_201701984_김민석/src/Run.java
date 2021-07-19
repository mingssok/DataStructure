import java.util.Scanner;

public class Run {

	public void run() {

		Scanner s = new Scanner(System.in);
		Scanner str_s = new Scanner(System.in);

		int number;
		MinHeap mh = new MinHeap();

		boolean T = true;
		while (T) {
			System.out.println();
			System.out.println(" ----------------- Priority Queue -----------------");
			System.out.println(" 1 : push | 2 : pop | 3 : top | 4 : size | 9 : quit");
			System.out.println(" --------------------------------------------------");
			number = s.nextInt();
			switch (number) {
			case 1: // push
				System.out.println("push 작업");
				System.out.print("우선순위 : ");
				int x = s.nextInt();
				System.out.print("작업명 : ");
				String str = str_s.nextLine();

				mh.push(new Node(x, str));

				break;

			case 2: // pop
				System.out.println("pop 작업 결과");
				try {
					Node temp = mh.pop();
					if (temp.number == 0 && temp.work == null) {
						System.out.println("pop 작업을 할 task가 없습니다.");
					} else {
						System.out.println("pop된 작업명 : " + temp.work);
						System.out.println("pop된 작업 우선순위 : " + temp.number);
					}
				} catch (NullPointerException e) {
					System.out.println("pop 작업을 할 task가 없습니다.");
				}
				break;

			case 3: // top
				
				try {
					Node temp = mh.top();
					if (temp.number == 0 && temp.work == null) {
						System.out.println("표시할 task가 없습니다.");
					} else {
						System.out.println("우선순위 : " + temp.number);
						System.out.println("작업명 : " + temp.work);
					}
				} catch (NullPointerException e) {
					System.out.println("표시할 task가 없습니다.");
				}
				break;

			case 4: // size
				System.out.println("size : " + mh.size());
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
