import java.util.Scanner;

public class BinaryTree {

	private Object root;
	private BinaryTree left, right;

	public BinaryTree(Object root) {
		this.root = root;
	}

	public BinaryTree(Object root, BinaryTree left, BinaryTree right) {
		this.root = root;
		this.left = left;
		this.right = right;
	}

	public void preOrder(BinaryTree a) {
		if (a != null) {
			System.out.print((String) a.root + "\t");
			preOrder(a.left);
			preOrder(a.right);
		}
	}

	public void inOrder(BinaryTree a) {
		if (a != null) {
			inOrder(a.left);
			System.out.print((String) a.root + "\t");
			inOrder(a.right);
		}
	}

	public void postOrder(BinaryTree a) {
		if (a != null) {
			postOrder(a.left);
			postOrder(a.right);
			System.out.print((String) a.root + "\t");
		}
	}
}