import java.util.Scanner;
class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int currentNumber = scanner.nextInt();

		int evens = 0;
		int odds = 0;
		while (currentNumber != -1) {
			if (currentNumber % 2 == 0) {
				// evens = evens + 1;
				// evens += 1;
				evens++;
			} else {
				odds++;
			}
			currentNumber = scanner.nextInt();
		}

		System.out.println("Evens count - " + evens);
		System.out.println("Odds count - " + odds);
	}
}