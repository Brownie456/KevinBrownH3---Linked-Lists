import java.util.Scanner;

public class DoublyLinked {

    private static Node head;
    private static Node tail;
    private int size;

    //default constructor
    public DoublyLinked(){
        head = null;
        tail = null;
        size = 0;
    }

    //Add method, adds data in alphabetical order
    public void add(String data) {
        Node newNode = new Node(data, null, null);
        Node temp, holder;
        //if the list is empty put item into the list
        if (head == null) {
            head = newNode;
            tail = head;
        }
        //if the data is higher alphabetically than the head, put it in front
        else if (data.compareTo(head.getData()) <= 0) {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        } else {
            temp = head;
            holder = head.getNext();
            //if the data is lower alphabetically do this
            while (holder != null) {
                //if data is lower than previous and higher than next put data in here
                if (data.compareTo(temp.getData()) >= 0 && data.compareTo(holder.getData()) <= 0) {
                    temp.setNext(newNode);
                    newNode.setPrev(temp);
                    newNode.setNext(holder);
                    holder.setPrev(newNode);
                    break;
                }
                //if data has reached end of the list then put data here
                else if (holder.getNext() == null) {
                    holder.setNext(newNode);
                    newNode.setPrev(holder);
                    tail = newNode;
                    break;
                }
                //iterates through the list
                else {
                    temp = holder;
                    holder = holder.getNext();
                }
            }
        }

        size++;
        }

    //Turn a string into a node, if node is not on the list ask for another input
    public static Node sToNode(String find) {
        Scanner keyboard = new Scanner(System.in);
        Node temp = head;
        Node holder = temp.getNext();
        String next;

            try {
                while (temp != null) {
                    if (find.toUpperCase().compareTo(temp.getData()) == 0) {
                        return temp;
                    } else {
                        temp = holder;
                        holder = holder.getNext();
                    }
                }
                //If user inputs a value not on the list then catch the error and prompt them again
                return null;
            } catch (Exception e) {
                System.out.println("That node is not on the list, try again:");
                next = keyboard.nextLine();
            }
            return sToNode(next.toUpperCase());
        }

    //Traverse the list forward and print
    public void forwardTrav() {
        Node temp = head;
        System.out.print("Iterate Forward <-> ");
        if (temp == null){
        System.out.print("List is empty");
        }
        while (temp != null) {
            System.out.print(temp.getData()+ " <-> ");
            temp = temp.getNext();
        }
    }

    //iterate the list backwards and print
    public void backTrav() {
        Node temp = tail;
        System.out.print("Iterate backward <-> ");
        if (temp == null){
            System.out.print("List is empty");
        }
        while (temp != null) {
            System.out.print(temp.getData() + " <-> ");
            temp = temp.getPrev();
        }
    }

    //delete node method
    public void deleteNode(Node data) {
        Node temp = head;
        Node next = temp.getNext();
        //if the list is empty then tell them
        if(this.size == 0){
            System.out.println("the list is empty");
            return;
        }
        //if the list has only 1 node then delete it
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
            this.size--;
            System.out.println("deleted node:"+data);
            return;
        }
        //if the node you want to delete is head node then delete it
            if (this.head.equals(data)){
                this.head = this.head.getNext();
                this.head.setPrev(null);
                size--;
                System.out.println("deleted node:"+data);
                return;
            }
            //if the node you want to delete is tail then delete it
        if (this.tail.equals(data)){
            this.tail = this.tail.getPrev();
                this.tail.setNext(null);
                size--;
                System.out.println("deleted node:"+data);
                return;
            }
            //Rest of cases
            while (next != null){
                if (data.getData().equals(temp.getData())) {
                temp.getPrev().setNext(temp.getNext());
                temp.getNext().setPrev(temp.getPrev());
                System.out.println("deleted node:"+data);
                size--;
                return;
            }
            else {
                temp = next;
                next = next.getNext();
            }
        }
        System.out.println("Does not match any node");
            return;
    }

    //Delete the entire linked list
    public  static void deleteList(DoublyLinked any){
        //if the list is already empty then tell them
        if(any.size ==0){
            System.out.println("This list is empty");
            return;
        }
        //if the list only has 1 element then delete it
        if (any.size ==1){
            any.head=null;
            any.tail=null;
            any.size--;
            System.out.println("The list has been nuked!");
            return;
        }
        //deletes the entire list if it has more than 1 element
        while(any.head.getNext() != null) {
            any.head = any.head.getNext();
            any.head.setPrev(null);
            any.size--;
            if (any.size ==1){
                any.head = null;
                any.tail = null;
                any.size--;
                System.out.println("The list has been nuked!");
                return;
            }
        }
    }

    //Check to see if a node is on the list
    public void findNode(String find) {
        Node temp = head;
        Node holder = temp.getNext();
        while (holder != null) {
            if (find.compareTo(temp.getData()) == 0) {
                System.out.println("here is your node: " + temp);
                return;
            } else {
                temp = holder;
                holder = holder.getNext();
            }
        }
        System.out.println("Does not match any node");
        return;
    }

    //Method to return size of list
    public int getSize(){
        return size;
    }

}


