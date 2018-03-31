package CodeBase.CTCI.Ch02_Linked_Lists;

import CodeBase.DataStructures.SinglyLinkedList;
import java.util.HashSet;

/**
 * Remove Duplicates
 * Problem: Write code to remove duplicates from an unsorted linked list.
 * How would you solve this problem if a temporary buffer is not allowed.
 *
 * @author Atul Banwar
 * @version 1.0
 */
public class S01_RemoveDuplicates {
    private static LinkedListExtension<Integer> getLinkedListWithDuplicateElements() {
        LinkedListExtension<Integer> linkedList = new LinkedListExtension<>();
        linkedList.add(1);
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(1);
        linkedList.add(3);

        return linkedList;
    }

    public static void main(String args[]) {
        LinkedListExtension<Integer> linkedList = getLinkedListWithDuplicateElements();

        System.out.println("Printing Linked List: ");
        System.out.println(linkedList.toString());

        System.out.println("Approach 01: Using temporary buffer to maintain unique elements.");
        linkedList.removeDuplicates01();
        System.out.println(linkedList.toString());

        System.out.println("Approach 02: Not using Data Structure. Brute-force approach.");
        linkedList = getLinkedListWithDuplicateElements();
        linkedList.removeDuplicates02();
        System.out.println(linkedList.toString());
    }
}

/**
 * LinkedListExtension which extends SinglyLinkedList
 * Adding RemoveDuplicates functionality to SinglyLinkedList DataStructure.
 *
 * @author Atul Banwar
 * @version 1.0
 */
class LinkedListExtension<T> extends SinglyLinkedList<T> {
    /**
     * Approach 01: Using temporary buffer to maintain unique elements.
     * Description: This method removes duplicates from an unsorted linked list.
     * Logic: A HashSet is used to maintain unique elements,
     * linked list elements present in the set are removed from the list.
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    @SuppressWarnings({"unchecked"})
    void removeDuplicates01() {
        HashSet<T> hashSet = new HashSet<>();
        SinglyLinkedListNode current = head;
        SinglyLinkedListNode previous = null;

        while (current != null) {
            if (!hashSet.contains((T) current.data)) {
                hashSet.add((T) current.data);
                previous = current;
            } else {
                assert previous != null;
                previous.next = current.next;
            }

            current = current.next;
        }
    }

    /**
     * Approach 02: Not using Data Structure. Brute-force approach.
     * Description: This method removes duplicates from an unsorted linked list.
     * Logic: Using two pointers, when first pointer points to first element,
     * second pointer checks for this value from second node until the end.
     * Time complexity: O(n^2)
     * Space complexity: O(c)
     */
    @SuppressWarnings({"unchecked"})
    void removeDuplicates02() {
        SinglyLinkedListNode current = head;
        SinglyLinkedListNode previous, runner;

        while (current != null) {
            previous = current;
            runner = current.next;

            while (runner != null) {
                if (current.data == runner.data) {
                    previous.next = runner.next;
                } else {
                    previous = runner;
                }

                runner = runner.next;
            }

            current = current.next;
        }
    }
}