package LinkedList;

public class SingleLinkedList {
    public Node head;
    public Node tail;
    public int size;

    //create a linked list
    public Node createdLinkedList(int nodeValue) {
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void insertInLinkedList(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;
        if (head == null) {
            createdLinkedList(nodeValue);
            return;
        } else if (location == 0) {
            node.next = head;
            head = node;
        } else if (location >= size) {
            tail.next = node;
            node.next = null;
            tail = node;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = node;
            node.next = nextNode;
        }
        size++;
    }

    // Traverse a Linked List
    public void traverseLinkedList() {
        if (head == null) {
            System.out.println("SLL does not exist");
        } else {
            Node temNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(temNode.value);
                if (i != size - 1) {
                    System.out.print(" -> ");
                }
                temNode = temNode.next;
            }
            System.out.print("\n");
        }
    }

    // search for a Node

    public boolean searchNode(int nodeValue) {
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println("Found the node: " + tempNode.value + " at location: " + i + "\n");
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found");
        return false;
    }

    public void deleteNode(int location) {
        if (head == null) {
            System.out.println("The Linked List Does Not Exist");
            return;
        }

        if (location == 0) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else if (location >= size - 1) {
            Node tempNode = head;
            while (tempNode.next != tail) {
                tempNode = tempNode.next;
            }
            tempNode.next = null;
            tail = tempNode;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            tempNode.next = tempNode.next.next;
        }
        size--;
    }
}
