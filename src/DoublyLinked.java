/**
 * Created by Kevin on 3/14/2017.
 * • Insert a node in the list in alphabetical order
 • Find a node that matches a String
 • Traverse the list forwards and print
 • Traverse the list backwards and print
 • Delete a node from the list
 • Delete/destroy the list
 */
public class DoublyLinked {

    private Node head;
    private Node tail;
    private int size;


    public DoublyLinked(){
        head = null;
        tail = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return head == null;
    }


    public void add(String data) {
        Node newNode = new Node(data, null, null);
        Node prev = null;
        Node dummy = head;
        Node next = tail;
        size++;


        while (dummy != null && data.compareTo(dummy.getData()) <= 0) {
            prev = dummy;
            dummy = dummy.getNext();
            System.out.println("aligator");
        }
        if (prev == null) {
            head = newNode;
        }else{
           tail = newNode;
            }
System.out.println(newNode);

                }


    public void findNode(){

    }

    public void forwardTrav() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }
    public void backTrav(){

    }

    public void deleteNode(){

    }

    public void deleteList(){

    }

    public void display()
    {
        System.out.print("Doubly Linked List = ");
        if (size == 0)
        {
            System.out.print("empty\n");
            return;
        }
        if (head.getNext() == null)
        {
            System.out.println(head.getData() );
            return;
        }
        Node ptr = head;
        System.out.print(head.getData()+ " <-> ");
        ptr = head.getNext();
        while (ptr.getNext() != null)
        {
            System.out.print(ptr.getData()+ " <-> ");
            ptr = ptr.getNext();
        }
        System.out.print(ptr.getData()+ "\n");
    }
}


