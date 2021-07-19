
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stack a = new arrayStack();
		System.out.println(a.size());
		a.push("dd");
		a.push("dd");
		a.push("dd");
		a.push("dd");
		a.push("dd");

		System.out.println(a.size());
		System.out.println(a.peek());
		a.pop();
		System.out.println(a.size());


	}

}
