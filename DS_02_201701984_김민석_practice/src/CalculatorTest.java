
public class CalculatorTest implements calc {

	public void add(int a, int b) {
		System.out.println(a + "+" + b + " = " + (a + b));
	}

	public void sub(int a, int b) {
		System.out.println(a + "-" + b + " = " + (a - b));

	}

	public void mul(int a, int b) {
		System.out.println(a + "*" + b + " = " + (a * b));

	}

	public void div(int a, int b) {
		try {
			System.out.println(a + "/" + b + " = " + (a / b));
		} catch (ArithmeticException e) {
			System.out.println("0으로는 나눌 수 없습니다.");
		}
	}
}
