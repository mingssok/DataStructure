
public class Queue {
	
	Object q[]; // queue
	int size; // queue size check , index
	
	Queue() {
		this.q = new Object[100];
	}
	
	boolean push(Object obj) {
		
		if (size < 100) {
			this.q[size] = obj;
			size++;
			return true;
		} 
		return false;
	}
	
	Object pop() {
		if(q[0] != null) {
			Object temp = q[0];
			for(int i = 0 ; i < q.length ; i++) {
				if (q[i] == null) break; // null == 뒤에도 값이 없음
				q[i] = q[i+1]; // 하나씩 옮겨줌
			}
			q[size] = null;
			size--;
			return temp;
		}
		return null;
	}
	
	boolean empty() {
		return size == 0;
	}
	
	int size() {
		return size;
	}
	
	Object front() {
		if (q[0] != null) {
			return q[0];
		}
		return null;
	}
	
	Object back() {
		if(q[0] != null) {
			return q[size-1];
		} return null;
	}
}
