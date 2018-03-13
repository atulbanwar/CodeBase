package CodeBase.DataStructures;

/**
 * Singly Linked List
 * This class implements singly linked list data structure concept.
 *
 * @author Atul Banwar
 * @version 1.0
 */
public class SinglyLinkedList<T> {
    private static class LinkedListNode<T> {
        private T data;
        private LinkedListNode next;

        LinkedListNode(T data) {
            this.data = data;
        }
    }

    private LinkedListNode head;

    public void add(T data) {
        LinkedListNode<T> node = new LinkedListNode<>(data);

        if (head == null) {
            head = node;
        } else {
            LinkedListNode lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }

            lastNode.next = node;
        }
    }

    @Override
    public String toString() {
        if (head == null) return "<LIST IS EMPTY>";

        StringBuilder output = new StringBuilder();
        output.append(head.data);

        LinkedListNode current = head.next;
        while(current != null) {
            output.append(" -> ").append(current.data);
            current = current.next;
        }

        return output.toString();
    }
}

class SinglyLinkedListTest {
    public static void main(String args[]) {
        System.out.println("Creating Singly Linked List.");
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(2);

        System.out.println("Printing Linked List Elements:");
        System.out.println(linkedList.toString());
    }
}