public class Main {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.insertLinkedList(1,0);
        doubleLinkedList.insertLinkedList(2,1);
        doubleLinkedList.insertLinkedList(3,2);
        doubleLinkedList.insertLinkedList(4,3);
        doubleLinkedList.traverseLinkedList();
        doubleLinkedList.reverseTraverseLinkedList();
    }
}
