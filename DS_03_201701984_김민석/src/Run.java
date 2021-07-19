import java.util.Scanner;

public class Run {

	public void run() {

		Scanner s = new Scanner(System.in);
		int number;
		FileIO FIO = new FileIO();
		Sort sort = new Sort();
		String text_arr[][] = new String[100][2];
		text_arr[0][0] = null;

		boolean T = true;
		while (T) {
			System.out.println();
			System.out.println(" ------------------- 기능 선택 -------------------");
			System.out.println(" 1 : 파일 입력 | 2 : 내용 정렬 | 3 : 파일 출력 | 9. 종료");
			System.out.println(" -----------------------------------------------");
			number = s.nextInt();

			switch (number) {
			case 1: // 파일 입력
				System.out.print("파일 이름을 입력해주세요. ");
				String fileName = s.next();

				for (int i = 0; i < text_arr.length; i++) {
					text_arr[i][0] = FIO.inputFile(fileName)[i][0];
					text_arr[i][1] = FIO.inputFile(fileName)[i][1];
				}
				System.out.println("성공적으로 불러왔습니다.");
				break;

			case 2: // 내용 정렬
				if (text_arr[0][0] == null) {
					System.out.println("들어온 파일이 없습니다.");
					break;
				} else {
					sort.sort(text_arr);
				}
				break;

			case 3: // 파일 출력
				if (text_arr[0][0] == null) {
					System.out.println("들어온 파일이 없습니다.");
					break;
				} else {
					FIO.outputFile(text_arr);
				}
				break;

			case 9: // 종료
				T = false;
				s.close();
				System.out.println("기능을 종료합니다.");
				break;
			default:
				System.out.println("올바른 명령어를 입력해주세요.");
			}
		}
	}

}
