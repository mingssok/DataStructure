import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map m = new HashTable();
		
		System.out.println(m.size());
		m.put("성영준", 26);
		m.put("성영준2", 2);
		m.put("성영준3", 6);
		m.put("성영준4", 245);

		System.out.println(m.get("성영준"));
		System.out.println(m.remove("성영준"));
		System.out.println(m.size());

	}

}
