import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// 입출력 실습
public class Main {

	public static void main(String[] args) {
		try {
			File file = new File("./test.txt"); // 파일객체 생성
			FileReader FR = new FileReader(file); // 입력스트림 생성, 꼭 트라이캐치문 안에서...
			BufferedReader BR = new BufferedReader(FR); // 입력 버퍼 생성
			
			String line = "";
			while ((line=BR.readLine()) != null) { // 한 줄씩 읽어오고, 널이면 종료
					System.out.println(line);
			}
		} catch(FileNotFoundException e) {
			System.out.println(e);
		} catch(IOException e) {
			System.out.println(e);
		}

	}

}
