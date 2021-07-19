
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue q = new Queue();
		
		System.out.println(q.size());
		System.out.println(q.empty());

		q.push("감자");
		System.out.println(q.front());
		System.out.println(q.back());
		
		q.push("고구마");
		System.out.println(q.size());
		System.out.println(q.back());
		System.out.println(q.empty());
		q.pop();
		System.out.println(q.front());


	}

}
