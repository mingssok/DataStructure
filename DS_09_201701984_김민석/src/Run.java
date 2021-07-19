import java.util.Scanner;

public class Run {

	public void run() {

		Scanner s = new Scanner(System.in);
		Scanner str_s = new Scanner(System.in);
		int number;
		String str = "", str2 = "";
		Map m = new HashTable(20);

		boolean T = true;
		while (T) {
			System.out.println();
			System.out.println(" --------------------- HashTable ---------------------");
			System.out.println(" 1 : get | 2 : put | 3 : remove | 4 : size | 9 : quit");
			System.out.println(" -----------------------------------------------------");
			number = s.nextInt();
			switch (number) {
			case 1: // get
				System.out.print("조회할 물품을 입력하세요. ");
				str = str_s.nextLine();
				if (m.get(str) != null) {
					System.out.println("<조회 성공>");
					System.out.println("key: " + str + ", value: " + m.get(str));
				} else {
					System.out.println("데이터가 없습니다.");
				}
				break;
				
			case 2: // put
				System.out.print("key를 입력하세요. ");
				str = str_s.nextLine();
				System.out.print("value를 입력하세요. ");
				str2 = str_s.nextLine();
				// Object a = m.put(str, str2);
				if (m.put(str, str2) != null) {
					System.out.println("put 성공");
				} else {
					System.out.println("put 실패");
				}
				break;
				
			case 3: // remove
				System.out.print("삭제할 key를 입력하세요. ");
				str = str_s.nextLine();
				Object b = m.remove(str);
				if (b != null) {
					System.out.println("remove 성공");
				} else {
					System.out.println("remove 실패");
				}
				break;

			case 4: // size
				System.out.println("테이블 사이즈: " + m.size());
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
