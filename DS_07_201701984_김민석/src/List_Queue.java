import java.util.*;

public class List_Queue {

	List list;
	String[] str = { "치킨", "만두", "피자", "김밥", "족발" };

	public List_Queue() {
		this.list = new LinkedList(Arrays.asList(str));
		str = null;
	}

	public boolean search(Object object) {
		Iterator it = list.iterator();
		while (it.hasNext()) {
			if (it.next().equals(object)) {
				return true;
			}
		}
		return false;
	}

	public boolean remove(Object object) {
		Iterator it = list.iterator();
		while (it.hasNext()) {
			if (it.next().equals(object)) {
				it.remove();
				return true;
			}
		}
		return false;
	}

	public Object searchAll() {
		return list;
	}
}