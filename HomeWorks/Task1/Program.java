import java.util.Scanner;
class Program {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		
		int x0 = number % 2;
		number = number / 2;
		int x1 = number % 2;
		number = number / 2;
		int x2 = number % 2;
		
		System.out.println(x2 + "" + "" + x1 + ""+ x0);
	}
}