
public class HashTable implements Map {

	private class Entry {
		Object key, value;

		Entry(Object k, Object v) {
			key = k;
			value = v;
		}
	}

	private Entry[] entries;
	private int size, used;
	private float loadFactor;
	private final Entry NIL = new Entry(null, null); // 객체는 존재하지만, 그 객체의 key와 value는 null인 것.

	public HashTable(int capacity, float loadFactor) {
		entries = new Entry[capacity];
		this.loadFactor = loadFactor;
	}

	public HashTable(int capacity) { // 적재율이 75%로 고정됨
		this(capacity, 0.75F);
	}

	public HashTable() { //사이즈를 정해주지 않으면 capacity = 101, loadfactor = 0.75F로 해시테이블 생성
		this(101);
	}

	private int hash(Object key) {
		if (key == null)
			throw new IllegalArgumentException();
		return (key.hashCode() & 0x7ffffff) % entries.length;
	}

	private int hash2(Object key) {
		if (key == null)
			throw new IllegalArgumentException();
		return (hash(key) * 9) % entries.length;
	}

	private int nextProbe(int h, int d, int i) { // 인덱스 연산도구
		return (h + d * i) % entries.length; // 원래 인덱스 + 해시2인덱스 * 반복횟수를 인덱스로
	}

	@Override
	public Object get(Object key) {
		int h = hash(key);
		int d = hash2(key);
		for (int i = 0; i < entries.length; i++) {
			int j = nextProbe(h, d, i);
			Entry entry = entries[j];
			if (entry == null) // 인덱스가 가리키는 곳에 찾으려는 값이 없다면 아예 그 값이 없다는 뜻이므로 null 리턴
				break;
			if (entry == NIL) // 한번 쓰여졌다가 remove된 행이라면 검색을 이어감
				continue;
			if (entry.key.equals(key)) // 찾으려는 key가 있다면 그 key의 value 리턴
				return entry.value;
		}
		return null; // failure : key not found
	}

	@Override
	public Object put(Object key, Object value) {
		if (used > loadFactor * entries.length) 
			// put 실행 전, 기준(적재율 * 행 개수)보다 사용중인 행이 더 많을 때 rehash();를 통해 공간확보 
			rehash();
		int h = hash(key); // 해시의 인덱스
		int d = hash2(key); // 해시2의 인덱스
		for (int i = 0; i < entries.length; i++) {
			int j = nextProbe(h, d, i); // 적절한 인덱스를 찾음
			Entry entry = entries[j]; // 그 인덱스의 엔트리를 저장해서 
			if (entry == null) { // 만약 그 entry가 비었다면, 값을 넣을 수 있음
				entries[j] = new Entry(key, value);
				++size;
				++used;
				return entries[j].value; // success
			}
			if (entry == NIL) // (null, null)은 계속 검색해줘야지, 거쳐간 흔적
				continue;
			if (entry.key.equals(key)) { // 만약 put하려는 Key가 이미 저장되어 있다면? 중복을 막기 위해 값을 업데이트함
				Object oldValue = entry.value;
				System.out.println(key + "의 value를 업데이트합니다.");
				System.out.println("원본 value: " + oldValue + "-> 새 value: " + value);
				entries[j].value = value;
				return oldValue;
			}
		}
		return null; // failure : table overflow
	}

	@Override
	public Object remove(Object key) {
		int h = hash(key);
		int d = hash2(key);
		for (int i = 0; i < entries.length; i++) {
			int j = nextProbe(h, d, i);
			Entry entry = entries[j];
			if (entry == null)
				break;
			if (entry == NIL)
				continue;
			if (entry.key.equals(key)) {
				Object oldValue = entry.value;
				entries[j] = NIL; // 삭제한 곳을 null로 만들지 않고, (null, null)로 만들어줌
				--size;
				return oldValue; // success
			}
		}
		return null; // failure : key not found

	}

	@Override
	public int size() {
		return size;
	}

	private void rehash() {
		Entry[] oldEntries = entries; // 기존 엔트리 저장
		entries = new Entry[2 * oldEntries.length + 1]; // 크기를 2배+1로 만듦
		for (int k = 0; k < oldEntries.length; k++) {
			Entry entry = oldEntries[k]; // 새 entry를 만들어서 값 복사
			if (entry == null || entry == NIL)
				continue;
			int h = hash(entry.key);
			int d = hash2(entry.key);
			for (int i = 0; i < entries.length; i++) {
				int j = nextProbe(h, d, i);
				if (entries[j] == null) {
					entries[j] = entry; // 값 복사
					break;
				}
			}
		}
		used = size;
	}

}
