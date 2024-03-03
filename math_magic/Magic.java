import java.util.Scanner;

public class Magic {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int myNumber = 0;
		do {
			System.out.println("Please enter any integer other than 0: ");
			myNumber = Integer.parseInt(scanner.nextLine());
		} while (myNumber == 0);

		int stepOne = myNumber * myNumber;
		int stepTwo = stepOne + myNumber;
		int stepThree = stepTwo / myNumber;
		int stepFour = stepThree + 17;
		int stepFive = stepFour - myNumber;
		int stepSix = stepFive / 6;

		System.out.println("After the magic trick, the number is: " + stepSix);
		System.out.println("No matter what integer you choose, it will always output 3.");
		scanner.close();
	}
}
