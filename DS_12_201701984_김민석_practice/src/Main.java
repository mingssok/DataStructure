import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		BST bst = new BST(50); // 루트 = 50
		bst.add(30);
		bst.add(20);
		bst.add(80);
		bst.add(90);
		bst.add(70);
		bst.add(10);
		
		System.out.println(bst.find(30));
		System.out.println(bst.find(100));
		
		bst.inOrder();

	}

}
