import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {

		System.out.print("This program adds one word names into a list alphabetically.\n"+
		"The list automatically turns the strings into capital letters.");
		Scanner input = new Scanner(System.in);
		Scanner text = new Scanner(System.in);
		DoublyLinked test = new DoublyLinked();
		int choice = 0;

		//switch has 7 options, each with an associated int value
		while (choice >1 || choice <7)
		{
			try
			{
				//Menu describing possible actions
				System.out.println("\nType a number 1-7 :\n" + "1 to add to list\n" + "2 to delete from list\n"
						+ "3 to traverse list forward\n" + "4 to traverse list backwards\n" + "5 to nuke the list\n" +
						"6 to find a node on the list\n" + "7 to stop the program");
				choice = input.nextInt();

				switch (choice) {

					//case for adding Strings to the list.
					case 1:
						System.out.println("What String would you like to add?");
						String adding = text.nextLine();
						test.add(adding.toUpperCase());
						System.out.print("Added --> "+adding+" <---- to the list.");
						break;

					//case for deleting Strings from the list.
					case 2:
						if(test.getSize() == 0 ){
							System.out.println("List is empty");
							break;
						}
						System.out.println("Which node would you like to delete");
						String del = text.nextLine();
						test.deleteNode(DoublyLinked.sToNode(del.toUpperCase()));
						break;

					//case for Traversing and printing the list forward.
					case 3:
						test.forwardTrav();
						break;

					//Case for traversing and printing the list backward.
					case 4:
						test.backTrav();
						break;

					//Case for Deleting the entire list.
					case 5:
						DoublyLinked.deleteList(test);
						break;

					//Case for finding a certain Node on the list.
					case 6:
						System.out.println("What node would you like to find?");
						String find = text.nextLine();
						test.findNode(find.toUpperCase());
						break;

					//Case for ending the program.
					case 7:
						System.out.println("I guess you're done");
						return;

					default:
						System.out.println("Please put a number between 1-7");
						break;
				}
			}
			//if the user implements anything but an int, have them try again
			catch (InputMismatchException e){
				System.out.println("put an int between 1 and 7");
				input.next();
			}
		}
	}
}
