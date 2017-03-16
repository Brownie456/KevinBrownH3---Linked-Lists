
public class DoublyLinked {

    private static Node head;
    private Node tail;
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




    public static Node sToNode(String find) {
        Node temp = head;
        Node holder = temp.getNext();
            while (holder != null) {
                if (find.compareTo(temp.getData()) == 0) {
                    return temp;
                } else {
                    temp = holder;
                    holder = holder.getNext();
                }
            }
            return null;
        }




//Traverse the list forward and print
    public void forwardTrav() {
        Node temp = head;
        System.out.print("Iterate Forward <-> ");
        while (temp != null) {
            System.out.print(temp.getData()+ " <-> ");
            temp = temp.getNext();
        }
    }
    //iterate the list backwards and print
    public void backTrav(){
        Node temp = tail;
        System.out.print("Iterate backward <-> ");
        while (temp != null) {
            System.out.print(temp.getData()+ " <-> ");
            temp = temp.getPrev();
        }

    }

    public void deleteNode(Node data) {
        Node temp = head;
        Node next = temp.getNext();
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
            this.size--;
            System.out.println("1");
            System.out.println("deleted node:"+data);
            return;
        }
            if (data.getPrev() == null){
                head = head.getNext();
                size--;
                System.out.println("2");
                System.out.println("deleted node:"+data);
                return;
            }
            if (data.getNext() == null){
                tail = tail.getPrev();
                size--;
                System.out.println("3");
                System.out.println("deleted node:"+data);
                return;
            }
            while (next != null){
            if (data.getData().compareTo(temp.getData()) == 0) {
                temp.getPrev().setNext(temp.getNext());
                temp.getNext().setPrev(temp.getPrev());
                System.out.println("4");
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



    public void deleteList(){

    }


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


