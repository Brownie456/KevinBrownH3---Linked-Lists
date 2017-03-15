
public class DoublyLinked {

    private Node head;
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
        boolean state = false;
//if the list is empty put item into the list
        if (head == null) {
            head = newNode;
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
                    state = true;
                    break;
                }
                //if data has reached end of the list then put data here
                else if (holder.getNext() == null) {
                    holder.setNext(newNode);
                    break;
                }
                //iterates through the list
                else {
                    temp = holder;
                    holder = holder.getNext();
                }
            }
        }
            System.out.println(newNode);
            size++;
        }




    public void findNode(){

    }
//Traverse the list forward and print
    public void forwardTrav() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }
    public void backTrav(){
        Node temp = tail;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getPrev();
        }

    }

    public void deleteNode(){

    }

    public void deleteList(){

    }

    public void display()
    {
        System.out.print("Alphabetically sorted: ");
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
        System.out.print(head.getData()+ " , ");
        ptr = head.getNext();
        while (ptr.getNext() != null)
        {
            System.out.print(ptr.getData()+ " , ");
            ptr = ptr.getNext();
        }
        System.out.println(ptr.getData());
    }
}


