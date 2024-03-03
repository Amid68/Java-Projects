public class Calculator {
	public Calculator() {}

	public int add(int a, int b) {
		return a + b;
	}

	public int subtract(int a, int b) {
		return a - b;
	}

	public int multiply(int a, int b) {
		return a * b;
	}

	public int divide(int a, int b) {
		return a / b;
	}

	public int modulo(int a, int b) {
		return a % b;
	}

	public static void main(String[] args) {
		Calculator myCalculator = new Calculator();
		System.out.println("5 + 7 = " + myCalculator.add(5,7));
		System.out.println("45 - 11 = " + myCalculator.subtract(45, 11));
		System.out.println("4 * 132 = " + myCalculator.multiply(4, 132));
		System.out.println("80 / 10 = " + myCalculator.divide(80, 10));
		System.out.println("67 / 5 = " + myCalculator.modulo(67, 5));
	}

}
