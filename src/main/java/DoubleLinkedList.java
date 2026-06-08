




public class
DoubleLinkedList {
    public DoubleNode head;
    public DoubleNode tail;
    public int size;


    public DoubleNode createSingleLinkedList(int nodeValue) {
        DoubleNode doubleNode = new DoubleNode();
        doubleNode.next = null;
        doubleNode.value = nodeValue;
        head = doubleNode;
        tail = doubleNode;
        size = 1;
        return head;
    }


    //insert into a linked list
    //1. if the link doesn't exist
    //2. inserting element at the begining
    //3. inserting element at the end
    //4. inserting anywhere else

    public void insertLinkedList (int nodeValue, int location) {
        DoubleNode doubleNode = new DoubleNode();
        doubleNode.value = nodeValue;

        if (head == null) {
            createSingleLinkedList(nodeValue);
            return;
        } else if (location == 0){
            doubleNode.next = head;
            doubleNode.previous = null;
            head = doubleNode;
        } else if (location >= size) {
            doubleNode.next = null;
            doubleNode.previous = tail;
            tail.next = doubleNode;
            tail = doubleNode;
        } else {
            DoubleNode tempNode = head;
            int index = 0;
            while (index < location - 1){
                tempNode = tempNode.next;
                index++;
            }
            DoubleNode nextNode = tempNode.next;
            doubleNode.previous = tempNode;
            doubleNode.next = tempNode.next;
            tempNode.next = doubleNode;
            doubleNode.next.previous = nextNode;
        }
        size++;
    }


    // Traversing through a linked list
    public void traverseLinkedList (){
        if (head == null) {
            System.out.println("Linked list does not exist");
        } else {
            DoubleNode tempNode = head;
            for (int i = 0; i < size; i++){
                System.out.print(tempNode.value);
                if (i != size -1){
                    System.out.print(" <-> ");
                }
                tempNode = tempNode.next;

            }
            System.out.println("\n");

        }
    }

    //Reverse Traverse

    // Traversing through a linked list
    public void reverseTraverseLinkedList (){
        if (head == null) {
            System.out.println("Linked list does not exist");
        } else {
            DoubleNode tempNode = tail;
            for (int i = 0; i < size; i++){
                System.out.print(tempNode.value);
                if (i != size -1){
                    System.out.print(" -> ");
                }
                tempNode = tempNode.previous;

            }
            System.out.println("\n");

        }

    }

    //Search for an element in a linked list
    public boolean searchThroughLinkList (int nodeValue){
        if (head != null){
            DoubleNode tempNode = head;
            for (int i = 0; i < size; i++){
                if(tempNode.value == nodeValue) {
                    System.out.println("Found the node at locations" +i+"\n");
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not Found ");
        return false;
    }

    //Delete method
    public void deleteNode (int location){
        if (head == null){
            System.out.println("list is empty");
        }
        if (location == 1){
            head = head.next;
        }
        DoubleNode current = head;

        for(int i = 1; i < location -1 || current != null; i++) {
            current = current.next;
        }
        System.out.println("deleted " + location);
    }



    //Search for an element in a double linked list
    //Delete method in a double link list

    //EXERCISE 1: given a value, search for that element and return a boolean if the element exist or not.
    //EXERCISE 2: Given a location Implement a Delete method.

}
