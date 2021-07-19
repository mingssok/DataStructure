import java.util.LinkedList;

// 링크드리스트 실습
public class Main {

	public static void main(String[] args) {
			LinkedList list = new LinkedList();
			
			// 5 -> 3 -> 4 - > 1
			list.add(3);
			list.add(4);
			list.addFirst(5);
			list.addLast(1);
			
			System.out.println(list.contains(10)); // boolean
			System.out.println(list.contains(1)); // boolean
			list.removeFirst();
			System.out.println(list.contains(5));

		
	}
}
