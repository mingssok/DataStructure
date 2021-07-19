
public class recursive {
	int count = 0;

	void hanoi(int n, int from, int by, int to) { // x, y, z
		count += 1;
		if (n == 1) {
			System.out.println(from + " -> " + to);
		} else {
			hanoi(n - 1, from, to, by); // x, z, y
			System.out.println(from + " -> " + to);
			hanoi(n - 1, by, from, to); // z, y, x --> y, x, z여야함
		}
	}

	long fibon(int n) {
		if (n < 1) // 0번째는 0
			return 0;
		if (n < 3) // 1~2번째는 1
			return 1;
		return fibon(n - 1) + fibon(n - 2);
	}

	int fact(int a) {
		if (a < 2) {
			return 1;
		}
		return a * fact(a - 1);
	}
}
