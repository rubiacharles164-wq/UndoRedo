public class SingleLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public void createSingleLinkedList(int nodeValue) {
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
    }

    //insert into a linked list
    public void insertLinkedList (int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;

        if (head == null) {
            createSingleLinkedList(nodeValue);
            return;
        } else if (location == 0){
            node.next = head;
            head = node;
        } else if (location >= size) {
            node.next = null;
            tail.next = node;
            tail = node;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1){
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = tempNode.next;
            tempNode.next = node;
            node.next = nextNode;
        }
        size++;
    }

    // Traversing through a linked list
    public void traverseLinkedList (){
        if (head == null) {
            System.out.println("Linked list does not exist");
        } else {
            Node tempNode = head;
            for (int i = 0; i < size; i++){
                System.out.print(tempNode.value);
                if (i != size -1){
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;

            }
            System.out.println("\n");

        }
    }
    //Search for an element in a linked list
    public boolean searchThroughLinkList (int nodeValue){
        if (head != null){
            Node tempNode = head;
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

        Node current = head;

        for(int i = 1; i < location -1 || current != null; i++) {
            current = current.next;
        }
        System.out.println("deleted " + location);
    }




}
