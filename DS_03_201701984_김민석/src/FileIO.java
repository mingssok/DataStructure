import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {

	static int count = 0;

	public static String[][] inputFile(String name) {
		String text_arr[][] = new String[100][2];

		try {
			count = 0;
			File file = new File("./" + name);
			FileReader FR = new FileReader(file);
			BufferedReader BR = new BufferedReader(FR);

			String line = "";
			int i = 0;

			while ((line = BR.readLine()) != null) {
				String[] tmp = line.split(" ");
				text_arr[i][0] = tmp[0];
				text_arr[i][1] = tmp[1];
				i++;
				count++;
			}
			BR.close();
			return text_arr;

		} catch (FileNotFoundException e) {
			System.out.println("\"" + name + "\" 파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println(e);
		}
		return text_arr;
	}

	public static void outputFile(String[][] file_name) {
		try {
			File file = new File("./write.txt");
			BufferedWriter BR = new BufferedWriter(new FileWriter(file));

			if (file.isFile() && file.canWrite()) {
				for (int i = 0; i < count; i++) {
					BR.write(file_name[i][0]);
					BR.write(" ");
					BR.write(file_name[i][1]);
					BR.newLine();
				}
				BR.close();
			}

			System.out.println("write.txt 가 생성되었습니다.");

		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
