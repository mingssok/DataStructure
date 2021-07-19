import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		MinHeap m = new MinHeap();
		m.push(3);
		m.push(1);
		m.push(8);
		m.push(2);
		m.push(9);
		m.push(15);
		m.push(6);


		for(int i = 1; i<m.last ; i++) {
			System.out.println(m.arr[i]);
		}
		
		System.out.println("pop : " + m.pop());
		
		for(int i = 1; i<m.last ; i++) {
			System.out.println(m.arr[i]);
		}
	}

}
