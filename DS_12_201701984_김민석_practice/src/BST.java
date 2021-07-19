
public class BST {
	Node root;

	public BST(int root) {
		this.root = new Node(root);
	}

	public boolean add(int data, Node n) {
		if (n.data == data)
			return false; // 같은원소 날리기
		else if (n.data < data) {
			// right
			if (n.right == null) {
				n.right = new Node(data); // 삽입
				return true;
			}
			add(data, n.right);
		}

		else if (n.data > data) {
			// left
			if (n.left == null) {
				n.left = new Node(data); // 삽입
				return true;
			}
			add(data, n.left);
		}
		return false;
	}

	public boolean add(int data) {
		return add(data, root); // root 삽입
	}

	public boolean find(int data, Node n) {
		try {
			if (n.data == data)
				return false; // 같은원소 날리기
			else if (n.data < data) {
				// right
				if (n.right.data == data) {
					return true;
				}
				find(data, n.right);
			}

			else if (n.data > data) {
				// left
				if (n.left.data == data) {
					return true;
				}
				find(data, n.left);
			}
			return false;
		} catch (NullPointerException e) {
			return false;
		}
	}

	public boolean find(int data) {
		return find(data, root);
	}
	
	public void inOrder(Node n) { // 정렬된 채로 출력
		if(n!= null) {
			inOrder(n.left);
			System.out.print(n.data + " ");
			inOrder(n.right);
		}
	}
	
	public void inOrder() {
		inOrder(root);
		//System.out.println();
	}
}
