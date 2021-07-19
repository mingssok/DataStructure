
public class HashTable implements Map{
	
	private class Entry {
		Object key, value;
		Entry(Object k, Object v) {
			key = k;
			value = v;
		}
	}
	
	private Entry[] entries = new Entry[11];
	private int size;
	
	private int hash(Object key) {
		return (key.hashCode()&0x7ffffff) % entries.length; // size에 대한 mod연산 진행 [0~10만 나옴]
	}
	
	@Override
	public Object get(Object key) {
		// TODO Auto-generated method stub
		return entries[hash(key)].value;
	}

	@Override
	public Object put(Object key, Object value) {
		// TODO Auto-generated method stub
		entries[hash(key)] = new Entry(key, value);
		++size;
		return entries[hash(key)];
	}

	@Override
	public Object remove(Object key) {
		// TODO Auto-generated method stub
		int h = hash(key);
		Object value = entries[h].value;
		entries[h] = null;
		--size;
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

}

