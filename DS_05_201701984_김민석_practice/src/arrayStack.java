
public class arrayStack implements stack {
	
	private Object array[];
	int size; 
	
	arrayStack() {
		this.array = new String[100];
		this.size = -1;
	}
	
	@Override
	public Object pop() {
		if (size != -1) {
			Object temp = array[size];
			array[size] = null;
			size--;
			return temp;
		} else {
			return null;
		}
	}

	@Override
	public boolean push(Object data) {
		if (size < 100) {
			array[size+1] = data;
			size++;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Object peek() {
		if (size != -1) {
			return array[size];
		} else {
			return null;
		}
	}

	@Override
	public int size() {
		return size;
	}
	
}
