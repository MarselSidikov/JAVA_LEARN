import java.util.Scanner;

class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("MENU:");
			System.out.println("1. Sum of numbers");
			System.out.println("2. Sub of numbers");
			System.out.println("3. Mult of numbers");
			System.out.println("4. Exit");

			int command = scanner.nextInt();

			switch (command) {
				case 1: {
					int a = scanner.nextInt();
					int b = scanner.nextInt();
					System.out.println(a + b);
					break;
				}
				case 2: {
					int a = scanner.nextInt();
					int b = scanner.nextInt();
					System.out.println(a - b);
					break;
				}
				case 3: {
					int a = scanner.nextInt();
					int b = scanner.nextInt();
					System.out.println(a * b);
					break;
				}
				default: {
					System.exit(0);
					break;
				}
			}
		}
	}
}