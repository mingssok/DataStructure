package Bag;

public class ArrayBag implements Bag {

	private Object[] objects = new Object[1000];
	private int size = 0, index = 0;

	@Override
	public void add(Object object) {
		String s = (String) object;
		if (s.isEmpty()) {
			System.out.println("공백은 가방에 넣을 수 없습니다.");
		} else {
			objects[index++] = object;
			++size;
			System.out.println("'" + object + "'을(를) 가방에 넣었습니다.");
		}
	}

	@Override
	public void contains(Object object) {
		for (int i = 0; i < size; i++) {
			if (objects[i].equals(object)) {
				System.out.println("가방에 '" + object + "'이(가) 있습니다.");
				return;
			}
		} 	System.out.println("오류 : 가방에 '" + object + "'이(가) 없습니다.");
	}

	@Override
	public Object getFirst() {
		index = 0;
		return objects[0];
	}

	@Override
	public Object getNext() {
		return objects[++index];
	}

	// 사과 귤 배 감 귤 귤 --> size+1 - i+1
	@Override
	public void remove(Object object) {
		for (int i = 0; i < size; i++) {
			if (objects[i].equals(object)) {
				size--;
				System.arraycopy(objects, i + 1, objects, i, (size - i));
				objects[size] = null;
				index--;
				System.out.println("가방에 들어있던 첫 번째 " + object + "을(를) 꺼냈습니다.");
				return;
			}
		}
		System.out.println("오류 : 가방에 '" + object + "'이(가) 없습니다.");
	}

	@Override
	public int size() {
		return size;
	}

}
