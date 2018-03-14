package CodeBase.DataStructures;

import java.util.HashSet;

/**
 * Singly Linked List
 * This class implements singly linked list data structure concept.
 *
 * @author Atul Banwar
 * @version 1.0
 */
public class SinglyLinkedList<T> {
    protected static class SinglyLinkedListNode<T> {
        /**
         * Access modifier is set to public to allow extension of SinglyLinkedList functionality in CTCI problems.
         * In real world, instead of public variables, public Getter and Setter methods should be used.
         * It's avoided here to keep the implementation of new functionality in CTCI solutions simple and easy to understand.
         */
        public T data;
        public SinglyLinkedListNode next;

        SinglyLinkedListNode(T data) {
            this.data = data;
        }
    }

    protected SinglyLinkedListNode head;

    public void add(T data) {
        SinglyLinkedListNode<T> node = new SinglyLinkedListNode<>(data);

        if (head == null) {
            head = node;
        } else {
            SinglyLinkedListNode lastNode = head;
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

        SinglyLinkedListNode current = head.next;
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