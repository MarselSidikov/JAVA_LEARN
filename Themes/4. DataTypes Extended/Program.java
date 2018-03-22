class Program {
	public static void main(String args[]) {
		int x = 5;
		x = x + 5;
		x = x - 5;
		x = x / 2; // x = 2
		x = 5 % 2; // x = 1
		
		// x = x / 0; - ArithmeticException
		
		double y = 5;
		y = y / 0;
		System.out.println(y);
		
		double z = 10;
		z = 0 / 10;
		System.out.println(z);
		
		boolean b = true;
		b = false;
		
		// b = 1;
		// b = 0;
		
		
	}
}