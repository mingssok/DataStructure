import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// 입출력 실습
public class Main {

	public static void main(String[] args) {
		try {
			File file = new File("./write.txt"); // 파일객체 생성, 상대경로
			BufferedWriter BR = new BufferedWriter(new FileWriter(file)); // 출력 버퍼 생성(파일라이트 한번에)

			if (file.isFile() && file.canWrite()) { // 파일객체가 있고, 파일이 write 권한이 있는지?
				BR.write("test test");
				BR.newLine(); // 개행
				BR.write("Test!");

				BR.close();
			}

		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
