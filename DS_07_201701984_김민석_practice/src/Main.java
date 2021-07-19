import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List t1 = new ArrayList(); // 인터페이스 = new 클래스

		String[] str = {"감자", "고구마"};

		List t2 = new ArrayList(Arrays.asList(str));
		
		System.out.println(t2);
		
		
		t1.add("test");
		t1.add("test2");
		t1.add("test3");
		t1.add("test4");
		
		System.out.println(t1.get(0));
		t1.remove(2);
		System.out.println(t1); // 주소가 아닌, 값들이 한꺼번에 보임
		
		//Queue t3 = new LinkedList();
		
		//t3.add("Test");
		
		Deque dq = new LinkedList(); // 양쪽으로 삽입가능
		
		dq.add("test");
		dq.add("test2");
		dq.add("test3");
		dq.add("test4");
		dq.addFirst("tt");
				
		Iterator it = dq.iterator();
		
		while (it.hasNext()) {
			System.out.println(it.next()); // 첨엔 아무것도 안 가리키다가, next를 하면 첫번째를 가리킴 // 포와일 대체
		}

	}

}
