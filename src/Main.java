
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinked test = new DoublyLinked();

		test.add("Kevin");
		test.add("Cheetos");
		test.add("Doug");
		test.add("Kalvinishere");
		test.add("Larry");
		test.add("Emma");
		test.add("Sophia");
		test.add("Zed");
		test.add("Alpaca");
		test.forwardTrav();
		System.out.println("");
		System.out.println("");
		System.out.println("");
		test.backTrav();
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		test.findNode("Kalvinishere");
		System.out.println("");
		test.findNode("kevin");
		System.out.println("");
		test.findNode("Alp");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		test.deleteNode(DoublyLinked.sToNode("asfd"));
		System.out.println("");
		System.out.println("");
		test.backTrav();
		System.out.println("");
		test.forwardTrav();
	}
}
