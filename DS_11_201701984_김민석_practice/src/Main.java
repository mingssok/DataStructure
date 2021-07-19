import java.util.*;

public class Main {

	public static void main(String[] args) {
		ArrayTree a = new ArrayTree();
		
		a.run();
		System.out.println("전위");
		a.preOrder(1);
		System.out.println("\n\n중위");
		a.inOrder(1);
		System.out.println("\n\n후위");
		a.postOrder(1);

	}

}
