import java.util.Scanner;

//여기가 main

public class run {
	
	public void runcalc() {
		
		Scanner s = new Scanner(System.in);
		int number, a, b;
		CalculatorTest c = new CalculatorTest();
		
		boolean T = true;
		while(T) {
			System.out.println("------------------------------------------------");
			System.out.println("1 : 더하기 / 2 : 빼기 / 3 : 곱하기 / 4 : 나누기 / 9 : 종료");
			System.out.println("-----------------------------------------------");
			
			number = s.nextInt();
			
			switch(number) {
			case 1:
				System.out.println("첫 번째 수 입력");
				a = s.nextInt();
				System.out.println("두 번째 수 입력");
				b = s.nextInt();
				c.add(a, b);
				break;
				
			case 2:
				System.out.println("첫 번째 수 입력");
				a = s.nextInt();
				System.out.println("두 번째 수 입력");
				b = s.nextInt();
				c.sub(a, b);
				break;
				
			case 3:
				System.out.println("첫 번째 수 입력");
				a = s.nextInt();
				System.out.println("두 번째 수 입력");
				b = s.nextInt();
				c.mul(a, b);
				break;
				
			case 4:
					System.out.println("첫 번째 수 입력");
					a = s.nextInt();
					System.out.println("두 번째 수 입력");
					b = s.nextInt();
					c.div(a, b);
					break;
					
			case 9:
					T = false;
					break;
			}
		}
	}

}
