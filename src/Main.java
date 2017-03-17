import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		System.out.print("This program adds first names into a list alphabetically.");
		Scanner input = new Scanner(System.in);
		Scanner text = new Scanner(System.in);
		DoublyLinked test = new DoublyLinked();
		int choice = 0;
		while (choice != 7) {
			System.out.println("\nType a number 1-7 :\n" + "1 to add to list\n" + "2 to delete from list\n"
					+ "3 to traverse list forward\n" + "4 to traverse list backwards\n" + "5 to nuke the list\n" +
					"6 to find a node on the list\n" + "7 to stop the program");
			choice = input.nextInt();
			switch (choice) {
				case 1:
					System.out.println("What String would you like to add?");
					String adding = text.nextLine();
					test.add(adding);
					break;
				case 2:
					System.out.println("Which node would you like to delete");
					String del = text.nextLine();
					test.deleteNode(DoublyLinked.sToNode(del));
					break;
				case 3:
					test.forwardTrav();
					break;
				case 4:
					test.backTrav();
					break;
				case 5:
					test.deleteList(test);
					break;
				case 6:
					System.out.println("What node would you like to find?");
					String find = text.nextLine();
					test.findNode(find);
					break;
				case 7:
					System.out.println("I guess you're done");
					break;
				default:
					System.out.println("Please put a number between 1-7");
					break;
			}
		}
	}
}
