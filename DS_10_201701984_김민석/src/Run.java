import java.util.Scanner;

public class Run {

	public void run() {

		Scanner s = new Scanner(System.in);
		Scanner str_s = new Scanner(System.in);
		int number;
		int str;
		recursive re = new recursive();

		boolean T = true;
		while (T) {
			System.out.println();
			System.out.println(" ------------------ Resursive ------------------");
			System.out.println(" 1 : 팩토리얼 | 2 : 피보나치 | 3 : 하노이탑 | 9 : quit");
			System.out.println(" ------------------------------------------------");
			number = s.nextInt();
			switch (number) {
			case 1: // factorial
				System.out.print("factorial에 값을 입력하세요. ");
				str = str_s.nextInt();
				System.out.println(re.fact(str));
				break;

			case 2: // fibonacci
				System.out.print("fibonacci에 값을 입력하세요. ");
				str = str_s.nextInt();
				System.out.println(re.fibon(str));
				break;

			case 3: // hanoi
				System.out.print("하노이에 원반 갯수를 입력하세요. ");
				str = str_s.nextInt();
				re.hanoi(str, 1, 2, 3);
				System.out.println(re.count);
				re.count = 0;
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
