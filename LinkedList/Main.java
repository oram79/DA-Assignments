package LinkedList;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.createdLinkedList(10);
        list.insertInLinkedList(20,1);
        list.insertInLinkedList(30,2);
        list.insertInLinkedList(40,3);
        list.insertInLinkedList(50,4);

        System.out.println("Linked List Before Deletion:");
        list.traverseLinkedList();

        list.deleteNode(2);
        System.out.println("Linked List After Deleting Node At Index 2:");
        list.traverseLinkedList();

        list.deleteNode(0);
        System.out.println("Linked List after deleting head:");
        list.traverseLinkedList();

        list.deleteNode(10);
        list.traverseLinkedList();
    }
}
