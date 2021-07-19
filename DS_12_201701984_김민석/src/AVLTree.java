
public class AVLTree {
	private int key, height; // key는 루트, height는 높이정보
	private AVLTree left, right; // AVL 트리의 왼쪽, 오른쪽으로 붙을 AVL트리들

	public static final AVLTree NIL = new AVLTree(); // 자식이 없을 때 대신 넣는 것

	private AVLTree(int key, AVLTree left, AVLTree right) {
		this.key = key;
		this.left = left;
		this.right = right;
		height = 1 + Math.max(left.height, right.height);
	}

	public AVLTree(int key) { // 루트만 있는 경우
		this.key = key;
		left = right = NIL; // 자식이 없으므로 NIL 삽입
	}

	public AVLTree() {
		left = right = this;
		height = -1; //
	}

	public boolean add(int key) { // 새로운 값 삽입
		int oldSize = size();
		grow(key);
		return size() > oldSize; // size가 원래보다 커지면 true 반환
	}

	public AVLTree grow(int key) {
		if (this == NIL)
			return new AVLTree(key); // NIL이면 비어있던 자리이므로 새로운 값 삽입 (그 값의 자식은 또 NIL)
		if (key == this.key)
			return this; // 원래 있던 key는 다시 삽입하지 않고, 원래 있던 Key 반환
		if (key < this.key)
			left = left.grow(key); // 루트의 왼쪽에 삽입 (새로 들어온 값 < 루트값)
		else
			right = right.grow(key); // 루트의 오른쪽에 삽입 (새로 넣을 값 > 루트값)
		rebalance(); // 다시 밸런스를 맞춰주는 함수
		height = 1 + Math.max(left.height, right.height);
		return this;
	}

	public int size() {
		if (this == NIL)
			return 0;
		return 1 + left.size() + right.size();
	}

	private void rebalance() {
		if (right.height > left.height + 1) { // right가 더 긴 경우
			if (right.left.height > right.right.height) // right.left가 더 긴 경우
				right.rotateRight(); // 오른쪽으로 회전
			rotateLeft();
		} else if (left.height > right.height + 1) { // left가 더 긴 경우
			if (left.right.height > left.left.height) // left.right가 더 긴 경우
				left.rotateLeft(); // 왼쪽으로 회전
			rotateRight();
		}
	}

	public int getHeight() {
		return height;
	}

	public AVLTree getLeft() {
		if (this == NIL)
			throw new IllegalStateException();
		return left;
	}

	public AVLTree getRight() {
		if (this == NIL)
			throw new IllegalStateException();
		return right;
	}

	public int getRoot() {
		if (this == NIL)
			return -1;
		return key;
	}

	public String toString() {
		if (this == NIL)
			return "";
		return left + " " + key + " " + right;
	}

	public void rotateLeft() { // right가 더 긴 경우
		left = new AVLTree(key, left, right.left); // left의 root는 원래 key / left.left는 원래 left / left.right는 right.left
		key = right.key; // key는 right의 key
		right = right.right; // right에는 right의 right
	}

	public void rotateRight() { // left가 더 긴 경우
		right = new AVLTree(key, left.right, right);
		key = left.key;
		left = left.left;
	}

	public boolean contains(int x) {
		if (key == x)
			return true;
		if (this == NIL)
			return false;
		return left.contains(x) || right.contains(x);
	}
}