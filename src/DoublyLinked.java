import java.util.Scanner;

public class DoublyLinked {

    private static Node head;
    private static Node tail;
    private int size;


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
        //if the data is higher alphabetically, put it in front
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

    //Return a node from an input string, if node is not on the list ask for another node
    public static Node sToNode(String find) {
        Scanner keyboard = new Scanner(System.in);
        Node temp = head;
        Node holder = temp.getNext();
        String next;
        int x = 1;

            try {
                while (temp != null) {
                    if (find.compareTo(temp.getData()) == 0) {
                        x=2;
                        return temp;
                    } else {
                        temp = holder;
                        holder = holder.getNext();
                    }
                }
                return null;
            } catch (Exception e) {
                System.out.println("That node is not on the list");
                next = keyboard.nextLine();
            }
            return sToNode(next);
        }



//Traverse the list forward and print
    public void forwardTrav() {
        Node temp = head;
        System.out.print("Iterate Forward <-> ");
        if (temp == null){
            System.out.println("The list is empty!");
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
        while (temp != null) {
            System.out.print(temp.getData() + " <-> ");
            temp = temp.getPrev();
        }
    }
//delete node method
    public void deleteNode(Node data) {
        Node teller = data;
        Node temp = head;
        Node last = tail;
        Node next = temp.getNext();
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
            //if (last.getNext() == null){
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


    public static void deleteList(){
        Node temp = head;
        while(temp != null) {
                this.head = temp.getNext();
                temp.setPrev(null);
                size--;
            }
        {
            System.out.println("List is empty");
        }
        System.out.println("List is empty");

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


}


