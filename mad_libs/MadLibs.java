import java.util.Scanner;

public class MadLibs {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String name1, name2, noun1, noun2, noun3, noun4, noun5, noun6, verb, adj1, adj2, adj3, place;
		int num = 0;

		System.out.println("Enter the name of the main character: ");
		name1 = scanner.nextLine();

		System.out.println("Enter 3 different adjectives: ");
		adj1 = scanner.nextLine();
		adj2 = scanner.nextLine();
		adj3 = scanner.nextLine();

		System.out.println("Enter a verb: ");
		verb = scanner.nextLine();

		System.out.println("Enter 6 different nouns: ");
		noun1 = scanner.nextLine();
		noun2 = scanner.nextLine();
		noun3 = scanner.nextLine();
		noun4 = scanner.nextLine();
		noun5 = scanner.nextLine();
		noun6 = scanner.nextLine();

		System.out.println("Enter the name of the second character: ");
		name2 = scanner.nextLine();

		boolean validInput = false;
		while(!validInput) {
			try {
				System.out.println("Enter an integer: ");
				num = Integer.parseInt(scanner.nextLine());
				validInput = true;
			} catch (NumberFormatException e) {
				System.out.println("That's not a valid integer! Please try again.");
			}
		}

		System.out.println("Enter a place. This could be a city, town, country or a planet: ");
		place = scanner.nextLine();

		String story = "This morning " + name1 + " woke up feeling " + adj1 + ". 'It is going to be a " + adj2 + " day!' Outside, a bunch of " + noun1 + "s were protesting to keep " + noun2 + " in stores. They began to " + verb + " to the rhythm of the " + noun3 + ", which made all the " + noun4 + "s very " + adj3 + ". Concerned, " + name1 + " texted " + name2 + ", who flew " + name1 + " to " + place + " and dropped " + name1 + " in a puddle of frozen " + noun5 + ". " + name1 + " woke up in the year " + num + ", in a world where " + noun6 + "s ruled the world.";

		System.out.println(story);
		scanner.close();
	}
}
